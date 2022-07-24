package com.hanshunping.array;

import java.io.*;

/**
 * @ClassName sparseArr
 * @Description 稀疏数组实例
 * @Author LuKun
 * @Date 2022/7/5 18:20
 * @Version 1.0
 */
public class sparseArr {
    //"src/main/resources/test/array/sparseArr.txt"
    //读取稀疏数组
    public static int[][] loadArr(String path) throws IOException {
        File file = new File(path);
        if(!file.exists())file.createNewFile();
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(path))){
            Object object = oi.readObject();
            int[][] result= (int[][]) object;
            file.delete();
            return result;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    //存储稀疏数组
    public static void storeArr(int[][] spaAr,String path){
        try(ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(path,false))) {
            ob.writeObject(spaAr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //数组转稀疏数组
    public static int[][] arrToSparse(int[][] two){
        if (two==null)return null;
        int sum=0;
        for (int i = 0; i < two.length; i++) {
            for (int i1 = 0; i1 < two[i].length; i1++) {
                if (two[i][i1]!=0)sum++;
            }
        }
        int[][] resut=new int[sum+1][3];
        resut[0][0]=two.length;
        resut[0][1]=two[0].length;
        resut[0][2]=sum;
        int count=0;
        for (int i = 0; i < two.length; i++) {
            for (int i1 = 0; i1 < two[i].length; i1++) {
                if (two[i][i1]!=0){
                    count++;
                    resut[count][0]=i;
                    resut[count][1]=i1;
                    resut[count][2]=two[i][i1];
                }
            }
        }
        return resut;
    }

    //稀疏数组转数组
    public static int[][] spareToArr(int[][] spare){
        if (spare==null)return null;
        int[][] result=new int[spare[0][0]][spare[0][1]];
        for (int i = 0; i < spare[0][2]; i++) {
            result[spare[i+1][0]][spare[i+1][1]]=spare[i+1][2];
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int[][] test =new int[10][10];
        String path="src/main/resources/test/array/sparseArr.txt";
        test[1][2]=1;
        test[2][3]=2;
        for (int[] ints : test) {
            for (int anInt : ints) {
                System.out.print(anInt+"  ");
            }
            System.out.println();
        }
        System.out.println("=================");
        storeArr(arrToSparse(test),path);
        int[][] ints1=loadArr(path);
        for (int[] anInt : ints1) {
            for (int i : anInt) {
                System.out.print(i+"  ");
            }
            System.out.println();
        }
        System.out.println("=================");
        for (int[] anInt : spareToArr(ints1)) {
            for (int i : anInt) {
                System.out.print(i+"  ");
            }
            System.out.println();
        }
    }
}
