package org.example;

import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

@Log4j2
public class Roman2Integer {

    static HashMap<Character, Integer> romanDictionary = new HashMap<>();

    static{
        romanDictionary.put('I',1);
        romanDictionary.put('V',5);
        romanDictionary.put('X',10);
        romanDictionary.put('L',50);
        romanDictionary.put('C',100);
        romanDictionary.put('D',500);
        romanDictionary.put('M',1000);
    }

    public static int roman2Int(String s){
        if(Objects.isNull(s)||s.length()==0||s.trim().length()==0){
            log.warn("string shud have some literal value::");
            return 0;
        }
        char[] romanCharArr = s.toUpperCase(Locale.getDefault()).toCharArray();
        int sum = 0;
        int prevValue = 0;
        for(int i=0;i<romanCharArr.length;i++){
            char romanChar = romanCharArr[i];
            Integer value = romanDictionary.get(romanChar);
            if(value>prevValue){
                sum+=value-(2*(prevValue));
            }else{
                sum+=value;
            }
            prevValue=value;
        }
        return sum;
    }
    public static void main(String[] args) {
        var romanString = "MMMCMXCIX";
        log.info("Integer form of roman literal: {} is: {}",romanString, roman2Int(romanString));
    }
}
