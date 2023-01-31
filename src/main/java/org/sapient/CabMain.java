package org.sapient;

import lombok.extern.log4j.Log4j2;

import java.util.*;

@Log4j2
public class CabMain {

    public static void main(String[] args) {
        var instance = new CabMain();
        instance.checkMinCab();
    }

    public void checkMinCab() {
        var cab01 = Cab.builder().cabRegNo(new Random().nextInt()).availableSeats(2).totalSeats(6).build();
        var cab02 = Cab.builder().cabRegNo(new Random().nextInt()).availableSeats(4).totalSeats(8).build();
        var cab03 = Cab.builder().cabRegNo(new Random().nextInt()).availableSeats(1).totalSeats(4).build();
        var cab04 = Cab.builder().cabRegNo(new Random().nextInt()).availableSeats(0).totalSeats(5).build();
        var cab05 = Cab.builder().cabRegNo(new Random().nextInt()).availableSeats(6).totalSeats(6).build();
        var cab06 = Cab.builder().cabRegNo(new Random().nextInt()).availableSeats(0).totalSeats(10).build();

        var cabList = Arrays.asList(cab01, cab02, cab03, cab04, cab05, cab06);
        cabList.sort(Comparator.comparing(Cab::getAvailableSeats));
        List<Cab> finalList = new LinkedList<>(cabList);
        finalList.removeIf(cab->cab.getAvailableSeats()==0);
        log.info("cabList: {}", finalList);
    }
}
