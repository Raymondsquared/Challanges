package com.raymond.presentation.console;

import com.raymond.core.exceptions.BadRequestException;
import com.raymond.core.helpers.IoHelper;
import com.raymond.presentation.console.controllers.ConverterController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws BadRequestException, IOException
    {
	    // write your code here
        System.out.println("Starting Application  ...");

        ConverterController converter = new ConverterController();

        //dictionary
        ArrayList<String> dictionary = handleDictionary(args);
        if( dictionary != null  && !dictionary.isEmpty())
        {
            converter.setDictionary(dictionary);
        }

        //input
        ArrayList<String> requestNumbers = handleInputRequest(args);

        if(requestNumbers != null && requestNumbers.size() > 0)
        {
            for(String number : requestNumbers)
            {
                System.out.print("Answer for " + number + " : ");
                try
                {
                    converter.run(number);
                }
                catch (BadRequestException bre)
                {
                    System.out.println(bre.getMessage());
                }
            }
        }
        else
        {
            Scanner sc = new Scanner(System.in);

            do
            {
                System.out.print("Please input a number : ");
                String input = sc.nextLine();

                try
                {
                    converter.run(input);
                }
                catch (BadRequestException bre)
                {
                    System.out.println(bre.getMessage());
                }

            } while(true);
        }
    }

    private static ArrayList<String> handleDictionary(String[] args)
    {
        ArrayList<String> dictionary = new ArrayList<String>();
        for(int i=0; i< args.length; i++)
        {
            if(args[i].equals("-d") && !args[i+1].isEmpty())
            {
                try
                {
                    dictionary = IoHelper.getData(args[i + 1]);
                }
                catch (IOException ioe)
                {
                    System.out.println(ioe.getMessage());
                    System.exit(1);
                }
                break;
            }
        }

        //upper case
        if(dictionary != null && dictionary.size() > 0)
        {
            for(int i=0; i<dictionary.size(); i++)
            {
                dictionary.set(i, dictionary.get(i).toUpperCase());
            }
        }

        return dictionary;
    }

    private static ArrayList<String> handleInputRequest(String[] args)
    {
        ArrayList<String> requestData = new ArrayList<String>();
        for(int i=0; i< args.length; i++)
        {
            if(args[i].equals("-f") && !args[i+1].isEmpty())
            {
                try
                {
                    requestData = IoHelper.getData(args[i + 1]);
                }
                catch (IOException ioe)
                {
                    System.out.println(ioe.getMessage());
                    System.exit(1);
                }
                break;
            }
        }
        return requestData;
    }

}
