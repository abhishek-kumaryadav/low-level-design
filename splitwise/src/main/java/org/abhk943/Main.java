package org.abhk943;

import org.abhk943.exceptions.IllegalAction;
import org.abhk943.services.Splitwise;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IllegalAction {

        Splitwise splitwise = new Splitwise();
        splitwise.createGroup(1L, 1L);
        splitwise.addMember(1L, 2L);
        Map<Long, Double> hashMap = new HashMap<>();
        hashMap.put(1L, 2D);
        splitwise.addExpense(1L, 1L, hashMap);
        splitwise.addExpense(1L, 2L, hashMap);
    }
}