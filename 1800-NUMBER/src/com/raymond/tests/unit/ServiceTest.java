package com.raymond.tests.unit;

import com.raymond.core.services.implementations.DictionaryService;
import com.raymond.core.services.implementations.KeypadService;
import com.raymond.core.services.implementations.NumberToTextService;
import org.junit.Test;

import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ServiceTest
{
    private final KeypadService _keypadService;
    private final DictionaryService _dictionaryService;
    private final NumberToTextService _numberToTextService;

    public ServiceTest()
    {
        _keypadService = new KeypadService();
        _dictionaryService = new DictionaryService();
        _numberToTextService = new NumberToTextService();
    }

    @Test
    public void serviceIsNotNull()
    {
        assertNotNull(_numberToTextService);
    }

    @Test
    public void characterMapIsNotNull()
    {
        assertNotNull(_numberToTextService.convertToCharacterMap(_keypadService.getData()));
    }

    @Test
    public void characterMapHasAllNumbers()
    {
        AbstractMap<Character, String> keypadData = _keypadService.getData();
        AbstractMap<Character, Character> finalData = _numberToTextService.convertToCharacterMap(keypadData);

        assertTrue(finalData.containsValue('2'));
        assertTrue(finalData.containsValue('3'));
        assertTrue(finalData.containsValue('4'));
        assertTrue(finalData.containsValue('5'));
        assertTrue(finalData.containsValue('6'));
        assertTrue(finalData.containsValue('7'));
        assertTrue(finalData.containsValue('8'));
        assertTrue(finalData.containsValue('9'));
    }

    @Test
    public void characterMapHasAllAlphabets()
    {
        AbstractMap<Character, String> keypadData = _keypadService.getData();
        AbstractMap<Character, Character> finalData = _numberToTextService.convertToCharacterMap(keypadData);

        assertTrue(finalData.containsKey('A'));
        assertTrue(finalData.containsKey('B'));
        assertTrue(finalData.containsKey('C'));
        assertTrue(finalData.containsKey('D'));
        assertTrue(finalData.containsKey('E'));
        assertTrue(finalData.containsKey('F'));
        assertTrue(finalData.containsKey('G'));
        assertTrue(finalData.containsKey('H'));
        assertTrue(finalData.containsKey('I'));
        assertTrue(finalData.containsKey('J'));
        assertTrue(finalData.containsKey('K'));
        assertTrue(finalData.containsKey('L'));
        assertTrue(finalData.containsKey('M'));
        assertTrue(finalData.containsKey('N'));
        assertTrue(finalData.containsKey('O'));
        assertTrue(finalData.containsKey('P'));
        assertTrue(finalData.containsKey('Q'));
        assertTrue(finalData.containsKey('R'));
        assertTrue(finalData.containsKey('S'));
        assertTrue(finalData.containsKey('T'));
        assertTrue(finalData.containsKey('U'));
        assertTrue(finalData.containsKey('V'));
        assertTrue(finalData.containsKey('W'));
        assertTrue(finalData.containsKey('X'));
        assertTrue(finalData.containsKey('Y'));
        assertTrue(finalData.containsKey('Z'));
    }

    @Test
    public void characterMapIsUpperCase()
    {
        AbstractMap<Character, String> keypadData = _keypadService.getData();
        AbstractMap<Character, Character> finalData = _numberToTextService.convertToCharacterMap(keypadData);

        assertTrue(finalData.containsKey('A'));
        assertTrue(finalData.containsKey('B'));
        assertTrue(finalData.containsKey('C'));
        assertTrue(finalData.containsKey('D'));
        assertTrue(finalData.containsKey('E'));
        assertTrue(finalData.containsKey('F'));
        assertTrue(finalData.containsKey('G'));
        assertTrue(finalData.containsKey('H'));
        assertTrue(finalData.containsKey('I'));
        assertTrue(finalData.containsKey('J'));
        assertTrue(finalData.containsKey('K'));
        assertTrue(finalData.containsKey('L'));
        assertTrue(finalData.containsKey('M'));
        assertTrue(finalData.containsKey('N'));
        assertTrue(finalData.containsKey('O'));
        assertTrue(finalData.containsKey('P'));
        assertTrue(finalData.containsKey('Q'));
        assertTrue(finalData.containsKey('R'));
        assertTrue(finalData.containsKey('S'));
        assertTrue(finalData.containsKey('T'));
        assertTrue(finalData.containsKey('U'));
        assertTrue(finalData.containsKey('V'));
        assertTrue(finalData.containsKey('W'));
        assertTrue(finalData.containsKey('X'));
        assertTrue(finalData.containsKey('Y'));
        assertTrue(finalData.containsKey('Z'));
    }

    @Test
    public void availableMapsIsNotNullOrEmpty()
    {
        AbstractMap<Character, String> keypadData = _keypadService.getData();
        AbstractMap<Character, Character> finalData = _numberToTextService.convertToCharacterMap(keypadData);
        AbstractList<String> dictionaryData = _dictionaryService.getData();

        assertNotNull(_numberToTextService.getAvailableMap(finalData, dictionaryData));
        assertNotNull(_numberToTextService.getAvailableMap(finalData, dictionaryData).size() > 0);
    }

    @Test
    public void getPossibleResultIsWorkingWith1Word()
    {
        String phone = "43556";

        AbstractMap<Character, String> keypadData = _keypadService.getData();
        AbstractMap<Character, Character> finalData = _numberToTextService.convertToCharacterMap(keypadData);
        AbstractList<String> dictionaryData = _dictionaryService.getData();

        AbstractMap<String, AbstractList<String>> availableMap = _numberToTextService.getAvailableMap(finalData, dictionaryData);

        AbstractList<AbstractList<String>[]> result = _numberToTextService.getPossibleResult(phone, availableMap);

        assertNotNull(result);
        assertNotNull(result.size() > 0);

        ArrayList<String> testResult = new ArrayList<String>();

        for(AbstractList<String>[] dcsa : result)
        {
            for(AbstractList<String> dcs : dcsa)
            {
                if(dcs != null)
                {

                    AbstractList<String> data = dcs;
                    testResult.addAll(data);
                }
            }
        }

        //System.out.println(testResult);

        ArrayList<String> expectedResults = new ArrayList<String>(){{
            add("HE");
            add("LO");
            add("ELL");
            add("HELL");
            add("ELLN");
            add("HELLO");
            add("HELLN");
            add("ELL");
            add("ELLO");
        }};

        assertTrue(testResult.containsAll(expectedResults));
        assertTrue(expectedResults.containsAll(testResult));
    }

    @Test
    public void getFinalResultIsWorkingWith1Word()
    {
        String phone = "43556";

        AbstractMap<Character, String> keypadData = _keypadService.getData();
        AbstractMap<Character, Character> finalData = _numberToTextService.convertToCharacterMap(keypadData);
        AbstractList<String> dictionaryData = _dictionaryService.getData();

        AbstractMap<String, AbstractList<String>> availableMap = _numberToTextService.getAvailableMap(finalData, dictionaryData);

        AbstractList<AbstractList<String>[]> possibleResult = _numberToTextService.getPossibleResult(phone, availableMap);

        AbstractList<String> finalResult = new ArrayList<String>();
        finalResult = _numberToTextService.getFinalResult(possibleResult, phone, null, "");
        finalResult = _numberToTextService.getFinalResult(possibleResult, phone, finalResult, phone.substring(0, 1));

        assertNotNull(finalResult);
        assertNotNull(finalResult.size() > 0);

        //System.out.println(finalResult);

        ArrayList<String> expectedResults = new ArrayList<String>(){{
            add("HE-5-LO");
            add("4-ELL-6");
            add("HELL-6");
            add("4-ELLN");
            add("HELLO");
            add("HELLN");
            add("4-ELLO");
        }};

        assertTrue(finalResult.containsAll(expectedResults));
        assertTrue(expectedResults.containsAll(finalResult));
    }


    @Test
    public void getPossibleResultIsWorkingWith2Word2()
    {
        String phone = "43556.96753";

        AbstractMap<Character, String> keypadData = _keypadService.getData();
        AbstractMap<Character, Character> finalData = _numberToTextService.convertToCharacterMap(keypadData);
        AbstractList<String> dictionaryData = _dictionaryService.getData();

        AbstractMap<String, AbstractList<String>> availableMap = _numberToTextService.getAvailableMap(finalData, dictionaryData);

        AbstractList<AbstractList<String>[]> result = _numberToTextService.getPossibleResult(phone, availableMap);

        assertNotNull(result);
        assertNotNull(result.size() > 0);

        AbstractList<String> testResult = new ArrayList<String>();

        for(AbstractList<String>[] dcsa : result)
        {
            for(AbstractList<String> dcs : dcsa)
            {
                if(dcs != null)
                {

                    AbstractList<String> data = dcs;
                    testResult.addAll(data);
                }
            }
        }

        //System.out.println(testResult);

        ArrayList<String> expectedResults = new ArrayList<String>(){{
            add("HE");
            add("LO");
            add("ELL");
            add("HELL");
            add("ELLN");
            add("HELLO");
            add("HELLN");
            add("ELL");
            add("ELLO");
            add("WORLD");
            add("ORLD");
        }};

        assertTrue(testResult.containsAll(expectedResults));
        assertTrue(expectedResults.containsAll(testResult));
    }
}
