package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        try{
            RandomAccessFile file = new RandomAccessFile("myFile.txt", "rw");
            /*
            raf.seek(0);
            char l1 = (char)raf.readByte();
            raf.seek(1);
            char l2 = (char)raf.readByte();
            l2++;
            System.out.println(l1 + "" + l2);
             */
            char znak;
            char temp;
            System.out.println(file.readLine());
            for(int i = 0; i < file.length(); i++)
            {

                file.seek(i);
                znak = (char)file.readByte();
                if(znak == ' ')
                {
                    file.seek(i-1);
                    znak = (char)file.readByte();
                    file.seek(i-2);
                    temp = (char)file.readByte();
                    znak += 1; //zwiększa znak jedności o 1
                    //file.seek(0);
                    System.out.print(temp);
                    System.out.print(znak + " ");
                }

            }
            file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }



        }

    }


