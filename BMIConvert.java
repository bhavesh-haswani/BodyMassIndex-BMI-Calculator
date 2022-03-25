import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class BMIConvert {

	public static void main(String[] args) {
		Bcon co = new Bcon();
	}

}

class Bcon extends JFrame {

	JLabel lblFeet, lblInches, lblHeading;
	JTextField txtFeet, txtInches;
	JButton btnConvert, btnBack;
//	float resy;
	Container c;
	
	Bcon() {
		setSize(300, 400);
		setTitle("Height Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		btnBack = new JButton("Back");
		btnConvert = new JButton("Convert");
		
		lblFeet = new JLabel("Feet");
		lblInches = new JLabel("Inches");
		lblHeading = new JLabel("Enter your height");
		
		txtFeet = new JTextField(10);
		txtInches = new JTextField(10);
		
		c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 15));
		
		Font f = new Font("Calibri", Font.BOLD, 25);
		
		btnBack.setFont(f);
		btnConvert.setFont(f);
		lblFeet.setFont(f);
		lblInches.setFont(f);
		txtFeet.setFont(f);
		txtInches.setFont(f);
		lblHeading.setFont(f);
		
		c.add(lblHeading);
		c.add(lblFeet);
		c.add(txtFeet);
		c.add(lblInches);
		c.add(txtInches);
		c.add(btnConvert);
		c.add(btnBack);
		
//		3.281
		
		ActionListener convert = ae -> {
			try {
				if(txtFeet.getText().equals("")) {
					throw new IncompleteFeetException("Feet field empty");
				}
				String strFeet = txtFeet.getText();
				if(strFeet.matches("^[0-9]*$")==false) {
					throw new CharInFeetException("Feet contains character");
				}
				float feet = Float.parseFloat(txtFeet.getText());
				if(feet<2 || feet>7) {
					throw new OutOfRangeFeetException("Feet Out of Range");
				}

				if(txtInches.getText().equals("")) {
					throw new IncompleteInchesException("Inches field empty");
				}
				String strInches = txtInches.getText();
				if(strInches.matches("^[0-9]*[.]*[0-9]*$")==false) {
					throw new CharInInchesException("Inches contains character");
				}
//				float inches = Float.parseFloat(txtInches.getText())/12;
				float inches = Float.parseFloat(txtInches.getText());
				if(inches<0 || inches>11.999) {
					throw new OutOfRangeInchesException("Inches Out of Range");
				}
				inches = inches/12;
				float res = (feet+inches)/(float)3.281;
				JOptionPane.showMessageDialog(new JDialog(), "Your height in meter is " +res);
				setHeightToCal(feet, inches);
			}
			catch(IncompleteFeetException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Enter Feet ", "Warning", JOptionPane.WARNING_MESSAGE);
				txtFeet.requestFocus();
			}
			catch(CharInFeetException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Only integers allowed", "Error", JOptionPane.ERROR_MESSAGE);
				txtFeet.setText("");
				txtFeet.requestFocus();
			}
			catch(OutOfRangeFeetException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Feet range 2 - 7 allowed", "Error", JOptionPane.ERROR_MESSAGE);
				txtFeet.requestFocus();
			}
			catch(IncompleteInchesException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Enter Inches ", "Warning", JOptionPane.WARNING_MESSAGE);
				txtInches.requestFocus();
			}
			catch(CharInInchesException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Only integers allowed", "Error", JOptionPane.ERROR_MESSAGE);
				txtInches.setText("");
				txtInches.requestFocus();
			}
			catch(OutOfRangeInchesException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Inches range 0 - 11 allowed", "Error", JOptionPane.ERROR_MESSAGE);
				txtInches.requestFocus();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(new JDialog(), "issue: " +e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		};
		btnConvert.addActionListener(convert);
		
		ActionListener back = ae -> {
//			Bc c = new Bc();
			dispose();
		};
		
		btnBack.addActionListener(back);
		
		setVisible(true);
	}
	
	public void setHeightToCal(float feet, float inches) {
		float resy = (feet+inches)/(float)3.281;
		Bc.txtHeight.setText(Float.toString(resy));
	}
}

class IncompleteFeetException extends Exception {
	String msg;
	IncompleteFeetException(String msg) {
		this.msg = msg;
	}
}

class IncompleteInchesException extends Exception {
	String msg;
	IncompleteInchesException(String msg) {
		this.msg = msg;
	}
}

class CharInFeetException extends Exception {
	String msg;
	CharInFeetException(String msg) {
		this.msg = msg;
	}
}

class CharInInchesException extends Exception {
	String msg;
	CharInInchesException(String msg) {
		this.msg = msg;
	}
}

class OutOfRangeFeetException extends Exception {
	String msg;
	OutOfRangeFeetException(String msg) {
		this.msg = msg;
	}
}
class OutOfRangeInchesException extends Exception {
	String msg;
	OutOfRangeInchesException(String msg) {
		this.msg = msg;
	}
}