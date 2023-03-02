package BinaryTree;

public class PaperFolding {
    public static void printAllFolds(int N){
        printProcess(1,N,true);
    }

    private static void printProcess(int i, int N, boolean down) {
        if (i>N){
            return;
        }
        printProcess(i+1,N,true);
        printProcess(i+1,N,false);
    }
}
