package org.example;

import lombok.extern.log4j.Log4j2;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class LongestSubStringWORepeat {

    public static int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int count = 0;
        char[] stringArr = s.toCharArray();
        log.info("stringArr length: {}", stringArr.length);
        for (int i = 0; i < stringArr.length; i++) {
            char ch = stringArr[i];
            list.add(ch);
            for (int j = i + 1; j < stringArr.length; j++) {
                if (!list.contains(stringArr[j])) {
                    list.add(stringArr[j]);
                } else {
                    break;
                }
            }
            count = Math.max(count, list.size());
            list.clear();
        }
        return count;
    }

    public static void main(String[] args) {
        //var string = "pwwkew";
        //var string = "dvdf";
        var string = "abcabcbb";
        Instant start = Instant.now();
        log.info("lengthOfLongestSubstring of: {} is: {}", string, lengthOfLongestSubstring(string));
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        log.info("time taken to execute the lengthOfLongestSubstring is : {} ms", duration.toMillis());
    }
}
