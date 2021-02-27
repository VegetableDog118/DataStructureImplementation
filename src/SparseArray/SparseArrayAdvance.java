package SparseArray;

import java.io.*;
import java.util.List;

public class SparseArrayAdvance {

    //测试两个方法
    public static void main(String[] args) throws IOException {

        //创建棋盘数组
        int[][] chessboard = new int[11][11];

        //0表式没有子 1表示黑子 2表示白子
        chessboard[1][3] = 1;
        chessboard[2][5] = 2;

        //打印创造好的棋盘
        for(int[] rows : chessboard){
            for(int data : rows){
                System.out.print(" " + data + " ");
            }
            System.out.println();
        }
        System.out.println();

        //调用方法把sparseArray存到文件里
        toSparseArray(chessboard);

        //----------------------------------------------------------------------


        //调用方法把文件里的sparseArray返回成一个棋盘数组
        int[][] a = toChessBoard("/Users/zhuhaolin/Downloads/DataStructureImplementation/src/SparseArray/sparseArray.txt");

        //打印返回的棋盘
        for(int[] rows : a){
            for(int data : rows){
                System.out.print(" " + data + " ");
            }
            System.out.println();
        }
    }

    public static void toSparseArray(int[][] chessboard) throws IOException {

        //遍历棋盘看有多少个有效值
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
        sparseArray[0][0] = chessboard.length;
        sparseArray[0][1] = chessboard.length;
        sparseArray[0][2] = 3;

        //遍历棋盘把值放入稀疏数组里
        int counter = 0;
        for(int i = 0 ; i < chessboard.length ; i++){
            for(int j = 0 ; j < chessboard.length ; j++){
                if (chessboard[i][j] != 0) {
                    //关于counter之前卡了一下 下面式稀疏数组一行的赋值，第一个坐标应该是满足了if的要求（有子）就依次递增（起始为0）
                    counter++;
                    sparseArray[counter][0] = i;
                    sparseArray[counter][1] = j;
                    sparseArray[counter][2] = chessboard[i][j];
                }
            }
        }

        //把数组写入文件
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/zhuhaolin/Downloads/DataStructureImplementation/src/SparseArray/sparseArray.txt");
        for(int[] rows : sparseArray){
            for(int data : rows){
                fileOutputStream.write((String.valueOf(data)).getBytes());
                fileOutputStream.write(",".getBytes());
            }
            fileOutputStream.write("\r\n".getBytes());
        }
        fileOutputStream.close();
    }

    public static int[][] toChessBoard(String Filename) throws IOException {
        //读取文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(Filename));

        //读取文件第一行，用第一行创建棋盘数组
        String[] arr = bufferedReader.readLine().split(",");
        int[][] chessboard2 = new int[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])];

        //读取文件的后面几行，然后把棋子放入棋盘对应位置
        String line;
        while((line = bufferedReader.readLine()) != null) {
             String[] arr2 = line.split(",");
             chessboard2[Integer.parseInt(arr2[0])][Integer.parseInt(arr2[1])] = Integer.parseInt(arr2[2]);
        }
        return chessboard2;
    }
}
