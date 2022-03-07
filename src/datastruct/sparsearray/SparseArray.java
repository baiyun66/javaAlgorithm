package datastruct.sparsearray;

public class SparseArray {
    public static void main(String[] args){
        //原始数组
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始数组");
        for(int[] row:chessArr1){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.print("\n");
        }

        //把转换为稀疏数组
        int sum = 0;
        for(int i =0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int q = 1;
        for(int i =0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    sparseArray[q][0] = i;
                    sparseArray[q][1] = j;
                    sparseArray[q][2] = chessArr1[i][j];
                    q++;
                }
            }
        }
        System.out.println("稀疏数组");
        for(int[] row:sparseArray){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.print("\n");
        }

        //稀疏数组恢复
        int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];

        for(int i =0;i<sparseArray[0][2];i++){
            chessArray2[sparseArray[i+1][0]][sparseArray[i+1][1]] = sparseArray[i+1][2];
        }
        System.out.println("恢复数组");
        for(int[] row:chessArray2){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.print("\n");
        }




    }
}
