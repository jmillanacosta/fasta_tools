package src;
import java.util.ArrayList;
import java.util.Collections;
public class FastaTools {
    
    public static void main(String[] args) {   
    // Argument string and formatting output
    String sep = "\n- - - - - - - - - - - - - - \n"; 
    String file = args[0].toString();
    System.out.println(sep + "\tFastaTools \nAnalyzing entries in " + file + sep);
    Sequences mySeqs = new Sequences(file);
    String option = args[1].toString();
    String p = args[2].toString();
    String outFile = args[3].toString();
    System.out.println("Analyzed fasta: " + file + " | option: " + option + " | pattern: " + p + " | out file: " + outFile);
    ArrayList<String> options = new ArrayList<>(5);
    Collections.addAll(options, "r", "b", "sa", "sd");


    

    // Select option 
    if (options.contains(option)){
            // Removing an entry
    if (option.equals("r")){
        if (args.length == 4){
            System.out.println("\nr - Remove entries from file.");
            System.out.println("The following entries match the pattern (" + p + ") and will be removed:");
            mySeqs.removeSeqs(mySeqs.browse(p));
            System.out.println("\n");
            mySeqs.writeFasta(outFile);  
        }


    }    
    // Sorting entries
    if (option.equals("sd") || option.equals("sa")){
        String order = "invalid";
        if (option.equals("sa")){
            order = "ascending";
        }
        if (option.equals("sd")){
            order = "descending";
        }
            System.out.println("\n" + option + "- Sort entries in " + order + " order");
            mySeqs.sortLength(order);
            mySeqs.writeFasta(outFile);
    }
    
    
       
    // Browsing entries
    if (option.equals("b")) {
        System.out.println("\nb - Browse pattern '" + p + "'. The following entries match the pattern:");
        mySeqs.browse(p); 
        System.out.print("Storing entries in " + outFile);
    }   

    }else{
        System.out.println("\nOption argument '" + option + "' is invalid.\nType FastaTools h for help. \nAdmitted option arguments are:"+
            "\n\t* b: Browse sequences containing a single pattern on their id." +
            "\n\t* r: Remove sequences containing a single pattern on their id." +
            "\n\t* sa | sd: Sort sequences in ascending or descending order" +
            "\n\t* r: Remove sequences containing a single pattern on their id.\n");
    }


    }
}
