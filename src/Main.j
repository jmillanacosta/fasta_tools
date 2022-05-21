package src;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Parse FASTA into String array
        String[][] entries = src.fastaToString.reader("my_fasta.fasta");    
        // Creates a list to construct all individual entries from the array of entries
        List<sequence> sequences = new ArrayList<sequence>();
        for (String[] entry : entries){
            sequences.add(new sequence(entry));
        }
        


    }
    
}
