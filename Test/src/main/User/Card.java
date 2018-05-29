package User;

import java.util.*;

/**
 * 
 */
public class Card {

    /**
     * Default constructor
     */
    public Card(int id, int pw) {
    	ID=id;
    	password=pw;
    	
    }

    /**
     * 
     */
    private int ID;

    /**
     * 
     */
    private int password;


    /**
     * @param inputID 
     * @return
     */
    public int checkCardID(int inputID) {
        // TODO implement here
    	if(inputID==ID) {
    		return 1;
    	}
        return 0;
    }

    /**
     * @param inputPW 
     * @return
     */
    public int checkPW(int inputPW) {
        // TODO implement here
    	if(password==inputPW) {
    		return 1;
    	}
        return 0;
    }

}