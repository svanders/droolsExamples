/*
 * Copyright (c) 2016 EDMI NZ
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of EDMI. 
 * ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with EDMI.
 */
package nz.edmi.drools.domain;

/**
 * // TODO class Javadoc
 *
 * @author simonvandersluis
 */
public class Account {

  private int balance = 0;

  public Account(int balance) {
    this.balance = balance;
  }

  public int getBalance() {
    return balance;
  }

  public void increment(int amount) {
    balance += amount;
  }

  public void decrement(int amount) {
    balance -= amount;
  }
}
