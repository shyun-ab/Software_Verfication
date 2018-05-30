package DataBase;

import java.util.*;
import User.Account;

/**
 * 
 */
public final class Bank {

    /**
     * Default constructor
     */
    public Bank(int code) {
    	BankCode=code;
    	switch (code) {
		case 1:
			account.add(new Account(325,6124,"°¨±Ö",10000090, code));
			account.add(new Account(3245,612,"°¨",70000, code));
			break;
		case 2:
			account.add(new Account(6324,1111,"¿À·»Áö",100090, code));
			break;
		case 3:
			account.add(new Account(6114,1111,"¿ÀÁö",10090, code));
			break;
		default:
			break;
		}
    }
    private ArrayList<Account> account = new ArrayList<>();
    private Account currentaccount=null;
    private Account currentraccount=null;
    /**
     * 
     */
    private String Name;

    /**
     * 
     */
    private int BankCode;

    /**
     * 
     */
    private Boolean isAccount;



    /**
     * @param inputID 
     * @return
     */
    public int searchID(int inputID, int choose) {
        // TODO implement here
    	if(choose==1) {
    		isAccount=false;
    		currentaccount=null;
    	    currentraccount=null;
    	for(int index=0; index<account.size();index++) {
    	int check=account.get(index).checkID(inputID);
    	if(check==1) {
    		currentaccount = account.get(index);
			isAccount=true;
    		return 1;
    	}
    	else {
    		check=account.get(index).searchCardID(inputID);
    		if(check==1) {
    			currentaccount = account.get(index);
    			return 1;
    		}
    	}
    	}
        return 0;
    	}
    	else if(choose==2) {
    	    currentraccount=null;
    		for(int index=0; index<account.size();index++) {
    	    	int check=account.get(index).checkID(inputID);
    	    	if(check==1) {
    	    		currentraccount = account.get(index);
    	    		if(currentraccount.equals(currentaccount)) return 0;
    	    		return 1;
    	    	}
    	    	else {
    	    		check=account.get(index).searchCardID(inputID);
    	    		if(check==1) {
    	    			currentraccount = account.get(index);
    	    			if(currentraccount.equals(currentaccount)) return 0;
    	    			return 1;
    	    		}
    	    	}
    	    	}
    	        return 0;
    	}
    	return 0;
}
    

    /**
     * @param inputPW 
     * @return
     */
    public int checkPW(int inputPW) {
        // TODO implement here
    	int check;
    	if(isAccount) {
    	check = currentaccount.checkPW(inputPW);
    	if(check == 1) {
    		//currentaccount=null;
    		return 1;
    	}
    	return 0;
    	}
    	else {
    		check=currentaccount.searchCard(inputPW);
			if(check==1) {
				//currentaccount=null;
				return 1;
			}
			return 0;
    	}

    }

    /**
     * @param inputMoney 
     * @return
     */
    public int balanceCount(int inputMoney) {
        // TODO implement here
    	int balance = -2;
    	if(currentaccount!=null&&currentraccount!=null) {
    		balance = currentaccount.balanceAccount(inputMoney+1200);
    		if(balance<0) return balance;
    		int checkbalance = currentraccount.balanceAccount(-inputMoney);
    		if(checkbalance<0) return checkbalance;
    	}
    	else if(currentaccount!=null) {
    		balance = currentaccount.balanceAccount(inputMoney);
    		//currentaccount=null;
    	}
    	else if(currentraccount!=null) {
    		if((currentaccount==null)) {
    			int checkbalance = currentraccount.balanceAccount(-inputMoney);
    			return checkbalance;
    		}
    		//currentraccount=null;
    	}
//    	if(currentaccount!=null) {
//    		balance = currentaccount.balanceAccount(inputMoney);
//    		//currentaccount=null;
//    	}
//    	if(currentraccount!=null) {
//
//    		if((currentaccount==null) || (currentaccount!=null && balance>=0)) {
//    			int checkbalance = currentraccount.balanceAccount(-inputMoney);
//
//    			if(checkbalance<0) return checkbalance;
//    		}
//    		//currentraccount=null;
//    	}
    	return balance;
    }

    /**
     * @return
     */
    public int getAccountBalance() {
        // TODO implement here
    	int balance = currentaccount.getBalance();
    	currentaccount=null;
    	currentraccount=null;
        return balance;
    }

}