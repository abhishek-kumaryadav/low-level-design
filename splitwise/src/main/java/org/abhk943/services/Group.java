package org.abhk943.services;

import org.abhk943.exceptions.IllegalAction;
import org.abhk943.models.Transaction;

import java.util.*;

public class Group implements GroupInterface {
    private Long groupId;
    private Map<Long, Member> memberIdToMemberMap;
    private List<Transaction> transactionList;
    private Double totalExpense;
    public Group (Long groupId, Long userId) {
        //        validate user
        this.groupId = groupId;
        this.memberIdToMemberMap = new HashMap<>();
        this.memberIdToMemberMap.put(userId, new Member(userId));
        this.transactionList = new ArrayList<>();
        this.totalExpense = 0D;
    }

    @Override public void addExpense(Long memberId, Map<Long, Double> memberToExpenseMap) throws IllegalAction {
        if (!this.memberIdToMemberMap.keySet().containsAll(memberToExpenseMap.keySet()))
            throw new IllegalAction("The users do not belong to this group");
        for(Long memberToId: memberToExpenseMap.keySet()){
            Transaction transaction = new Transaction();
            transaction.setFromMemberId(memberId);
            transaction.setToMemberId(memberToId);
            transaction.setAmount(memberToExpenseMap.get(memberToId));
            this.transactionList.add(transaction);
            this.totalExpense += memberToExpenseMap.get(memberToId);
            memberIdToMemberMap.get(memberToId).addExpense(memberToExpenseMap.get(memberToId));
            memberIdToMemberMap.get(memberId).addPaid(memberToExpenseMap.get(memberToId));
        }
    }

    @Override public void addMember(Long userId) throws IllegalAction {
        if (this.memberIdToMemberMap.containsKey(userId))
            throw new IllegalAction("Member already part of the group");
        this.memberIdToMemberMap.put(userId, new Member(userId));
    }

    @Override public Map<Long, Double> getSimpleTransactions(Long userId) {
        Map<Long, Double> toUserToAmountMap = new HashMap<>();
        for (Transaction transaction: this.transactionList){
            if (transaction.getToMemberId().equals(userId) && !transaction.getFromMemberId().equals(userId)){
                if (!toUserToAmountMap.containsKey(transaction.getFromMemberId()))
                    toUserToAmountMap.put(transaction.getFromMemberId(), 0D);
                toUserToAmountMap.put(transaction.getFromMemberId(),
                                      toUserToAmountMap.get(transaction.getFromMemberId()) + -1 * transaction.getAmount());
            } else if (!transaction.getToMemberId().equals(userId) && transaction.getFromMemberId().equals(userId)) {
                if (!toUserToAmountMap.containsKey(transaction.getToMemberId()))
                    toUserToAmountMap.put(transaction.getToMemberId(), 0D);
                toUserToAmountMap.put(transaction.getToMemberId(),
                                      toUserToAmountMap.get(transaction.getToMemberId()) + transaction.getAmount());
            }
        }
        return toUserToAmountMap;
    }

    @Override public void simplifyDebts() {

    }
}
