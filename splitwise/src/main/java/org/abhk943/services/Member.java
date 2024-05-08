package org.abhk943.services;

public class Member implements MemberInterface{

    private Long id;
    private Double totalPaid;
    private Double totalExpense;

    public Member(Long userId) {
        this.id = userId;
        this.totalPaid = 0D;
        this.totalExpense = 0D;
    }

    @Override public void addExpense(Double amount) {
        totalExpense += amount;
    }
    @Override public void addPaid(Double amount) {
        totalPaid += amount;
    }

    @Override public Long addMember(Long userId) {
        return null;
    }
}
