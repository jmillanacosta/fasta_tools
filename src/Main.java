package src;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {   
        String sep = "\n- - - - - - - - - - - - - - \n"; 
        String file = args[0];
        System.out.println(sep + "\tFASTA TOOLS \nAnalyzing entries in " + file + sep);
        sequences mySeqs = new sequences(file);
        String option = args[1];
        String p = args[2];
        String outFile = args[3];
        System.out.println(file + "  " + option + "  " + p + "  " + outFile);

//if (option == "r"){
//    System.out.print("\nr - Remove entries from file.");
//    System.out.println("The following entries match the pattern (" + p + ") and will be removed:");
//    List<sequence> removedSeqs = mySeqs.browse(p);
//    mySeqs.removeSeqs(removedSeqs);
//    mySeqs.writeFasta(outFile);  
//
//}    
        
    }
    
}
