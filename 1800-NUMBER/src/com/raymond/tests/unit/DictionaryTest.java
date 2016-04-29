package com.raymond.tests.unit;

import com.raymond.core.services.implementations.DictionaryService;
import com.raymond.infrastructure.DefaultDictionaryRepository;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DictionaryTest
{
    private final DefaultDictionaryRepository _repository;
    private final DictionaryService _service;

    public DictionaryTest()
    {
        _repository = new DefaultDictionaryRepository();
        _service = new DictionaryService();
    }

    @Test
    public void repositoryIsNotNull()
    {
        assertNotNull(_repository);
    }

    @Test
    public void repositoryGetDataIsNotNullOrEmpty()
    {
        AbstractList<String> data = _repository.getData();

        assertNotNull(data);
        assertTrue(data.size() > 0);
    }

    @Test
    public void serviceIsNotNull()
    {
        assertNotNull(_service);
    }

    @Test
    public void serviceGetDataIsNotNullOrEmpty()
    {
        AbstractList<String> data = _service.getData();

        assertNotNull(data);
        assertTrue(data.size() > 0);
    }
}
