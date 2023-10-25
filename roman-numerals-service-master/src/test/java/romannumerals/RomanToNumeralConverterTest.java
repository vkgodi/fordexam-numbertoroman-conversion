package romannumerals;

import junitparams.JUnitParamsRunner;
import org.junit.runner.RunWith;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class RomanToNumeralConverterTest {

    @Test
    public void testConversionForValidRomanNumerals() {
        // Test for valid Roman numerals
        NumeralRoman test = new NumeralRoman();
        assertEquals(1, test.romanToInt("I"));
        assertEquals(4, test.romanToInt("IV"));
        assertEquals(9, test.romanToInt("IX"));

    }

    @Test
    public void testConversionForInvalidRomanNumerals() {
        // Test for invalid Roman numerals
        NumeralRoman test = new NumeralRoman();
        assertEquals(0, test.romanToInt("invalid"));
        assertEquals(0, test.romanToInt("MMMM"));

    }

}
