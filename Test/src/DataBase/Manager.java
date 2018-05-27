package DataBase;

import java.util.*;

/**
 * 
 */
public class Manager {

    /**
     * Default constructor
     */
    public Manager(int id, int pw) {
    	ManagerID=id;
    	ManagerPW=pw;
    }

    /**
     * 
     */
    private int ManagerID;

    /**
     * 
     */
    private int ManagerPW;


    /**
     * @param inputID 
     * @return
     */
    public Boolean checkID(int inputID) {
        // TODO implement here
    	if(inputID==ManagerID) {
    		return true;
    	}
        return false;
    }

    /**
     * @param inputPW 
     * @return
     */
    public Boolean checkPW(int inputPW) {
        // TODO implement here
    	if(inputPW==ManagerPW) {
    		return true;
    	}
        return false;
    }

}