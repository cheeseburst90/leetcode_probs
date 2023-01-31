package org.sapient;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String name;
    private String oracleId;
    private BigDecimal salary;
    private List<Certification> certifications;
}
