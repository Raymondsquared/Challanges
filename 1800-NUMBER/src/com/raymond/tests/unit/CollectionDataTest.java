package com.raymond.tests.unit;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CollectionDataTest
{
    private ArrayList<String> _col;

    public CollectionDataTest()
    {
        _col = new ArrayList<String>(
                new ArrayList<String>(){{
                    add("A");
                    add("AB");
                }}
        );
    }

    @Test
    public void DataCollectionIsNotNullAfterInsert()
    {
        assertNotNull(_col);
    }

    @Test
    public void DataCollectionHasAllItems()
    {
        assertTrue(_col.contains("A"));
        assertTrue(_col.contains("AB"));
    }
}