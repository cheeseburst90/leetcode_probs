package org.example;

import lombok.extern.log4j.Log4j2;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://www.geeksforgeeks.org/java-program-to-find-next-greater-element/
 */
@Log4j2
public class NearestGreatestElement {

    public static void main(String[] args) {
        var givenArr = new int[]{4, 5, 2, 25};
        Instant startUsingNestedForLoops = Instant.now();
        var nge = usingNestedForLoops(givenArr);
        Instant endUsingNestedForLoops = Instant.now();
        log.debug("nge:using  usingNestedForLoops:: {}", Arrays.stream(nge).boxed().collect(Collectors.toList()));
        log.debug("duration of usingNestedForLoops method::: {} ns", Duration.between(startUsingNestedForLoops, endUsingNestedForLoops).toNanos());
        Instant startUsingStack = Instant.now();
        nge = usingStack(givenArr);
        Instant endUsingStack = Instant.now();
        log.debug("nge:using stack::: {}", Arrays.stream(nge).boxed().collect(Collectors.toList()));
        log.debug("duration of stack method::: {} ns", Duration.between(startUsingStack, endUsingStack).toNanos());
    }

    private static int[] usingStack(int[] givenArr) {
        var nge = new int[givenArr.length];
        Stack<Integer> stack = new Stack<>();
        int n = givenArr.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= givenArr[i]) {
                stack.pop();
            }
            if (i < n) {
                if (stack.isEmpty()) {
                    nge[i] = -1;
                } else {
                    nge[i] = stack.peek();
                }
            }
            stack.push(givenArr[i]);
        }
        return nge;
    }

    static int[] usingNestedForLoops(int[] arr) {
        int n = arr.length;
        int i, j;
        var next = new int[n];
        for (i = 0; i < n; i++) {
            next[i] = -1;
            for (j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    next[i] = arr[j];
                    break;
                }
            }
        }
        return next;
    }
}
