package org.abhk943.services;

import org.abhk943.exceptions.IllegalAction;

import java.util.HashMap;
import java.util.Map;

public interface GroupInterface {

    void addExpense(Long memberId, Map<Long, Double> memberToExpenseMap) throws IllegalAction;

    void addMember(Long userId) throws IllegalAction;
    Map<Long, Double> getSimpleTransactions(Long userId);

    void simplifyDebts();
}
