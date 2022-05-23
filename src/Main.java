package src;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {   
        String sep = "\n- - - - - - - - - - - - - - \n";    

        String file = "my_fasta.fasta";
        System.out.println(sep + "\tFASTA TOOLS \nAnalyzing entries in " + file + sep);

        sequences mySeqs = new sequences(file);
        List<sequence> removedSeqs = mySeqs.browse("dummy");
        mySeqs.removeSeqs(removedSeqs);
        mySeqs.writeFasta();
    }
}
