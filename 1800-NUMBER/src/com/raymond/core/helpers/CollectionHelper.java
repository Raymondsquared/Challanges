package com.raymond.core.helpers;

import java.util.ArrayList;

public final class CollectionHelper
{
    private CollectionHelper() {}

    public static ArrayList<String> crossJoin(ArrayList<ArrayList<String>> input, String separator, String regex)
    {
        ArrayList<String> result = new ArrayList<String>();


        int solutions = 1;

        for(int i = 0; i < input.size(); solutions *= input.get(i).size(), i++);
        for(int i = 0; i < solutions; i++) {
            int j = 1;
            String tempResult = "";
            for(ArrayList<String> als : input)
            {
                tempResult += als.get((i/j)%als.size()) + " ";
                j *= als.size();
            }

            tempResult = tempResult.trim().replaceAll(" ", "-");
            //System.out.println(tempResult);

            if(!tempResult.matches(regex))
            {
                result.add(tempResult);
            }
        }

        return result;
    }

}
