package StringMatch;

public class KnuthMorrisPratt {
    public static int[] computeLPS(String pattern){
        int m=pattern.length();
        int[] lps=new int[m];
        int len=0;
        int i=1;
        lps[0]=0;
        while (i<m){
            if (pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else {
                if (len!=0){
                    len=lps[len-1];
                }else {
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = computeLPS(pattern);
        int i = 0;
        int j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                return i - j;
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "abcbcglx";
        String pattern = "bcgl";

        int index = search(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index " + index);
        } else {
            System.out.println("Pattern not found");
        }
    }
}
