package org.example;

import lombok.extern.log4j.Log4j2;

import java.util.Stack;

@Log4j2
public class ReverseString {
    public static void main(String[] args) {

        var givenStr = "abcdefgh";
        StringBuilder sb = new StringBuilder();
        for(int i =givenStr.length()-1;i>=0;i--){
            sb.append(givenStr.charAt(i));
        }
        log.debug("string reversed: {}", sb.toString());
    }
}
