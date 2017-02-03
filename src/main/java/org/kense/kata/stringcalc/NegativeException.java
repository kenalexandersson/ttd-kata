package org.kense.kata.stringcalc;

import java.util.List;

/**
 * Created by ken on 2017-01-29.
 */
public class NegativeException extends Exception {

    public NegativeException(List<Integer> negatives) {

        super(String.format("Negatives not allowed: %s", negatives.toString()));
    }
}
