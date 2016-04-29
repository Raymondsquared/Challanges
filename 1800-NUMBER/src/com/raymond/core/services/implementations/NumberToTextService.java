package com.raymond.core.services.implementations;

import com.raymond.core.helpers.StringHelper;
import com.raymond.core.services.interfaces.INumberToTextService;

import java.util.*;

public class NumberToTextService implements INumberToTextService
{
    @Override
    public AbstractMap<Character, Character> convertToCharacterMap (AbstractMap<Character, String> input)
    {
        HashMap<Character, Character> result = new HashMap<Character, Character>();

        for (Map.Entry<Character, String> entry : input.entrySet())
        {
            Character key = entry.getKey();
            String value = entry.getValue();

            for(Character c: value.toCharArray())
            {
                result.put(c, key);
            }
        }

        return result;
    }

    @Override
    public AbstractMap<String, AbstractList<String>> getAvailableMap(AbstractMap<Character, Character> characterMap, AbstractList<String> dictionary)
    {
        AbstractMap<String, AbstractList<String>> result = new HashMap<String, AbstractList<String>>();

        for(String s : dictionary)
        {
            String numberResult = "";

            for(char c : s.toCharArray())
            {
                numberResult += characterMap.get(c);
            }

            ArrayList<String> values = new ArrayList<String>();
            if(result.get(numberResult) == null)
            {
                values.add(s);
            }
            else
            {
                values = (ArrayList<String>) result.get(numberResult);
                values.add(s);
            }

            result.put(numberResult, values);
        }

        return result;
    }

    @Override
    public AbstractList<AbstractList<String>[]> getPossibleResult(String input, AbstractMap<String, AbstractList<String>> dictionaryFinal)
    {
        AbstractList<AbstractList<String>[]> result = new ArrayList<AbstractList<String>[]>();

        int inputLength = input.toCharArray().length;
        for(int i=0; i<inputLength; i++)
        {
            String mainTest = input.substring(i, inputLength);
            int arraySize = mainTest.toCharArray().length;

            ArrayList<String>[] combos = new ArrayList[arraySize];

            int repeat = 0;

            while(repeat < inputLength-i)
            {
                String subTest = mainTest.substring(0, repeat+1);
                ArrayList<String> matchesArrayList = (ArrayList<String>) dictionaryFinal.get(subTest);

                //System.out.print("mainTest = " + mainTest + " & ");
                //System.out.print("subTest = " + subTest + "\n");
                //System.out.println(matchesArrayList);

                if(matchesArrayList != null && !matchesArrayList.isEmpty() && matchesArrayList.size() > 0)
                {
                    combos[repeat] = new ArrayList<String>(matchesArrayList);
                }
                repeat ++;
            }

            //System.out.print("combos size = "+ combos.length);
            //System.out.print(" & combo[max] = "+ combos[combos.length-1]);
            //System.out.println(" & length = " + combos.length);

            result.add(combos);
        }

        return result;
    }

    @Override
    public AbstractList<String> getFinalResult(AbstractList<AbstractList<String>[]> result, String input, AbstractList<String> finalResult, String word)
    {
        AbstractList<String> tempResult = new ArrayList<String>();

        if(finalResult != null)
        {
            tempResult = finalResult;
        }

        int position = word.toCharArray().length - StringHelper.count(word, "-");

        //System.out.println("word = " + word + "," + position + " >= " + result.size());

        if (position == result.size())
        {
            tempResult.add(word);
        }

        if(position >= input.length())
        {
            position = input.length() - 1;
        }


        for (AbstractList<String> combo : result.get(position))
        {
            if (combo != null && combo.size() > 0)
            {
                for (String s : combo) {
                    String newWord = "";

                    if (word.isEmpty()) {
                        newWord = s;
                    } else {
                        newWord = word + "-" + s;
                    }

                    //System.out.println("newWord = " + newWord);

                    int ca = position + s.length();
                    if(ca >= input.length())
                    {
                        ca = input.length() - 1;
                    }


                    tempResult = (ArrayList<String>) getFinalResult(result, input, tempResult, newWord);

                    tempResult = (ArrayList<String>) getFinalResult(result, input, tempResult, newWord + "-" + input.charAt(ca));
                }
            }
        }

        return tempResult;
    }
}
