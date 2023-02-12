package org.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class BusNotificationSystem {
    private List<INotify> notifyList = new ArrayList<>();

    public void addPassenger(INotify toBNotified){
        notifyList.add(toBNotified);
    }

    public void removeNotification4Passenger(INotify notify){
        notifyList.remove(notify);
    }

    public void notifyMessage(String message){
        for (INotify notify:
             notifyList) {
            notify.notify(message);
        }
    }
}
