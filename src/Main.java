package src;

public class Main {
    public static void main(String[] args) {
        String file = "my_fasta.fasta";
        sequences mySeqs = new sequences(file);
        System.out.println(mySeqs.getLength());
        mySeqs.sortLength("ascending");
        System.out.println("____________\n" +mySeqs.getLength());
        mySeqs.sortLength("descending");
        System.out.println("____________\n" +mySeqs.getLength());
        
        
    }
}
