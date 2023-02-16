package BasicAlgorithm;

public class DynamicProgramming {
    public static void main(String[] args) {
        int result=lcs("LACDF","CDF");
        System.out.println(result);
    }
    public static int lcs(String s1,String s2){
        int m=s1.length();
        int n=s2.length();

        int[][] memo=new int[m+1][n+1];
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    memo[i][j] = memo[i-1][j-1] + 1;
                }else {
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);  // if the characters don't match, take the maximum LCS from the previous row or column
                }
            }
        }
        return memo[m][n];
    }
}