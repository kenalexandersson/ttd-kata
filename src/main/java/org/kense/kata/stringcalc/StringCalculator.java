package org.kense.kata.stringcalc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final int MAX_ALLOWED_NUMBER = 1000;
    private static final String DEFAULT_DELIMITER = ",";

    public int add(String numberString) throws NegativeException {

        int result = 0;

        if (numberString != null && !numberString.isEmpty()) {

            List<Integer> numbers = getIntegers(numberString);
            validateNonNegative(numbers);
            result = add(numbers);

        }

        return result;
    }

    private void validateNonNegative(List<Integer> numbers) throws NegativeException {

        List<Integer> negativeIntegers = numbers.stream()
                .filter(n -> n < 0)
                .collect(Collectors.toList());

        if (!negativeIntegers.isEmpty()) {
            throw new NegativeException(negativeIntegers);
        }
    }

    private List<Integer> getIntegers(String numberString) {

        String delimiter = DEFAULT_DELIMITER;

        if (numberString.startsWith("//")) {
            int endIndex = numberString.indexOf("\n");
            delimiter = numberString.substring(2, endIndex);
            numberString = numberString.substring(endIndex + 1);
        }


        return Arrays.stream(numberString.split(delimiter + "|\n"))
                .map(Integer::parseInt)
                .filter(n -> n <= MAX_ALLOWED_NUMBER)
                .collect(Collectors.toList());
    }


    private Integer add(List<Integer> numbers) {

        int result = 0;

        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }
}
