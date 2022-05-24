// Class is an iterable list of FASTA entries. Most program functionalities are methods here.

package src;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;

public class Sequences {
    String sep = "\n...";
    int size = 0;
    // Array to store entries added to this list
    private Object elements[];
    //add method
    public void add(Sequence seq){
        elements[size++] = seq;
    }
    // Constructor
    public Sequences(String file){ 
    String[][] entries = FastaToString.reader(file);
    List<String> seen = new ArrayList<String>();
    System.out.println(sep + "Retrieving entries" );
    int count = 0;
    int redundant = 0;
    for (String[] entry : entries){
        Sequence myEntry = new Sequence(entry);
        if (seen.contains(myEntry.id)){
            System.out.println("Redundant entry with identifier " + myEntry.id + " ommited.");
            redundant++;
            
        }else{
            seqList.add(myEntry); 
            seen.add(myEntry.id);
            count++;
        }

        
    }
    System.out.println(count +  " entries identified. " + redundant + " redundant entries ommited");
    }

    // Makes a list
    public final List<Sequence> seqList = new ArrayList<Sequence>();




    // Method that gets the IDs of the entries
    public String getIds(){
        StringBuilder ids_build = new StringBuilder();
        ids_build.append(sep + "List of entries" );
        int i = 0;
        for (Sequence seq : seqList){
            ids_build.append("Entry " + i + ": " + seq.id + "\n\n");  
            i++;     
        }
        String ids = ids_build.toString();
        return ids;
    }

    // Method that gets the seqs of the entries
    public String getSeqs(){
        StringBuilder seqs_build = new StringBuilder();
        seqs_build.append(sep + "Sequence view" );
        int i = 0;
        for (Sequence seq : seqList){
            seqs_build.append("Entry " + i + "\n" + seq.id + "\n" + seq.seq + "\n\n");  
            i++;     
        }
        String seqs = seqs_build.toString();
        return seqs;
    }

    // Method that gets the length of the Sequences of the entries
    public String getLength(){
        // Creates a StringBuilder to store all lengths and formatted text
        StringBuilder length_build = new StringBuilder();
        length_build.append(sep + "Length view" );
        // Loops through all Sequence objects in List<Sequence> and retrieves seq.length
        int i = 0;
        for (Sequence seq : seqList){
            length_build.append("Entry " + i + ": " + seq.id + " --> Length is " + seq.length + "\n\n");  
            i++;     
        }
        // Convert StringBuilder to String
        String length = length_build.toString();
        return length;
    }

    // Method that browses a query ID and returns the match(es)
    public List<Sequence> browse(String idPattern){
        List<Sequence> results = new ArrayList<Sequence>();
        Pattern pattern = Pattern.compile(idPattern, Pattern.CASE_INSENSITIVE);
        for (Sequence seq : seqList) {
            Matcher matcher = pattern.matcher(seq.id);
            boolean matchFound = matcher.find();
            if (matchFound == true){
                results.add(seq);
                System.out.println("\t" + seq.id);
            }
        }
        if (results.isEmpty()){
            System.out.println("No matches found for " + idPattern);
        }
        
        return results;
    }
    
    // Method to remove browsed Sequences
    public void removeSeqs(List<Sequence> seqsRemove){
        System.out.println("\n");
        for (int i = 0; i < seqsRemove.size(); i++) {
            Sequence seq = seqsRemove.get(i);
            if (seqList.contains(seq)){
                seqList.remove(seq);
                System.out.println("Removed entry: " + seq.id);
            }
        }
    }

    // Method that sorts the Sequences by length (ascending / descending)
    public void sortLength(String order) {
        System.out.println(sep + "Sort " + order );
        // List of int to store lengths
        List<Integer> lengths = new ArrayList<Integer>();
        for (Sequence seq : seqList){
            lengths.add(seq.length);
        }
        // ascending or descending 
        Collections.sort(lengths);
        if (order == "descending"){
            Collections.reverse(lengths);
        }
        // Creates temporary List<Sequence> to store Sequences sorted by length
        List<Sequence> newSeqList = new ArrayList<Sequence>();

        // List of seen ids to avoid compile error when several entries have the same length
        List<String> seen = new ArrayList<String>();
        for (int i = 0; i < lengths.size(); i++){
            for (Sequence seq : seqList){
                if (lengths.get(i) == seq.length && seen.contains(seq.id) == false){
                    newSeqList.add(seq);
                    seen.add(seq.id);
                }
            }
        }

        // Sets the Sequences from the temporary list to the seqList to sort all entries by length
        for (int j = 0; j < newSeqList.size(); j++){
            Sequence newSeq = newSeqList.get(j);
            seqList.set(j, newSeq);         
        }      
        System.out.println("Successfully sorted entries in " + order + " order");

    }

    // Method to update the Fasta file
    public void writeFasta(String outFile){
        StringBuilder seqs_build = new StringBuilder();
        for (Sequence seq : seqList){
            seqs_build.append(seq.id + "\n" + seq.seq + "\n");     
        }
        String seqs = seqs_build.toString();
        System.out.println("File " + outFile + " updated/created");
        try {
            File myFasta=new File(outFile);
            FileWriter f = new FileWriter(myFasta, false);
            f.write(seqs);
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }      
    }
    
}