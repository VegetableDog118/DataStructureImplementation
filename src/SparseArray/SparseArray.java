package SparseArray;
public class SparseArray{
    public static void main(String[] args) {
        //创建棋盘数组
        int[][] chessboard = new int[11][11];
        //0表式没有子 1表示黑子 2表示白子
        chessboard[1][3] = 1;
        chessboard[2][5] = 2;

        //打印棋盘
        for(int[] row : chessboard){
            for(int data : row){
                System.out.print(" " + data + " ");
            }
            System.out.println();
        }

        //遍历二维数组得到有效的棋子数
        System.out.println();
        System.out.println();

        int sum = 0;
        for(int[] row : chessboard){
            for(int data : row){
                if(data != 0){
                    sum++;
                }
            }
        }

        //创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3]; //第一个表示有几个一维数组；第二个表示一个一维数组里有几个元素。
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = 3;

        //遍历棋盘把值放入稀疏数组里
        int counter = 0;
        for(int i = 0 ; i < 11 ; i++){
            for(int j = 0 ; j < 11 ; j++){
                if (chessboard[i][j] != 0) {
                    //关于counter之前卡了一下 下面式稀疏数组一行的赋值，第一个坐标应该是满足了if的要求（有子）就依次递增（起始为0）
                    counter++;
                    sparseArray[counter][0] = i;
                    sparseArray[counter][1] = j;
                    sparseArray[counter][2] = chessboard[i][j];
                }
            }
        }

        System.out.println();
        System.out.println();

        for(int[] rows : sparseArray){
            for(int data : rows){
                System.out.print(" " + data + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        //将稀疏数组返回成原来的二维数组

        int[][] chessboard2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        //遍历稀疏书
        for(int i = 1 ; i < sparseArray.length; i++){
            for(int j = 0 ; j < 3; j++){
                chessboard2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
            }
        }

        //打印返回的棋盘
        for(int[] rows : chessboard2){
            for(int data : rows){
                System.out.print(" " + data + " ");
            }
            System.out.println();
        }

    }
}