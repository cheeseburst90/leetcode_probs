package org.example;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Log4j2
public class PangramFinder {

    static List<String> chars = null;

    static{
        var abcd = "abcdefghijklmnopqrstuvwxyz";
        chars = abcd.chars().mapToObj(num->String.valueOf((char)num)).collect(Collectors.toList());
        System.out.println("chars: "+chars);
    }

    public static void main(String[] args) {
        String gvnStr = "abcdz";
        List<String> givenChars = gvnStr.chars().mapToObj(num->String.valueOf((char)num)).distinct().collect(Collectors.toList());
        log.debug("givenChars: {}", givenChars);
        var remainingChars = chars.stream().filter(Predicate.not(givenChars::contains)).collect(Collectors.toList());
        log.debug("remainingChars: {}", remainingChars);
    }

}
