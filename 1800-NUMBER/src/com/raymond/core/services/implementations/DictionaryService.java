package com.raymond.core.services.implementations;

import com.raymond.core.repositories.interfaces.IDictionaryRepository;
import com.raymond.core.services.interfaces.IDictionaryService;
import com.raymond.infrastructure.DefaultDictionaryRepository;

import java.util.AbstractList;


public class DictionaryService implements IDictionaryService
{
    private final IDictionaryRepository _repository;

    public DictionaryService()
    {
        _repository = new DefaultDictionaryRepository();
    }

    @Override
    public AbstractList<String> getData()
    {
        return _repository.getData();
    }

    @Override
    public void setData(AbstractList<String> input)
    {
        _repository.setData(input);
    }
}
