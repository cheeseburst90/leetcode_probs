package org.example;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;

@Log4j2
public class RunLengthDecoding {
    public static void main(String[] args) {
        var givenStr = "12W1B12W3B24W1B14W";
        var decodedStr = bruteForce(givenStr);
        Assertions.assertTrue(decodedStr.equals("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWWWWW"));
    }

    private static String bruteForce(String givenStr) {
        StringBuilder sb = new StringBuilder();
        StringBuilder digitBuilder = new StringBuilder();
        for(int i =0;i<givenStr.length();i++){
            char c = givenStr.charAt(i);
            if(Character.isDigit(c)){
                digitBuilder.append(c);
            }else{
                int count = Integer.parseInt(digitBuilder.toString());
                StringBuilder sb1 = new StringBuilder();
                while(sb1.length()<count){
                    sb1.append(c);
                }
                sb.append(sb1);
                //java 11
                //sb.append(String.valueOf(c).repeat(Integer.parseInt(digitBuilder.toString())));
                digitBuilder = new StringBuilder();
            }
        }
        log.debug("decoded string: {}", sb.toString());
        return sb.toString();
    }
}
