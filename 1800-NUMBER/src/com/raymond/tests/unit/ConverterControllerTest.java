package com.raymond.tests.unit;

import com.raymond.core.exceptions.BadRequestException;
import com.raymond.presentation.console.controllers.ConverterController;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConverterControllerTest
{
    public ConverterControllerTest()
    {
    }

    @Test
    public void nullInputThrowError()
    {
        try
        {
            ConverterController converter = new ConverterController();
            converter.run(null);
        }
        catch (BadRequestException bre)
        {
            assertTrue(true);
        }
    }

    @Test
    public void emptyInputThrowError()
    {
        try
        {
            ConverterController converter = new ConverterController();
            converter.run(null);
        }
        catch (BadRequestException bre)
        {
            assertTrue(true);
        }
    }

    @Test
    public void runIsWorking() throws BadRequestException
    {
        ConverterController converter = new ConverterController();
        converter.run("43556");
    }
}
