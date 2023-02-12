package org.designpatterns.observer;

import lombok.*;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class Passenger implements INotify{
    private String passengerName;
    private String passengerSeatId;
    private String mobileNumber;

    @Override
    public void notify(String msg) {
        log.trace("messaging the passenger -- {} to their mobileNumber: {}", this.passengerName, this.mobileNumber);
        log.debug("Dear {}, the bus has an important message :{}", this.passengerName, msg);
    }
}
