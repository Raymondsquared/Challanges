package com.raymond.tests.integration;

import com.raymond.core.exceptions.BadRequestException;
import com.raymond.presentation.console.Main;
import org.junit.Test;

import java.io.IOException;


public class MainTest
{

    @Test
    public void MainTestWithNoArgumentWillAskForInput() throws BadRequestException, IOException
    {
        String[] args = new String[0];
        //Main.main(args);
    }


    @Test
    public void MainTestWithFileWillUseDefaultDictionary() throws BadRequestException, IOException
    {
        String file = "C:\\Developments\\Algorithm\\1800-NUMBER\\src\\com\\raymond\\tests\\integration\\inputs.txt";
        String[] args = new String[]{"-f",file};
        Main.main(args);
    }


    @Test
    public void MainTestWithFilePlusDictionaryWillReturnLessResult() throws BadRequestException, IOException
    {
        System.out.println("this test will get less result");
        String file = "C:\\Developments\\Algorithm\\1800-NUMBER\\src\\com\\raymond\\tests\\integration\\inputs.txt";
        String dictionary = "C:\\Developments\\Algorithm\\1800-NUMBER\\src\\com\\raymond\\tests\\integration\\dictionary.txt";
        String[] args = new String[]{"-f",file, "-d", dictionary};
        Main.main(args);
    }
}
