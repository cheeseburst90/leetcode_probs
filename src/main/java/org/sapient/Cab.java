package org.sapient;

import lombok.*;

import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cab {
    private Integer totalSeats;
    private Integer availableSeats;
    private Integer cabRegNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cab cab = (Cab) o;
        return availableSeats.equals(cab.availableSeats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableSeats);
    }
}
