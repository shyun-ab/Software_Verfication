package System;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import DataBase.Bank;
import DataBase.Manager;

/**
 * 
 */
public class System_Control {

    /**
     * Default constructor
     */
    public System_Control() {
    	
    	bank.add(new Bank(1));
    	bank.add(new Bank(2));
    	bank.add(new Bank(3));
    	UserCount=1;
    	manager = new Manager(123,235);
    	moneycount = new MoneyCount(100,100,0,0);
    	timer.start();
    }
    
    private ArrayList<Bank> bank = new ArrayList<>();
    private MoneyCount moneycount;
    public MoneyCount getATMcount() {
    	return moneycount;
    }
    public int get_input_menu() {
    	return inputMenu;
    }
    public void set_usercount(int input) {
    	UserCount=input;
    }
    
    private int isjackpot=0;
    /*
     * 
     */
    private int TotalMoney;

    /**
     * 
     */
    private int inputID;

    /**
     * 
     */
    private int inputPW;

    /**
     * 
     */
    private int inputMoney;

    /**
     * 
     */
    private int UserCount;

    /**
     * 
     */
    private static int inputMenu;

    /**
     * 
     */
    private int inputPOM;

    /**
     * 
     */
    private int input50000;

    /**
     * 
     */
    private int input10000;

    /**
     * 
     */
    private int input5000;

    /**
     * 
     */
    private int input1000;
    private Bank currentbank=null;
    private Bank currentrbank=null;
    //private GUI_Interface GUI;
    private Timer timer = new Timer();
    private Manager manager;



    /**
     * @return
     */
    public void input_menu(int input) {
        // TODO implement here
    	inputMenu=input;
    	currentbank=null;
    	currentrbank=null;
        return;
    }

    /**
     * @return
     */
    public Boolean input_ID(int input) {
        // TODO implement here
    	inputID=input;
    	switch (inputMenu) {
		case 5:
			if(manager.checkID(input)) {
				return true;
			}
			return false;

		default:
			for(int index=0; index<bank.size(); index++) {
		    	int check=bank.get(index).searchID(input,1);
		    	if(check==1) {
		    		currentbank=bank.get(index);
		    		return true;
		    	}
			}
			break;
		}

        return false;
    }
    
    public Boolean input_RID(int input) {
        // TODO implement here
    	if(inputID==input) return false;
    	for(int index=0; index<bank.size(); index++) {
    	int check=bank.get(index).searchID(input,2);
    	if(check==1) {
    		currentrbank=bank.get(index);
    		return true;
    	}
    	}
        return false;
    }

    /**
     * @return
     */
    public int input_amount(ArrayList<Integer> input) {
        // TODO implement here
    	if(input.size()<=1) {
    		inputMoney=input.get(0);
    	}
    	else if(input.size()<=2) {
    	inputMoney=50000*input.get(0);
    	inputMoney+=10000*input.get(1);
    	input50000=input.get(0);
    	input10000=input.get(1);
    	TotalMoney-=inputMoney;
    	}
    	else {
    		inputMoney=50000*input.get(0);
        	inputMoney+=10000*input.get(1);
        	inputMoney+=5000*input.get(2);
        	inputMoney+=1000*input.get(3);
        	inputMoney=-(inputMoney);
        	input50000=input.get(0);
        	input10000=input.get(1);
        	input5000=input.get(2);
        	input1000=input.get(3);
        	//TotalMoney-=inputMoney;
    	}
    	Boolean isbool;
    	switch (inputMenu) {
		case 2:
			int check=updateBalance();
    		if(check>0) {
    			for(int i=1;i<5;i++) {
    				switch (i) {
					case 1:
						isbool = moneycount.ATMBalanceUpdate(50000, input50000, 1);
						TotalMoney+=50000*input50000;
						break;
					case 2:
						isbool = moneycount.ATMBalanceUpdate(10000, input10000, 1);
						TotalMoney+=10000*input10000;
						break;
					case 3:
						isbool = moneycount.ATMBalanceUpdate(5000, input5000, 1);
						TotalMoney+=5000*input5000;
						break;
					case 4:
						isbool = moneycount.ATMBalanceUpdate(1000, input1000, 1);
						TotalMoney+=1000*input1000;
						break;
					}
    			}
    			return check;
    		}
    		else {
    			return -1;
    		}
		case 3:
			return 0;
		case 5:
			if((moneycount.getCount50000()<input50000)||(moneycount.getCount10000()<input10000)) return -1; 
			for(int i=1;i<5;i++) {
				switch (i) {
				case 1:
					moneycount.ATMBalanceUpdate(50000, input50000, inputPOM);
					TotalMoney+=50000*input50000;
					break;
				case 2:
					moneycount.ATMBalanceUpdate(10000, input10000, inputPOM);
					TotalMoney+=10000*input10000;
					break;
				case 3:
					moneycount.ATMBalanceUpdate(5000, input5000, inputPOM);
					TotalMoney+=5000*input5000;
					break;
				case 4:
					moneycount.ATMBalanceUpdate(1000, input1000, inputPOM);
					TotalMoney+=1000*input1000;
					break;
				}
			}
			return 0;

		default:
			return 0;
		}
    	
    }

