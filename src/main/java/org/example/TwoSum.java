package org.example;

import lombok.extern.log4j.Log4j2;
import java.util.*;

@Log4j2
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int[] result=new int[2];
        for(int i=0;i<n;i++){
            if(map.containsKey(target-nums[i])){
                result[1]=i;
                result[0]=map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        var arr = twoSum(new int[]{11,2,15,7},9);
        log.debug("ist indice: {} 2nd indice:{}", arr[0], arr[1]);
    }

}
