package org.designpatterns.observer;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

@Log4j2
public class BusNotifier {
    public static void main(String[] args) {
        var passenger1 = Passenger.builder().passengerName("girish").passengerSeatId("1A LB").mobileNumber(String.valueOf(RandomUtils.nextLong())).build();
        var passenger2 = Passenger.builder().passengerName("Abel").passengerSeatId("1A UB").mobileNumber(String.valueOf(RandomUtils.nextLong())).build();
        var passenger3 = Passenger.builder().passengerName("Kane").passengerSeatId("2A LB").mobileNumber(String.valueOf(RandomUtils.nextLong())).build();
        var passenger4 = Passenger.builder().passengerName("Sarah").passengerSeatId("2A UB").mobileNumber(String.valueOf(RandomUtils.nextLong())).build();
        var passenger5 = Passenger.builder().passengerName("Adam").passengerSeatId("3A LB").mobileNumber(String.valueOf(RandomUtils.nextLong())).build();
        BusNotificationSystem busNotificationSystem = new BusNotificationSystem();
        busNotificationSystem.addPassenger(passenger1);
        busNotificationSystem.addPassenger(passenger2);
        busNotificationSystem.addPassenger(passenger3);
        busNotificationSystem.addPassenger(passenger4);
        busNotificationSystem.addPassenger(passenger5);
        busNotificationSystem.notifyMessage("Bus starting point is from Majestic");
        busNotificationSystem.notifyMessage("Bus will have only one alighting point at Krishnagiri");
        busNotificationSystem.notifyMessage("Bus destination point is to Chennai");
        log.debug("passenger2 cancelled their ticket:::::::");
        busNotificationSystem.removeNotification4Passenger(passenger2);
        busNotificationSystem.notifyMessage("bus started at 4 o clock::::::****** Happy journey");

    }
}
