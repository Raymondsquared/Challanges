package com.raymond.core.services.implementations;

import com.raymond.core.repositories.interfaces.IKeypadRepository;
import com.raymond.core.services.interfaces.IKeypadService;
import com.raymond.infrastructure.DefaultKeypadRepository;

import java.util.AbstractMap;


public class KeypadService implements IKeypadService
{
    private final IKeypadRepository _repository;

    public KeypadService()
    {
        _repository = new DefaultKeypadRepository();
    }

    @Override
    public AbstractMap<Character, String> getData()
    {
        return _repository.getData();
    }
}
