package org.abhk943.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private Long fromMemberId;
    private Long toMemberId;
    private Double amount;
}
