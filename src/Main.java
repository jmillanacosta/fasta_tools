package src;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String file = "my_fasta.fasta";
        sequences mySeqs = new sequences(file);
        System.out.println(mySeqs.getLength());
        mySeqs.sortLength("ascending");
        System.out.println(mySeqs.getLength());
        mySeqs.sortLength("descending");
        System.out.println(mySeqs.getLength());
        mySeqs.browse("seq5");
        List<sequence> a = mySeqs.browse("seq4"); 
        for (sequence seq : a){
            System.out.println(seq.id + "\n" + seq.length + "\n" + seq.seq + "\n");
        }       
    }
}
