package src;

public class Main {
    public static void main(String[] args) {
        String file = "my_fasta.fasta";
        sequences mySeqs = new sequences(file);
        System.out.println(mySeqs.getSeqs());
    }
}
