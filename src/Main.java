package src;

public class Main {
    
    public static void main(String[] args) {   
        String sep = "\n- - - - - - - - - - - - - - \n";    

        String file = "try3.fasta";
        System.out.println(sep + "\tFASTA TOOLS \nAnalyzing entries in " + file + sep);
        sequences mySeqs = new sequences(file);
        mySeqs.writeFasta();        
    }
}
