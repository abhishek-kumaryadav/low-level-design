package org.abhk943.services;

import org.abhk943.exceptions.IllegalAction;
import org.abhk943.models.User;

import java.util.HashMap;
import java.util.Map;

public class Splitwise implements SplitWiseInterface{
    private Map<Long, Group> groupMap;
    private Map<Long, User> userMap;

    public Splitwise(){
        this.groupMap = new HashMap<>();
        this.userMap = new HashMap<>();
    }
    @Override public void createGroup(Long groupId, Long userId) throws IllegalAction {
        if (groupMap.containsKey(groupId))
            throw new IllegalAction("Group already exists with group ID: " + groupId);
        groupMap.put(groupId, new Group(groupId, userId));
        if (!userMap.containsKey(userId))
            userMap.put(userId, new User(userId));
    }

    @Override public void addExpense(Long groupId, Long memberId, Map<Long, Double> memberToExpenseMap)
            throws IllegalAction {
        this.groupMap.get(groupId).addExpense(memberId, memberToExpenseMap);
    }

    @Override public void addMember(Long groupId, Long userId) throws IllegalAction {
        if (!userMap.containsKey(userId))
            userMap.put(userId, new User(userId));
        this.groupMap.get(groupId).addMember(userId);

    }

    @Override public void simplifyDebts(Long groupId) {

    }
}
