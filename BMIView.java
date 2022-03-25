import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMIView {

	public static void main(String[] args) {
		Bv v = new Bv();
	}

}

class Bv extends JFrame {

	JTextArea txtA;
	JButton btnBack;
	JScrollPane scroll;
	Container c ;
	
	Bv() {
		setSize(550, 440);
		setTitle("View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));

		txtA = new JTextArea(10, 25);
		scroll = new JScrollPane(txtA);
		scroll = new JScrollPane(txtA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		txtA.setEditable(false);
//		scroll.setSize(100,100);
//		c.add(scroll);
//		c.add(txtA, BorderLayout.CENTER);
		c.add(scroll);
		
		btnBack = new JButton("Back");
		
		Font f = new Font("Calibri", Font.BOLD, 20);
		
		txtA.setFont(f);
		btnBack.setFont(f);
		
		
		c.add(btnBack);
		
		txtA.setText(DBHandler.viewBMI());
		
		ActionListener back = ae -> {
			Bm b = new Bm();
			dispose();
		};
		btnBack.addActionListener(back);
		
		setVisible(true);
	}
}