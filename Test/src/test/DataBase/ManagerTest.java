package DataBase;

import static org.junit.Assert.*;

import org.junit.Test;

public class ManagerTest {

	@Test //아이디 제대로 입력
	   public void searchIDtest1() {
	      //fail("Not yet implemented");
	      Bank test = new Bank(1);
	      assertEquals(1,test.searchID(325,1));
	   }
	   
	   @Test //아이디 다르게 입력
	   public void searchIDtest2() {
	      Bank test = new Bank(1);
	      assertEquals(0,test.searchID(324, 1));
	   }

}
