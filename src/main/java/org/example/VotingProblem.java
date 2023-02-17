package org.example;

import java.util.ArrayList;
import java.util.List;


public class VotingProblem {

    static List<Integer> person = new ArrayList<>();

    public static void main(String[] args) {
        var myArr = new int[14];
        for (int i = 0; i < myArr.length; i++) {
            myArr[i]=1;
        }
        var k = 2;
        k--;
        var index = 0;
        Josh(myArr, k, index);
        //var freedPersonIndex = executePersonByLinearTime(5, songLength + 1);
        //log.debug("freedPersonIndex: {}", freedPersonIndex);
    }

    private static int executePersonByLinearTime(int size, int k) {
        int ans = 0, i = 1;
        while (i <= size) {
            ans = (ans + k) % i;
            i++;
        }
        return ans + 1;
    }

    private static void Josh(int[] myArr, int k, Integer index) {
        if (person.size() == 1) {
            System.out.println("single person alive indexed as :{}"+ person.get(0));
            return;
        }
        index = ((index + k) % person.size());
        person.remove(index);
        Josh(myArr, k, index);
    }
}
