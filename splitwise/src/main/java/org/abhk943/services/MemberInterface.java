package org.abhk943.services;

import java.util.HashMap;

public interface MemberInterface {

    void addExpense(Double amount);

    void addPaid(Double amount);

    Long addMember(Long userId);
}
