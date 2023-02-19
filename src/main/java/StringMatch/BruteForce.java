package StringMatch;

public class BruteForce {
    public static int search(String text,String pattern){
        int n=text.length();
        int m=pattern.length();
        for (int i = 0; i <= n-m; i++) {
            int j;
            for (j  = 0; j < m; j++) {
                if (text.charAt(i+j)!=pattern.charAt(j)){
                    break;
                }
            }
            if (j==m){
                return i;
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
