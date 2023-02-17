package org.example;

import lombok.extern.log4j.Log4j2;

import java.util.Stack;

@Log4j2
public class FIndMinRotatedArray {

    public static void main(String[] args) {
        var arr = new int[]{3,4,5,6,1,2};
        var checkArr = arr[0];
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for(int i =1;i< arr.length;i++){
            if(checkArr>arr[i]){
                min = arr[i];
                checkArr = arr[i];
            }else if(checkArr<min2 && min<min2){
                min2 = arr[i];
            }
        }
        log.debug("min element in the array is {}, 2nd element: {}",min, min2);
    }
}
