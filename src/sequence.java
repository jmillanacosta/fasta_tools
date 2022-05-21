package src;

class sequence {
    // Attributes of a sequence (an entry in a FASTA)
    String id;
    String seq;
    int length;

    public String getSeq(String[] entry){
        String seq = entry[1];
        return seq;
    }
    public String getId(String[] entry){
        String seqId = entry[0];
        return seqId;
    }
    public int getLength(String seq){
        int seqLength = seq.length();
        return seqLength;
    }
    public sequence(String[] entry){
        seq = getSeq(entry);
        id = getId(entry);
        length = getLength(seq);
    }

     

    
    
}
