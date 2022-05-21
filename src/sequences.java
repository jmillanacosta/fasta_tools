// Create a List of entries

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
        for (String[] entry : entries){
            sequence myEntry = new sequence(entry);
            seqList.add(myEntry);
        }
    }
    // Makes class iterable
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
            ids_build.append("Sequence identifier " + i + ": " + seq.id + "\n");  
            i++;     
        }
        String ids = ids_build.toString();
        return ids;
    }
}