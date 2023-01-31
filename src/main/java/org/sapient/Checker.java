package org.sapient;

import java.util.Comparator;

public class Checker implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        if(o1.getScore()>o2.getScore()) {
            return -1;
        }
        else if (o1.getScore()==o2.getScore()) {
            return o2.getPlayerName().compareTo(o1.getPlayerName());
        }
        return 0;
    }
}
