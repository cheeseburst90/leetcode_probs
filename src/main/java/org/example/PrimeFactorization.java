package org.example;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class PrimeFactorization {

    public static void main(String[] args) {
        var givenNumber = 23;
        List<Integer> factors = new ArrayList<>();
        while (givenNumber >= 2 && givenNumber % 2 == 0) {
            givenNumber /= 2;
            factors.add(2);
        }
        if (givenNumber == 0 || givenNumber == 1) {
            log.debug("givenNumber: {}", givenNumber);
            log.debug("factors: {}", factors);
            return;
        }

        for (int i = 3; i < Math.sqrt(givenNumber); i+=2) {
            while (givenNumber % i == 0) {
                givenNumber /= i;
                factors.add(i);
            }
        }
        factors.add(givenNumber);
        log.debug("factors: {}", factors);
    }
}
