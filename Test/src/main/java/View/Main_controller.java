package View;

import javax.swing.JOptionPane;

public class Main_controller {
	private static MainFrame frame;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Main_controller main = new Main_controller();
			MainFrame frame = main.getMainFrame();
			frame=new MainFrame();
			frame.setVisible(true);
			//frame.getDefaultCloseOperation();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�̹����� Ȯ���ϼ���", "�̹��� ����", JOptionPane.WARNING_MESSAGE);
			MainFrame.getSystem().get_Timer().stop();
		}
	}
	public static MainFrame getMainFrame() {
		return frame;
	}

}
