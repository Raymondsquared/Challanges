package com.raymond.presentation.console.controllers;

import com.raymond.core.Constants;
import com.raymond.core.exceptions.BadRequestException;
import com.raymond.core.helpers.CollectionHelper;
import com.raymond.core.services.implementations.DictionaryService;
import com.raymond.core.services.implementations.KeypadService;
import com.raymond.core.services.implementations.NumberToTextService;
import com.raymond.core.services.interfaces.IDictionaryService;
import com.raymond.core.services.interfaces.IKeypadService;
import com.raymond.core.services.interfaces.INumberToTextService;

import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

public class ConverterController
{
    private final IKeypadService _keypadService;
    private final IDictionaryService _dictionaryService;
    private final INumberToTextService _numberToTextService;

    public ConverterController()
    {
        _keypadService = new KeypadService();
        _dictionaryService = new DictionaryService();
        _numberToTextService = new NumberToTextService();
    }

    public void setDictionary(ArrayList<String> dictionary)
    {
        _dictionaryService.setData(dictionary);
    }

    public void run(String input) throws BadRequestException
    {
        if(input == null || input.isEmpty())
        {
            throw new BadRequestException(Constants.ErrorMessage.NULL_OR_EMPTY);
        }

        HashMap<Character, String> keypad = (HashMap<Character, String>) _keypadService.getData();
        HashMap<Character, Character> characterMap = (HashMap<Character, Character>) _numberToTextService.convertToCharacterMap(keypad);
        //System.out.println(characterMap);

        ArrayList<String> dictionary = (ArrayList<String>) _dictionaryService.getData();
        AbstractMap<String, AbstractList<String>> dictionaryFinal = _numberToTextService.getAvailableMap(characterMap, dictionary);
        //System.out.println(dictionaryFinal);


        ArrayList<ArrayList<String>> finalResult = new ArrayList<ArrayList<String>>();
        for (String s : input.split("\\."))
        {
            //System.out.println("==================\nprocessing "+s);
            ArrayList<String> result = runSingle(s, dictionaryFinal);

            finalResult.add(result);
        }

        //System.out.println(finalResult);
        ArrayList<String> displayResult = CollectionHelper.crossJoin(finalResult, Constants.Separator.DASH, Constants.RegularExpression.DIGIT_DASH_DIGIT);
        System.out.println(displayResult);
    }

    private ArrayList<String> runSingle(String input, AbstractMap<String, AbstractList<String>> dictionaryFinal)
    {

        AbstractList<AbstractList<String>[]> possibleResult = _numberToTextService.getPossibleResult(input, dictionaryFinal);
        //System.out.println(possibleResult);

        ArrayList<String> finalResult = new ArrayList<String>();
        finalResult = (ArrayList<String> ) _numberToTextService.getFinalResult(possibleResult, input, null, "");
        finalResult = (ArrayList<String> ) _numberToTextService.getFinalResult(possibleResult, input, finalResult, input.substring(0, 1));

        //System.out.println(finalResult);
        return finalResult;
    }
}
