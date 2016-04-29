package com.raymond.infrastructure;

import com.raymond.core.Constants;
import com.raymond.core.repositories.interfaces.IDictionaryRepository;

import java.util.AbstractList;
import java.util.ArrayList;

public class DefaultDictionaryRepository implements IDictionaryRepository
{
    private AbstractList<String> _data = Constants.Default.DICTIONARY;

    @Override
    public AbstractList<String> getData()
    {
        return _data;
    }

    @Override
    public void setData(AbstractList<String> input)
    {
        _data = input;
    }

}
