package com.raymond.tests.unit;

import com.raymond.core.helpers.CollectionHelper;
import com.raymond.core.helpers.ConvertHelper;
import com.raymond.core.helpers.IoHelper;
import com.raymond.core.helpers.StringHelper;
import com.raymond.core.models.DataCollection;
import com.raymond.core.services.implementations.DictionaryService;
import com.raymond.core.services.implementations.KeypadService;
import com.raymond.core.services.implementations.NumberToTextService;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class HelperTest
{
    public HelperTest()
    {
    }

    @Test
    public void convertHelperToStringMethodIsWorking()
    {
        assertEquals(ConvertHelper.toString('A'), "A");
    }

    @Test
    public void stringHelperCountMethodIsWorking()
    {
        assertEquals(StringHelper.count("abc-123-456", "-"), 2);
    }

    @Test
    public void collectionHelperIsWorking()
    {
        ArrayList<ArrayList<String>> testResult = new ArrayList<ArrayList<String>>();
        ArrayList<String> expectedResult = new ArrayList<String>();

        testResult.add(new ArrayList<String>(){{add("ABC-");add("123");}});
        testResult.add(new ArrayList<String>(){{add("DEF");add("-GHI");}});
        expectedResult.add("ABC--DEF");
        //expectedResult.add("ABC---GHI");
        expectedResult.add("123-DEF");
        expectedResult.add("123--GHI");



        assertTrue(CollectionHelper.crossJoin(testResult, "-", ".*[-][-][-].*").containsAll(expectedResult));
        assertTrue(expectedResult.containsAll(CollectionHelper.crossJoin(testResult, "-", ".*[-][-][-].*")));
    }

    @Test
    public void ioHelperIsWorking() throws IOException
    {
        String file = "C:\\Developments\\Algorithm\\1800-NUMBER\\src\\com\\raymond\\tests\\integration\\dictionary.txt";
        ArrayList<String> testResult = IoHelper.getData(file);
        ArrayList<String> expectedResult = new ArrayList<String>(){{
            add("hello");
            add("ello");
            add("call");
            add("me");
            add("hello");
        }};

        assertTrue(testResult.containsAll(expectedResult));
        assertTrue(expectedResult.containsAll(testResult));
    }
}
