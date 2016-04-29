package com.raymond.infrastructure;

import com.raymond.core.repositories.interfaces.IKeypadRepository;

import java.util.HashMap;

public class DefaultKeypadRepository implements IKeypadRepository
{
    @Override
    public HashMap<Character, String> getData()
    {
        return new HashMap<Character, String>()
        {
            {
                put('2', "ABC");
                put('3', "DEF");
                put('4', "GHI");
                put('5', "JKL");
                put('6', "MNO");
                put('7', "PQRS");
                put('8', "TUV");
                put('9', "WXYZ");
            }
        };
    }
}
