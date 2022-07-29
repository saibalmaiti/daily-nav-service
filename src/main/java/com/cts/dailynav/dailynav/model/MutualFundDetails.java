package com.cts.dailynav.dailynav.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "mutualfund_details")
public class MutualFundDetails {
    @Id
    @Column(name = "mutualfund_id")
    private int mutualFundId;
    @Column(name = "mutualfund_name", nullable = false)
    private String mutualFundName;
    @Column(name = "mutualfund_price", nullable = false)
    private double mutualFundValue;
}
