package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 */
@Log4j2
public class FormBiggestNumber {

    @Getter
    @Setter
    @ToString
    static class ExtendedNumbers{
        private long originalNumber;
        private long extendedNumber;

        ExtendedNumbers(int originalNumber, int n){
            this.originalNumber=originalNumber;
            StringBuilder extendedSb = new StringBuilder();
            while(extendedSb.length()<=n+1){
                extendedSb.append(originalNumber);
            }
            log.trace("extendedSb: {}", extendedSb);
            extendedSb.substring(0,n+1);
            this.extendedNumber = Long.parseLong(extendedSb.toString());
        }
    }

    public static void main(String[] args) {
        Integer[] mainArr = new Integer[]{54, 546, 548, 60};
        List<Integer> integerList = Arrays.asList(mainArr);
        int n = Collections.max(integerList).toString().length();
        List<ExtendedNumbers> extendedNums = integerList.stream().map(num-> new ExtendedNumbers(num,n)).collect(Collectors.toList());
        extendedNums.sort(Comparator.comparing(ExtendedNumbers::getExtendedNumber).reversed());
        StringBuilder responseSB = new StringBuilder();
        extendedNums.forEach(num->responseSB.append(num.originalNumber));
        log.debug("response: {}",responseSB.toString());
    }
}
