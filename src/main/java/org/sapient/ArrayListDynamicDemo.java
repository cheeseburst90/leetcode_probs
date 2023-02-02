package org.sapient;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;

@Log4j2
public class ArrayListDynamicDemo {
    public static void main(String[] args) {
        var list = new ArrayList<Integer>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        log.debug(list);
    }
}
