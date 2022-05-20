/**
* Reads a .Fasta file and returns its content as a string. 
* @param  fileName  path to the Fasta file
*/

package src;
import java.io.*;
import java.util.Arrays;

public abstract class fastaToString {
    static String[] reader(String fileName) {
        // Opens file
        File myFasta=new File(fileName);
        // Creates a StringBuilder
        StringBuilder seqs = new StringBuilder();
        // Tries to open the file
        try {
            // Inspects one line at a time. Creates the line String to store each line:
            String line = null;
            // FileReader
            FileReader fileReader = new FileReader(myFasta);
             // Instantiates a BufferedReader to wrap FileReader and increase performance
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Stores line in seqs string if it is not null
            while((line = bufferedReader.readLine()) != null) {
                // Checks if it is the start of a new sequence to add it in a new line. Pattern for new sequences is >
                
                if (line.matches("(.*)>(.*)")) {
                    seqs.append("@"+ line +"\n");
                }else{
                    seqs.append(line);
                }
            
        }
        // Closes the file
        bufferedReader.close();
        // Convert stringBuilder to a String 
        String resString = seqs.toString();
        String[] res = resString.split("@");
        // Removes first empty element of array, returns array of seqs
        String[] result = Arrays.copyOfRange(res, 1, res.length);
        return result;
        }
        // Manages exceptions
        // File not found
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'"); 
            String[] res = {};
            return res;               
        }
        // Error reading file
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");  
            String[] res = {};
            return res;                  
          }
    

        
        
    }
}