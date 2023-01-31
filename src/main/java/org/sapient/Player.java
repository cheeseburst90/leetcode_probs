package org.sapient;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
public class Player {
    private String playerName;

    private int score;
}
