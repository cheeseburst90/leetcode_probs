package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.builder.HashCodeExclude;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

@Log4j2
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        Instant startBruteForce = Instant.now();
        var nonRepeatingChar = bruteForce("sapthagirish");
        Instant endBruteForce = Instant.now();
        log.debug("duration for bruteforce method is: {} nanosecs", Duration.between(startBruteForce,endBruteForce).toNanos());
        Instant startFindInOneForLoop = Instant.now();
        nonRepeatingChar = findInOneForLoop("sapthagirish");
        Instant endFindInOneForLoop = Instant.now();
        log.debug("duration for findInOneForLoop method is: {} nanosecs", Duration.between(startFindInOneForLoop,endFindInOneForLoop).toNanos());

        Instant startSearchUsingHashMap = Instant.now();
        nonRepeatingChar = searchUsingHashMap("sapthagirish");
        Instant endSearchUsingHashMap = Instant.now();
        log.debug("duration for searchUsingHashMap method is: {} nanosecs", Duration.between(startSearchUsingHashMap,endSearchUsingHashMap).toNanos());
    }

    private static char searchUsingHashMap(String gvnStr) {
        var  refMap = new LinkedHashMap<Character, CountIndex>();
        for(int i=0;i<gvnStr.length();i++){
            var ch = gvnStr.charAt(i);
            if(refMap.containsKey(ch)){
                var countIndex = refMap.get(ch);
                countIndex.setCount(countIndex.getCount()+1);
                refMap.put(ch,countIndex);
            }else{
                refMap.put(ch, new CountIndex(i));
            }
        }
        var resultEntry = refMap.entrySet().stream().filter(entry->entry.getValue().getCount()==1).findFirst();
        var result = resultEntry.isPresent()?resultEntry.get().getKey():'\0';
        log.debug("searchUsingHashMap:::method:::: the first non nonRepeatingChar of {} is {}",gvnStr,result);
        return result;
    }

    private static char findInOneForLoop(String gvnStr) {
        char[] findInString = new char[256];
        var response = '\0';
        for(int i =0;i<gvnStr.length();i++){
            findInString[gvnStr.charAt(i)]++;
        }
        for(int i =0;i<gvnStr.length();i++){
            if(findInString[gvnStr.charAt(i)]==1){
                response = gvnStr.charAt(i);
                break;
            }
        }
        log.debug("findInOneForLoop:::method:::: the first non nonRepeatingChar of {} is {}",gvnStr,response);
        return response;
    }

    private static char bruteForce(String gvnStr) {
        char[] strArr = gvnStr.toCharArray();
        var response = '\0';
        for(int i=0;i<strArr.length;i++){
            if(gvnStr.indexOf(strArr[i])==gvnStr.lastIndexOf(strArr[i])){
                response=strArr[i];
                break;
            }
        }
        log.debug("bruteForce:::method:::: the first non nonRepeatingChar of {} is {}",gvnStr,response);
        return response;
    }

    @Getter
    @Setter
    static class CountIndex{
        private Integer index;
        private int count;
        CountIndex(int index){
            this.index=index;
            this.count=1;
        }
    }
}
