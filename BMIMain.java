import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMIMain {

	public static void main(String[] args) {
		Bm b = new Bm();
	}

}

class Bm extends JFrame {
	
	JButton btnCalculate, btnViewHistory, btnExportData;
	JTextField txtCount;
	Container c;
	
	Bm() {
		setSize(400, 500);
		setTitle("BMI Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
		
		btnCalculate = new JButton("Calculate");
		btnViewHistory = new JButton("View History");
		btnExportData = new JButton("Export Data");
		txtCount = new JTextField(6);
		txtCount.setEditable(false);
		
		Font f = new Font("Calibri", Font.BOLD, 30);
		
		btnCalculate.setFont(f);
		btnViewHistory.setFont(f);
		btnExportData.setFont(f);
		txtCount.setFont(f);
		
		c.add(btnCalculate);
		c.add(btnViewHistory);
		c.add(btnExportData);
		c.add(txtCount);
		
		String msg = "Count = " +DBHandler.countRowsFromTable();
		txtCount.setText(msg);
		
		ActionListener calculate = ae -> {
			Bc cal = new Bc();
			dispose();
		};
		btnCalculate.addActionListener(calculate);
		
		ActionListener view = ae -> {
			Bv v = new Bv();
			dispose();
		};
		btnViewHistory.addActionListener(view);
		
		ActionListener export = ae -> {
			DBHandler.exportData();
		};
		btnExportData.addActionListener(export);
		
		setVisible(true);
	}
}
