package com.raymond.core.repositories.interfaces;

import java.util.AbstractList;

public interface IDictionaryRepository
{
     public AbstractList<String> getData();
     public void setData(AbstractList<String> input);
}
