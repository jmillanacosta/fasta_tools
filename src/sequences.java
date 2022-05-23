// Class is an iterable list of FASTA entries. Most program functionalities are methods here.

package src;
import java.util.*;

public class sequences implements Iterable<sequence> {
    int size = 0;
    // Array to store entries added to this list
    public Object elements[];
    //add method
    public void add(sequence seq){
        elements[size++] = seq;
    }
    // Constructor
    public sequences(String file){ 

    String[][] entries = fastaToString.reader(file);
    List<String> seen = new ArrayList<String>();
    for (String[] entry : entries){
        sequence myEntry = new sequence(entry);
        if (seen.contains(myEntry.id)){
            System.out.println("Duplicate ignored");
            
        }else{
            seqList.add(myEntry); 
            seen.add(myEntry.id);
        }
        
    }
 
    }

    // Makes class an iterable list
    public final List<sequence> seqList = new ArrayList<sequence>();

    @Override
    public Iterator<sequence> iterator() {
        return seqList.iterator();
    }


    // Method that gets the IDs of the entries
    public String getIds(){
        StringBuilder ids_build = new StringBuilder();
        int i = 0;
        for (sequence seq : seqList){
            ids_build.append("Entry " + i + ": " + seq.id + "\n\n");  
            i++;     
        }
        String ids = ids_build.toString();
        return ids;
    }

        StringBuilder length_build = new StringBuilder();
    // Method that gets the seqs of the entries
    public String getSeqs(){
        StringBuilder seqs_build = new StringBuilder();
        int i = 0;
        for (sequence seq : seqList){
            seqs_build.append("Entry " + i + "\n" + seq.id + "\n" + seq.seq + "\n\n");  
            i++;     
        }
        String seqs = seqs_build.toString();
        return seqs;
    }

    // Method that gets the length of the sequences of the entries
    public String getLength(){
        // Creates a StringBuilder to store all lengths and formatted text
        StringBuilder length_build = new StringBuilder();
        // Loops through all sequence objects in List<sequence> and retrieves seq.length
        int i = 0;
        for (sequence seq : seqList){
            length_build.append("Entry " + i + ": " + seq.id + " --> Length is " + seq.length + "\n\n");  
            i++;     
        }
        // Convert StringBuilder to String
        String length = length_build.toString();
        return length;
    }

    // Method that browses a query ID and returns the match(es)
    

    // Method that sorts the sequences by length (ascending / descending)
    public void sortLength(String order) {
        // List of int to store lengths
        List<Integer> lengths = new ArrayList<Integer>();
        for (sequence seq : seqList){
            lengths.add(seq.length);
        }
        // ascending or descending 
        Collections.sort(lengths);
        if (order == "descending"){
            Collections.reverse(lengths);
        }
        // Creates temporary List<sequence> to store sequences sorted by length
        List<sequence> newSeqList = new ArrayList<sequence>();
        // List of seen ids to avoid compile error when several entries have the same length
        List<String> seen = new ArrayList<String>();
        for (int i = 0; i < lengths.size(); i++){
            for (sequence seq : seqList){
                if (lengths.get(i) == seq.length && seen.contains(seq.id) == false){
                    newSeqList.add(seq);
                    seen.add(seq.id);
                }  
            }
        }  
        // Sets the sequences from the temporary list to the seqList to sort all entries by length
        for (int j = 0; j < newSeqList.size(); j++){
            sequence newSeq = newSeqList.get(j);
            seqList.set(j, newSeq);         
        }    
    }


}