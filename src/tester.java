package src;

public class tester {
    public static void main(String[] args) {
        String[][] res = src.fastaToString.reader("my_fasta.fasta");
        for (String[] idx : res){
            System.out.println(idx[0]+"\n"+idx[1]+"\n_____");
        }
    }
    
}
