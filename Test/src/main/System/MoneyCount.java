package System;

import java.util.*;

/**
 * 
 */
public class MoneyCount {

    /**
     * Default constructor
     */
    public MoneyCount(int count50000,int count10000, int count5000,int count1000) {
    	Count50000=count50000;
    	Count10000=count10000;
    	Count5000=count5000;
    	Count1000=count1000;
    }

    /**
     * 
     */
    private int Count50000;

    /**
     * 
     */
    private int Count10000;

    /**
     * 
     */
    private int Count5000;

    /**
     * 
     */
    private int Count1000;


    /**
     * @param inputMoney 
     * @param inputcount 
     * @param inputPOM 
     * @return
     */
    public int getCount50000() {
    	return Count50000;
    }
    public int getCount10000() {
    	return Count10000;
    }
    public int getCount5000() {
    	return Count5000;
    }
    public int getCount1000() {
    	return Count1000;
    }
    public Boolean ATMBalanceUpdate(int inputMoney, int inputcount, int inputPOM) {
        // TODO implement here
    	switch (inputMoney) {
		case 50000:
			if(inputPOM < 0) {
				if(Count50000>=inputcount) {
					Count50000+=inputcount*inputPOM;
					return true;
				}
				else return false;
			}
			else {
				Count50000+=inputcount*inputPOM;
				return true;
			}
		case 10000:
			if(inputPOM < 0) {
				if(Count10000>=inputcount) {
					Count10000+=inputcount*inputPOM;
					return true;
				}
				else return false;
			}
			else {
				Count10000+=inputcount*inputPOM;
				return true;
			}
		case 5000:
			if(inputPOM < 0) {
				if(Count5000>=inputcount) {
					Count5000+=inputcount*inputPOM;
					return true;
				}
				else return false;
			}
			else {
				Count5000+=inputcount*inputPOM;
				return true;
			}
		case 1000:
			if(inputPOM < 0) {
				if(Count1000>=inputcount) {
					Count1000+=inputcount*inputPOM;
					return true;
				}
				else return false;
			}
			else {
				Count1000+=inputcount*inputPOM;
				return true;
			}
		default:
			break;
		}
		return false;
    	
    }

}