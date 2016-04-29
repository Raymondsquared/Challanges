package com.raymond.tests.unit;

import com.raymond.core.services.implementations.KeypadService;
import com.raymond.infrastructure.DefaultKeypadRepository;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.HashMap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class KeypadTest
{
    private final DefaultKeypadRepository _repository;
    private final KeypadService _service;

    public KeypadTest()
    {
        _repository = new DefaultKeypadRepository();
        _service = new KeypadService();
    }

    @Test
    public void repositoryIsNotNull()
    {
        assertNotNull(_repository);
    }

    @Test
    public void keypadHasAllNumbers()
    {
        HashMap<Character, String> data = _repository.getData();

        assertNotNull(data.get('2'));
        assertNotNull(data.get('3'));
        assertNotNull(data.get('4'));
        assertNotNull(data.get('5'));
        assertNotNull(data.get('6'));
        assertNotNull(data.get('7'));
        assertNotNull(data.get('8'));
        assertNotNull(data.get('9'));
    }

    @Test
    public void keypadHasAllAlphabets()
    {
        HashMap<Character, String> data = _repository.getData();

        assertTrue(data.containsValue("ABC"));
        assertTrue(data.containsValue("DEF"));
        assertTrue(data.containsValue("GHI"));
        assertTrue(data.containsValue("JKL"));
        assertTrue(data.containsValue("MNO"));
        assertTrue(data.containsValue("PQRS"));
        assertTrue(data.containsValue("TUV"));
        assertTrue(data.containsValue("WXYZ"));
    }


    @Test
    public void keypadIsUpperCase()
    {
        HashMap<Character, String> data = _repository.getData();

        assertTrue(data.get('2').equals(data.get('2').toUpperCase()));
        assertTrue(data.get('3').equals(data.get('3').toUpperCase()));
        assertTrue(data.get('4').equals(data.get('4').toUpperCase()));
        assertTrue(data.get('5').equals(data.get('5').toUpperCase()));
        assertTrue(data.get('6').equals(data.get('6').toUpperCase()));
        assertTrue(data.get('7').equals(data.get('7').toUpperCase()));
        assertTrue(data.get('8').equals(data.get('8').toUpperCase()));
        assertTrue(data.get('9').equals(data.get('9').toUpperCase()));
    }

    @Test
    public void serviceIsNotNull()
    {
        assertNotNull(_service);
    }

    @Test
    public void serviceGetDataIsNotNullOrEmpty()
    {
        AbstractMap<Character, String> data = _service.getData();

        assertNotNull(data);
        assertTrue(data.size() > 0);
    }
}
