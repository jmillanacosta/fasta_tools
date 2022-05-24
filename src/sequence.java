package src;

class Sequence {
    // Attributes of a sequence (an entry in a FASTA)
    String id;
    String seq;
    int length;

    public Sequence(String[] entry){
        this.seq = entry[1];
        this.id = entry[0];
        this.length = seq.length();
    }
       
}