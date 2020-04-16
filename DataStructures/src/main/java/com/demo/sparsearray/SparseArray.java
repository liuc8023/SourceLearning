package com.demo.sparsearray;

import java.io.*;
import java.util.ArrayList;

/**
* 稀疏数组
* @className SparseArray
* @author liuc
* @date 2020-03-15 21:18
* @since JDK 1.8
**/
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int[][] arr = new int[11][11];
        arr[1][1] = 1;
        arr[2][3] = 2;
        arr[4][5] = 2;
        System.out.println("原始数组");
        for (int[] tmp:arr) {
            for ( int t : tmp) {
                System.out.printf("%d\t",t);
            }
            System.out.println();
        }

        int[][] sparseArr=ArrayToSparse(arr);
        //1、输出稀疏数组
        System.out.println("输出稀疏数组");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
            System.out.println();
        }
        //2、将系数数组写入文件
        WriteSparseToFile(sparseArr,"xishu.txt");

        //3、从文件中读出稀疏数组
        System.out.println("从文件中读出稀疏数组");
        int[][] readFileArray = ReadFileToArray("xishu.txt");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
            System.out.println();
        }
        //4、从文件中读出稀疏数组,恢复成原来数组
        System.out.println("恢复出来的二维数组");
        int[][] ints = SparseToArray(readFileArray);
        for (int[] tmp:ints) {
            for ( int t : tmp) {
                System.out.printf("%d\t",t);
            }
            System.out.println();
        }
    }

    /**
     * 将数组转换为稀疏数组
     * @param
     * @return
     * @throws
     * @date 2020/3/15 21:22
     * @author liuc
     **/
    public static int[][] ArrayToSparse(int[][] arr){
        //将二维数组转换为稀疏数组
        //1、遍历得到非零个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(arr[i][j]!=0) {
                    sum++;
                }
            }
        }
        //2、创建稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2] =sum;

        //count 用于记录是第几个非0数据
        int count = 0;
        //3、遍历 填充稀疏数组非零元素
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11 ; j++) {
                if(arr[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=arr[i][j];
                }
            }
        }
        return  sparseArr;
    }

    /**
     * 将稀疏数组写入文件
     * @param
     * @return 
     * @throws 
     * @date 2020/3/15 21:24 
     * @author liuc
     **/
    public static void WriteSparseToFile(int[][] sparseArr,String fileName){
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw = new FileWriter(new File(fileName));
            bw = new BufferedWriter(fw);
            for (int i = 0; i < sparseArr.length; i++) {
                String tmpStr ="";
                for (int j = 0; j <sparseArr[i].length ; j++) {
                    tmpStr+=sparseArr[i][j]+" ";
                }
                tmpStr+="\r\n";
                bw.write(tmpStr);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从文件中读出稀疏数组
     * @param
     * @return 
     * @throws 
     * @date 2020/3/15 21:26 
     * @author liuc
     **/
    public static int[][] ReadFileToArray(String fileName){
        FileReader fr = null;
        BufferedReader br = null;
        int[][] readArray={};
        try {
            fr = new FileReader(new File(fileName));
            br = new BufferedReader(fr);
            String lineStr="";
            ArrayList<String> list = new ArrayList<String>();
            try {
                while ((lineStr= br.readLine())!=null){
                    list.add(lineStr);
                }
                readArray = new int[list.size()][list.get(0).length()];
                for (int i = 0;i<list.size() ; i++) {
                    String[] c = list.get(i).split(" ");
                    for (int j = 0; j <c.length ; j++) {
                        readArray[i][j]=Integer.parseInt(c[j]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  readArray;
    }

    /**
     * 将稀疏数组转换为数组
     * @param
     * @return
     * @throws
     * @date 2020/3/15 21:26
     * @author liuc
     **/
    public static int[][] SparseToArray(int[][] sparseArr){
        //将稀疏数组恢复成数组
        //1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] arr  = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2、在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
        for (int i = 1; i <sparseArr.length ; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        return arr;
    }
}
