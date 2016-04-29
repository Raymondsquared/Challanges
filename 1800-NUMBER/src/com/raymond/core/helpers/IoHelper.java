package com.raymond.core.helpers;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class IoHelper
{
    private IoHelper () {}

    public static ArrayList<String> getData(String fileName) throws IOException
    {
        ArrayList<String> result = new ArrayList<String>();

        //FileReader fr = new FileReader("C:\\Developments\\Algorithm\\1800-NUMBER\\src\\com\\raymond\\tests\\integration\\dictionary.txt");
        FileReader fr = new FileReader(fileName);
        BufferedReader bufr = new BufferedReader(fr);

        String line = bufr.readLine();
        while(line != null)
        {
            if(!line.isEmpty())
            {
                result.add(line);
            }
            line = bufr.readLine();
        }

        bufr.close();

        System.out.println("loading dictionary : " + fileName);
        return result;
    }
}
