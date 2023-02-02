package org.sapient;

import lombok.extern.log4j.Log4j2;

import java.util.Hashtable;

@Log4j2
public class HashTableDemo {

    public static void main(String[] args) {
        var hashed = new Hashtable<Integer, String>(2);
        hashed.put(1,"one");
        //rehashing happens when inserting the below. befre the capacity is 2, and the threshold is 1
        hashed.put(2,"two");
        //after rehashing capacity is 5, and the threshold is 3
        hashed.put(3,"three");
        //again rehashing happens at 4th insertion
        hashed.put(4,"four");
        //after rehashing, capacity is 11, and the threshold is 8, after this rehashing occurs at 9th insertion
        hashed.put(5,"five");
        hashed.put(6,"six");
        log.debug("hashed: {}", hashed);
    }
}
