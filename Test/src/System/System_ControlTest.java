package System;

import static org.junit.Assert.*;

import org.junit.Test;

public class System_ControlTest {

	@Test
	public void input_ID_TrueTest() {//�ý��ۿ� ��ϵǾ� �ִ� ���¸� Ȯ���ϴ� �׽�Ʈ
		System_Control test = new System_Control();
		boolean output = test.input_ID(325);
		assertEquals(true,output);
	}
	@Test
	public void input_ID_FalseTest() {
		System_Control test = new System_Control();
		boolean output = test.input_ID(111111);
		assertEquals(false,output);
		
	}
	@Test
	public void input_RID_TrueTest() {
		System_Control test = new System_Control();
		boolean output = test.input_RID(325);
		assertEquals(true,output);
		
	}
	@Test
	public void input_RID_FalseTest() {
		System_Control test = new System_Control();
		boolean output = test.input_RID(11111);
		assertEquals(false,output);
		
	}
	@Test
	public void input_MID_TrueTest() {
		System_Control test = new System_Control();
		boolean output = test.input_MID(123);
		assertEquals(true,output);
	}
	@Test
	public void input_MID_FalseTest() {
		System_Control test = new System_Control();
		boolean output = test.input_MID(11111);
		assertEquals(false,output);
	}

	@Test
	public void input_MPW_TrueTest() {
		System_Control test = new System_Control();
		boolean output = test.input_MPW(235);
		assertEquals(true,output);
	}
	@Test
	public void input_MPW_FalseTest() {
		System_Control test = new System_Control();
		boolean output = test.input_MPW(111111);
		assertEquals(false,output);
	}
		

}
