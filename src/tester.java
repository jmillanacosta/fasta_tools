package src;

public class tester {
    public static void main(String[] args) {
        String[] res = src.fastaToString.reader("my_fasta.fasta");
        for (String a : res) {
            System.out.println("\n"+a);
        }
    }
    
}
