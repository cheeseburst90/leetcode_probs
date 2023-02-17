package org.example;

import lombok.extern.log4j.Log4j2;

/**
 *
 */
@Log4j2
public class LongestUniformString {

    public static void main(String[] args) {
        var gvnString = "aabbbbbCdAAAAAAAAA";
        int index=-1;
        int count = 1;
        int maxLength = 0;
        for(int i =1;i<=gvnString.length();i++){
            if(i<gvnString.length()&&gvnString.charAt(i)==gvnString.charAt(i-1)){
                count++;
            }else{
                if(count>maxLength){
                    maxLength=count;
                    index = i-count;
                }
                count=1;
            }
        }
        log.debug("maxLength: {}", maxLength);
        log.debug("index: {}", index);

    }
}
