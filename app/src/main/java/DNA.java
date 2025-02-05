

public class DNA {
    public static String countNucleotides(String dna){
        int a_count = 0;
        int c_count = 0;
        int g_count = 0;
        int t_count = 0;

        for (int i = 0; i < dna.length(); i++) {
            if (dna.charAt(i) == 'A'){
                a_count += 1;
            }
            if (dna.charAt(i) == 'C'){
                c_count +=1;
            }
            if (dna.charAt(i) == 'G'){
                g_count += 1;
            }
            if (dna.charAt(i) == 'T'){
                t_count += 1;
            }
        }

        return a_count + " " + c_count + " " + g_count + " " + t_count;
    }




    public static String transcribe(String dna) {
        String rna = "";
        
        for (int i = 0; i < dna.length(); i++){
            if (dna.charAt(i) == 'T'){
                rna += 'U';
            } else {
                rna += dna.charAt(i);
            }
        }
        return rna;
    }


    public static String reverseComplement(String dna) {
        String complement = "";
        
        for (int i = dna.length() - 1; i >= 0; i--) {
            char base = dna.charAt(i);
            if (base == 'A') {
                complement = complement + 'T';
            }
            if (base == 'T') {
                complement = complement + 'A';
            }
            if (base == 'C') {
                complement = complement + 'G';
            }
            if (base == 'G') {
                complement = complement + 'C';
            }
        }
        return complement;
    }

    public static void main(String[] args) {
        System.out.println(DNA.countNucleotides("ACTG"));
        System.out.println(transcribe("GATGGAACTTGACTACGTAAATT"));
        System.out.println(reverseComplement("AAAACCCGGT"));
    }
    
}
