package com.company;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        try{
            //writeToFile("12", 4);
            System.out.println(new String(readFromFile(0, 200)));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void writeToFile(String data, int position) throws IOException {
        RandomAccessFile file = new RandomAccessFile("myFile.txt", "rw");
        file.seek(position);
        file.write(data.getBytes());
        file.close();
    }

    public static byte[] readFromFile(int position, int size) throws IOException{
        RandomAccessFile file = new RandomAccessFile("myFile.txt", "r");
        file.seek(position);
        byte[] bytes = new byte[size];
        file.read(bytes);
        file.close();
        return bytes;
    }
}
