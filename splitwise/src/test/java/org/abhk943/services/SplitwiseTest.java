package org.abhk943.services;

import org.abhk943.exceptions.IllegalAction;
import org.junit.Before;

import static org.junit.Assert.*;

public class SplitwiseTest {

    private Splitwise splitwise;

    @Before
    public void setup(){
        splitwise = new Splitwise();
    }

    @org.junit.Test
    public void createGroup() throws IllegalAction {
        splitwise.createGroup(1L, 1L);
        try {
            splitwise.addMember(1L, 1L);
        } catch (IllegalAction illegalAction){
            System.out.println(illegalAction.getMessage());
        }
    }

    @org.junit.Test
    public void addExpense() {
    }

    @org.junit.Test
    public void addMember() {
    }

    @org.junit.Test
    public void simplifyDebts() {
    }
}