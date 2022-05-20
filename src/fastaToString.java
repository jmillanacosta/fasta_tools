/**
* Reads a .Fasta file and returns its content as a string. 
* @param  fileName  path to the Fasta file
*/

package src;
import java.io.*;


public class fastaToString {
    static String reader(String fileName) {
        // Opens file
        File myFasta=new File(fileName);
        // Creates a result object
        String result = "";
        // Tries to open the file
        try {
            // Inspects a line at a time
            String line = null;
            // FileReader
            FileReader fileReader = new FileReader(myFasta);
             // Always wrap FileReader in BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Stores line in result string if it is not null
            while((line = bufferedReader.readLine()) != null) {
                result.concat(line);
                
        }
        // Closes the file
        bufferedReader.close();
        }
        // Manages exceptions
        // File not found
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        // Error reading file
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
          }
        
        return result;
    }

}