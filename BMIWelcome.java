import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMIWelcome {

	public static void main(String[] args) {
		BMIWel well = new BMIWel();
	}

}

class BMIWel extends JFrame {
	
	JLabel lblwel, lblwel2;
	Container c;
	
	BMIWel (){
		setSize(500, 500);
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		c = getContentPane();
//		c.setLayout(new BorderLayout());
		c.setLayout(new GridLayout());
		
		lblwel = new JLabel("BMI Calci\n by Kamal Sir");
		lblwel2 = new JLabel("by Kamal Sir");
		
		lblwel.setHorizontalAlignment(JLabel.CENTER);
		lblwel.setVerticalAlignment(JLabel.CENTER);
//		lblwel2.setHorizontalAlignment(JLabel.CENTER);
//		lblwel2.setVerticalAlignment(JLabel.CENTER);
		
		Font f = new Font("Calibri", Font.BOLD, 50);
		
		lblwel.setFont(f);
//		lblwel2.setFont(f);
		
		lblwel.setForeground(Color.RED);
//		lblwel2.setForeground(Color.RED);
		
		c.add(lblwel);
//		c.add(lblwel2);
		
		
		setVisible(true);
		try {
			Thread.sleep(1000);
//			JOptionPane.showMessageDialog(c, "Hello I'm thread");
			Bm b = new Bm();
			dispose();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(new JDialog(), e);
		}
//		dispose(Thread.sleep(10));
	}
}