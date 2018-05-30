package User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * 
 */
public class Account {

    /**
     * Default constructor
     */
    public Account(int id,int pw, String name, int balance, int code) {
    	ID=id;
    	password=pw;
    	Name=name;
    	Balance=balance;
    	Random random = new Random();
    	ArrayList<Integer> arrayid=new ArrayList<Integer>();
    	ArrayList<Integer> arraypw=new ArrayList<Integer>();
    	int _id=random.nextInt(89999)+10000;
    	int _pw=random.nextInt(8999)+1000;
    	
    	File f = new File(String.valueOf(id)+"_balance.txt");
    	if(f.exists()) {
    		try {
					BufferedReader br = new BufferedReader(new FileReader(String.valueOf(id)+"_balance.txt"));
					String line = br.readLine();
					br.close();
					Balance=Integer.parseInt(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else {
    		PrintWriter fw;
			try {
				fw = new PrintWriter(String.valueOf(id)+"_balance.txt");
				String data=String.valueOf(balance);
				fw.println(data);
				fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	f = new File(String.valueOf(id)+".txt");
    	if(f.exists()) {
    		try {
				BufferedReader br = new BufferedReader(new FileReader(String.valueOf(id)+".txt"));
				int i=0;
				while(true) {
		            String line = br.readLine();
		            if (line==null) break;
		     
		            if(i%2==0) arrayid.add(Integer.valueOf(line));
		            else arraypw.add(Integer.valueOf(line));
		            i++;
		        }
				br.close();
				card.add(new Card(arrayid.get(0),arraypw.get(0)));
				card.add(new Card(arrayid.get(1),arraypw.get(1)));
    		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else {
    		try {
    			_id=random.nextInt(89999)+10000;
    	    	arrayid.add(Integer.valueOf(_id));
    	    	_pw=random.nextInt(8999)+1000;
    	    	arraypw.add(Integer.valueOf(_pw));
    	    	card.add(new Card(_id,_pw));
    	    	_id=random.nextInt(89999)+10000;
    	    	arrayid.add(Integer.valueOf(_id));
    	    	_pw=random.nextInt(8999)+1000;
    	    	arraypw.add(Integer.valueOf(_pw));
    	    	card.add(new Card(_id,_pw));
    			PrintWriter fw = new PrintWriter(String.valueOf(id)+".txt");
				String data=String.valueOf(arrayid.get(0));
    			fw.println(data);
    			data=String.valueOf(arraypw.get(0));
    			fw.println(data);
    			data=String.valueOf(arrayid.get(1));
    			fw.println(data);
    			data=String.valueOf(arraypw.get(1));
    			fw.println(data);
    			fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	Code=code;
    }
    
    private ArrayList<Card> card=new ArrayList<>();
    /**
     * 
     */
    private int ID;

    /**
     * 
     */
    private int password;

    /**
     * 
     */
    private String Name;

    /**
     * 
     */
    private int Balance;

    private Card currentcard;
    /**
     * 
     */
    public Set<Card> Have;
    
    private int Code;

    /**
     * @param inputID 
     * @return
     */
    public int checkID(int inputID) {
        // TODO implement here
    	if(ID==inputID) return 1;
    	else return 0;
        //return 0;
    }

    /**
     * @param inputID 
     * @return
     */
    public int searchCardID(int inputID) {
        // TODO implement here
    	for(int index=0; index<card.size(); index++) {
    	int check = card.get(index).checkCardID(inputID);
    	
    	if(check==1) {
    		currentcard=card.get(index);
    		return 1;
    	}
    	}
        return 0;
    }

    /**
     * @param inputPW 
     * @return
     */
    public int checkPW(int inputPW) {
        // TODO implement here
    	//(password);
    	//(inputPW);
    	if(password==inputPW) {
    		//(password);
        	//(inputPW);
    		return 1;
    	}
        return 0;
    }

    /**
     * @param inputPW 
     * @return
     */
    public int searchCard(int inputPW) {
        // TODO implement here
    	int check = currentcard.checkPW(inputPW);
    	if(check==1) {
    		return 1;
    	}
        return 0;
    }

    /**
     * @param inputMoney 
     * @return
     */
    public int balanceAccount(int inputMoney) {
        // TODO implement here
    	int balance = checkBalance(inputMoney);
    	if(balance>=0) {
    		PrintWriter fw;
			try {
				fw = new PrintWriter(String.valueOf(ID)+"_balance.txt");
				String data=String.valueOf(balance);
				fw.println(data);
				fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return balance;
    }

    /**
     * @param inputMoney 
     * @return
     */
    public int checkBalance(int inputMoney) {
        // TODO implement here
    	//(inputMoney);
    	if(Balance >= inputMoney) {
    		//(inputMoney);
    		int balance = Balance - inputMoney;
    		if(balance<0 || balance >1000000000) return -4;
    		Balance-=inputMoney;
    		return Balance;
    	}
    	else {
    		return -2;
    	}
    }

    /**
     * @return
     */
    public int getBalance() {
        // TODO implement here
        return Balance;
    }

}