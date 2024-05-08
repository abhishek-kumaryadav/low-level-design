package org.abhk943.services;

import org.abhk943.exceptions.IllegalAction;

import java.util.HashMap;
import java.util.Map;

public interface SplitWiseInterface {
    public void createGroup(Long groupId, Long userId) throws IllegalAction;

    void addExpense(Long groupId, Long memberId, Map<Long, Double> memberToExpenseMap)
            throws IllegalAction;

    public void addMember(Long groupId, Long userId) throws IllegalAction;
    public void simplifyDebts(Long groupId);
}
