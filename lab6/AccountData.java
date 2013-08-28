/* AccountData.java */

import sortedlist.*;

/**
 *  Implements a customer's account profile for the virtual teller machine.
 **/
public class AccountData implements Keyable {
  private String name;        // Customer name.
  private int    balance;     // Starting balance.
  private int    number;      // Account number.

  /**
   *  Constructs a new account for customer "newName" with acount number "num"
   *  and a $0 starting balance.
   **/
  public AccountData(String newName, int num) {
    name = newName;
    number = num;
    balance = 0;
  }

  /**
   *  lessThan() returns true if this account's number is less than the
   *  argument's account number.
   **/
  public boolean lessThan(Keyable x) {
    return number < ((AccountData) x).number;
  }  

  /**
   *  getOwner() returns the name of this account's owner.
   **/
  public String getOwner() {
    return name;
  }

  /**
   *  toString() returns a String version of this account's number.
   **/
  public String toString() {
    return "" + number;
  }

    
  /**
   *  getBalance() returns the balance of this account.
   **/
  public int getBalance() {
    return balance;
  }

  /** 
   *  withdraw() reduces the balance by the withdrawal amount "amt".
   **/
  public void withdraw(int amt) {
    if (amt <= balance) {
      balance = balance - amt;
    } else {
      System.out.println("Error:  Insufficient funds: " + amt);
    }
  }

  /**
   *  deposit() deposits "amt" dollars into this account.
   **/
  public void deposit(int amt) {
    if (amt >= 0) {
      balance = balance + amt;
    } else {
      System.out.println("Error:  Tried to deposit less than 0: " + amt);
    }
  }

  /**
   *  getNumber() returns this account's number.
   **/
  public int getNumber() {
    return number;
  }

  /**
   *  getKey() returns this account's account number as the key to use for
   *  sorting and comparison.
   **/
  public int getKey() {
    return number;
  }
}
