package User;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	@Test
	public void checkID_True_test() {
		Account test = new Account(123,456,"신한",10000,1);
		int output = test.checkID(123);
		assertEquals(1,output);
	}
	
	@Test
	public void checkID_False_test() {
		Account test = new Account(123,456,"신한",10000,1);
		int output = test.checkID(11111);
		assertEquals(0,output);
	}
	
	@Test
	public void checkPW_True_test() {
		Account test = new Account(123,456,"신한",10000,1);
		int output = test.checkPW(456);
		assertEquals(1,output);
	}
	
	@Test
	public void checkPW_False_test() {
		Account test = new Account(123,456,"신한",10000,1);
		int output = test.checkPW(11111);
		assertEquals(0,output);
	}
	
	@Test
	public void CheckBalance_True_test() {
		Account test = new Account(123,456,"신한",10000,1);
		int output = test.checkBalance(5000);
		assertEquals(5000,output);
	}
	@Test
	public void CheckBalance_False_test() {
		Account test = new Account(123,456,"신한",10000,1);
		int output = test.checkBalance(50000);
		assertEquals(-1,output);
	}

}
