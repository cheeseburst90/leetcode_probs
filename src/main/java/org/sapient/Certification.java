package org.sapient;

import lombok.*;

import java.math.BigDecimal;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certification {
    private Integer certId;
    private String certName;
    private Boolean isReimbursed;
    private Integer certCost;
}
