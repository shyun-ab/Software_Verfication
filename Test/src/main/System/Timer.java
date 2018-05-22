package System;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import View.MainFrame;

/**
 * 
 */
public class Timer extends Thread {

	   /**
     * 
     */
    private Calendar cal;
    private int day;

    /**
     * 
     */
    private int JackpotNum;
    
    public Timer() {
    	Random random = new Random();
    	JackpotNum=random.nextInt(5)+1;
    	cal = Calendar.getInstance();
    	File f = new File("date.txt");
    	if(f.exists()) {
    		try {
    			ArrayList<String> line=new ArrayList<String>();
    			int i=0;
				BufferedReader br = new BufferedReader(new FileReader("date.txt"));
				for(i=0;i<=line.size();i++) {
					
					line.add(br.readLine());
					if(line.get(i)==null) break;
				}
				br.close();
				cal.set(Integer.parseInt(line.get(0)),Integer.parseInt(line.get(1)), Integer.parseInt(line.get(2)), Integer.parseInt(line.get(3)), Integer.parseInt(line.get(4)), Integer.parseInt(line.get(5)));
				day=Integer.parseInt(line.get(2));
    		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else {
    		try {
    			PrintWriter fw = new PrintWriter("date.txt");
				String data=String.valueOf(cal.get(Calendar.YEAR));
    			fw.println(data);
    			data=String.valueOf(cal.get(Calendar.MONTH));
    			fw.println(data);
    			data=String.valueOf(cal.get(Calendar.DATE));
    			fw.println(data);
    			data=String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
    			fw.println(data);
    			data=String.valueOf(cal.get(Calendar.MINUTE));
    			fw.println(data);
    			data=String.valueOf(cal.get(Calendar.SECOND));
    			fw.println(data);
    			fw.close();
    			day=cal.get(Calendar.DATE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    public void run() {
    	super.run();
    	while(true) {
    		try {
				PrintWriter fw = new PrintWriter("date.txt");
				String data=String.valueOf(cal.get(Calendar.YEAR));
    			fw.println(data);
    			data=String.valueOf(cal.get(Calendar.MONTH));
    			fw.println(data);
    			data=String.valueOf(cal.get(Calendar.DATE));
    			fw.println(data);
    			data=String.valueOf(cal.get(Calendar.HOUR_OF_DAY));
    			fw.println(data);
    			data=String.valueOf(cal.get(Calendar.MINUTE));
    			fw.println(data);
    			data=String.valueOf(cal.get(Calendar.SECOND));
    			fw.println(data);
    			fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)+1);

    		if(checktime()) {
    			MainFrame.getSystem().set_usercount(1);
    			updateJackpotNum();
    		}
    	}
    }
    public Calendar getcal() {
    	return cal;
    }


    /**
     * @return
     */
    public Boolean checktime() {
        // TODO implement here
    	if(day!=cal.get(Calendar.DATE)) {
    		day=cal.get(Calendar.DATE);
    		return true;
    	}
        return false;
    }

    /**
     * @return
     */
    public void updateJackpotNum() {
        // TODO implement here
    	Random random = new Random();
    	JackpotNum=random.nextInt(10)+1;
        return;
    }

    /**
     * @param UserCount 
     * @return
     */
    public Boolean checkJackpot(int UserCount) {
        // TODO implement here
    	if(UserCount==JackpotNum) return true;
        return false;
    }

}