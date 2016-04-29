package com.raymond.core;

import java.util.ArrayList;

/**
 * Created by raymo on 24/04/2016.
 */
public final class Constants
{
    public final class ErrorMessage
    {
        public final static String NULL_OR_EMPTY = "Failed, Input is null or empty!";
    }

    public final class RegularExpression
    {
        public final static String DIGIT_DASH_DIGIT = ".*\\d[-]\\d.*";
    }

    public final class Separator
    {
        public final static String DASH = "-";
    }

    public static final class Default
    {
        public final static ArrayList<String> DICTIONARY = new ArrayList<String>()
        {{
                add("HELLO");
                add("HELLN");
                add("ELLO");
                add("ELLN");
                add("HELL");
                add("ELL");
                add("HE");
                add("LO");
                add("WORLD");
                add("ORLD");
                add("CALL");
                add("ME");
        }};
    }
}
