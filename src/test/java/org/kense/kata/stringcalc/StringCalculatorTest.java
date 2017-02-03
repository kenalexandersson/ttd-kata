package org.kense.kata.stringcalc;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

/**
 * Created by ken on 2017-01-26.
 */
public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    public void addEmptyString() throws Exception {

        int result = calculator.add("");
        assertThat(result, is(0));

    }

    @Test
    public void addOneNumber() throws Exception {

        int result = calculator.add("1");
        assertThat(result, is(1));

    }

    @Test
    public void addTwoNumbers() throws Exception {

        int result = calculator.add("1,2");
        assertThat(result, is(3));

    }

    @Test
    public void addnumbersWithNewLine() throws Exception {

        int result = calculator.add("1\n2,3");
        assertThat(result, is(6));
    }

    @Test
    public void addUsingDelimiter() throws Exception {

        int result = calculator.add("//;\n1;3");
        assertThat(result, is(4));

    }

    @Test
    public void addNegativeNumber() throws Exception {

        try {
            calculator.add("1,2,-3,-5");
            fail("NegativeException was not thrown");

        } catch (NegativeException e) {

            assertThat(e.getMessage(), containsString("-3"));
            assertThat(e.getMessage(), containsString("-5"));
        }

    }


    @Test
    public void addNumbersUpTo1000() throws Exception {

        int result = calculator.add("1,2,1000");
        assertThat(result, is(1003));
    }

    @Test
    public void addNumbersIgnoringOver1000() throws Exception {

        int result = calculator.add("1,2,1001");
        assertThat(result, is(3));
    }
}
