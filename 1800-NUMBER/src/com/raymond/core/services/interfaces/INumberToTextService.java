package com.raymond.core.services.interfaces;

import java.util.AbstractList;
import java.util.AbstractMap;

public interface INumberToTextService
{
    public AbstractMap<Character, Character> convertToCharacterMap(AbstractMap<Character, String> input);
    public AbstractMap<String, AbstractList<String>> getAvailableMap(AbstractMap<Character, Character> characterMap, AbstractList<String> dictionary);
    public AbstractList<AbstractList<String>[]> getPossibleResult(String input, AbstractMap<String, AbstractList<String>> dictionaryFinal);
    public AbstractList<String> getFinalResult(AbstractList<AbstractList<String>[]> result, String input, AbstractList<String> finalResult, String word);
}