    /**
     * @return
     */
    public int input_PW(int input) {
        // TODO implement here
    	int check = currentbank.checkPW(input);
    	if(check==0) return -1; //비밀번호 오류
    	switch (inputMenu) {
		case 1:
			if(check==1) {
				if((moneycount.getCount50000()<input50000)||(moneycount.getCount10000()<input10000)) return -3; 
				int balance=0;
				balance=updateBalance();
	    		if(balance>=0) {
	    			Boolean _isjackpot = timer.checkJackpot(UserCount);
	    			if(_isjackpot) {
	    				isjackpot=1;
	    				input50000+=1;
	    				TotalMoney-=50000;
	    			}
	    			for(int i=1;i<5;i++) {
	    				switch (i) {
						case 1:
							moneycount.ATMBalanceUpdate(50000, input50000, -1);
							TotalMoney-=50000*input50000;
							break;
						case 2:
							moneycount.ATMBalanceUpdate(10000, input10000, -1);
							TotalMoney-=10000*input10000;
							break;
						case 3:
							moneycount.ATMBalanceUpdate(0, 0, -1);
							break;
						case 4:
							moneycount.ATMBalanceUpdate(0, 0, -1);
							break;
						}
	    			}
	    			UserCount++;
	    			return balance;
	    		}
	    		else {
	    			return -2;//input_amount 오류
	    		}
	    	}
			else return -1;//비밀번호오류
		case 2:
			
			break;
		case 3:
			if(check==1) {
				int balance=0;
				balance=updateBalance();
				System.out.println(balance);
	    		if(balance>=0) {
	    			return balance;
	    		}
	    		else {
	    			return -2;//input_amount 오류
	    		}
	    	}
			else return -1;//비밀번호오류
		case 4:
			return currentbank.getAccountBalance();
		default:
			break;
		}
        return -1;
    }

    /**
     * @return
     */
    public int updateBalance() {
        // TODO implement here
    	if(inputMenu==3) {
    		if(!currentrbank.equals(currentbank)) {
    			if(currentrbank!=null) currentrbank.balanceCount(inputMoney);
    	    	return currentbank.balanceCount(inputMoney);
    		}
    		else {
    			return currentbank.balanceCount(inputMoney);
    		}
    	}
    	else {
    	if(currentrbank!=null) currentrbank.balanceCount(inputMoney);
    	return currentbank.balanceCount(inputMoney);
    	}
    }

    /**
     * @return
     */
    public Boolean input_MID(int input) {
        // TODO implement here
    	if(manager.checkID(input)) return true;
        return false;
    }

    /**
     * @return
     */
    public void input_POM(int input) {
        // TODO implement here
    	inputPOM=input;
        return;
    }

    /**
     * @return
     */
    public Boolean input_MPW(int input) {
        // TODO implement here
    	if(manager.checkPW(input)) return true;
        return false;
    }
    
    public int get_inputMoney() {
    	return inputMoney;
    }
    public int get_isjackpot() {
    	return isjackpot;
}

}