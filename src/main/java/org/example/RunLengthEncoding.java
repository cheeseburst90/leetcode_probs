package org.example;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RunLengthEncoding {

    public static void main(String[] args) {
        String givenStr = "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW";
        var encodedStr = bruteForce(givenStr);
        var encodedStr_1 = woWhileLoop(givenStr);
        assert encodedStr.equals(encodedStr_1);
    }

    private static String woWhileLoop(String givenStr) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < givenStr.length(); i++) {
            if(i+1<givenStr.length() && givenStr.charAt(i)==givenStr.charAt(i+1)){
               ++count;
            }else{
                sb.append(String.valueOf(count).concat(String.valueOf(givenStr.charAt(i))));
                count=1;
            }
        }
        log.debug("woWhileLoop:::: sb built: {}", sb.toString());
        return sb.toString();
    }

    private static String bruteForce(String givenStr) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<givenStr.length();i++){
            char c = givenStr.charAt(i);
            int count = 1;
            int j = i+1;
            while(j<givenStr.length()&&givenStr.charAt(j)==givenStr.charAt(i)){
                count++;
                ++j;
            }
            i=j-1;
            sb.append(String.valueOf(count).concat(String.valueOf(c)));
        }
        log.debug("bruteForce:::: sb built: {}", sb.toString());
        return sb.toString();
    }
}
