package src;

public class Main {
    
    public static void main(String[] args) {   
    String sep = "\n- - - - - - - - - - - - - - \n"; 
    String file = args[0].toString();
    System.out.println(sep + "\tFASTA TOOLS \nAnalyzing entries in " + file + sep);
    sequences mySeqs = new sequences(file);
    String option = args[1].toString();
    String p = args[2].toString();
    String outFile = args[3].toString();
    System.out.println(file + "  " + option + "  " + p + "  " + outFile);
    if (option.equals("r")){
        System.out.println("\nr - Remove entries from file.");
        System.out.println("The following entries match the pattern (" + p + ") and will be removed:");
        mySeqs.removeSeqs(mySeqs.browse(p));
        System.out.println("\n");
        mySeqs.writeFasta(outFile);  

    }    
        
    }
    
}
