package src;



public class stringToArray {
    static String[][] makeArray(String[] fastaString) {

        String[][] result = new String[fastaString.length][1];
        int i = 0;
        for (String seq : fastaString) {
            if (seq != null || seq != "") {               
                String[] item = seq.split("\\n");
                result[i] = item;
            }

            i++;
        }

        return result;
    }
    public static void main(String[] args) {
        String[] res = src.fastaToString.reader("my_fasta.fasta");
        String[][] result = makeArray(res);

        for (String[] idx : result){
            System.out.println(idx[0]+"\n"+idx[1]+"\n_____");
        }
    }
}