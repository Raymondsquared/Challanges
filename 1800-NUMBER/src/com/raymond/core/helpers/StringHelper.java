package com.raymond.core.helpers;

public final class StringHelper
{
    private StringHelper() {}

    public static int count(String w, String c)
    {
        return w.toCharArray().length - w.replace(c, "").toCharArray().length;
    }
}
