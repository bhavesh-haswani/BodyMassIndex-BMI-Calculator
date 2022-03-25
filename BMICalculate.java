import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class BMICalculate {

	public static void main(String[] args) {
		Bc cal = new Bc(); 
	}

}

class Bc extends JFrame {
	
	JButton btnCalculate, btnBack, btnConvert;
	JLabel lblName, lblAge, lblPhone, lblGender, lblHeight, lblWeight;
	JTextField txtName, txtAge, txtPhone, txtWeight;
	static JTextField txtHeight;
	JRadioButton rdbtnM, rdbtnF;
	ButtonGroup bg;
	Container c;
	JPanel pnl1, pnl2, pnl3;
	GridBagConstraints gbc = new GridBagConstraints();
	
	Bc() {
		setSize(700, 500);
//		setSize(600, 400);
		setTitle("Pane and Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setResizable(false);
		
		c = getContentPane();
//		c.setLayout(new BorderLayout(10, 5));
		c.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();		
//		panel.setLayout(new GridLayout(13, 3));
//		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
//		panel.setLayout(new CardLayout(10, 10));
		panel.setLayout(new GridBagLayout());

		JPanel panel2 = new JPanel();		
//		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
		panel2.setLayout(new GridBagLayout());
		
		JPanel panel3 = new JPanel();		
//		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
		panel3.setLayout(new GridBagLayout());

//		panel.setBackground(Color.RED);
//		panel2.setBackground(Color.BLUE);
//		panel3.setBackground(Color.GREEN);
		
		c.add(panel, BorderLayout.WEST);
		c.add(panel2, BorderLayout.CENTER);
		c.add(panel3, BorderLayout.EAST);
		

		
		btnCalculate = new JButton("Calculate");
		btnBack = new JButton("Back");
		btnConvert = new JButton("Convert");
		
		lblName = new JLabel("Enter name	");
		lblAge = new JLabel("Enter age	");
		lblPhone = new JLabel("Enter phone	");
		lblGender = new JLabel("Gender ");
		lblHeight = new JLabel("Enter height in mtr	");
		lblWeight = new JLabel("Enter weight in kg	");
		
		txtName = new JTextField(10);
		txtAge = new JTextField(10);
		txtPhone = new JTextField(10);
		txtHeight = new JTextField(10);
		txtWeight = new JTextField(10);

		rdbtnM = new JRadioButton("Male");
		rdbtnF = new JRadioButton("Female");
		
		bg = new ButtonGroup();
		bg.add(rdbtnM);
		bg.add(rdbtnF);
		
		Font f = new Font("Calibri", Font.BOLD, 30);
		
		btnCalculate.setFont(f);
		btnConvert.setFont(f);
		btnBack.setFont(f);
		
		lblName.setFont(f);
		lblAge.setFont(f);
		lblPhone.setFont(f);
		lblGender.setFont(f);
		lblHeight.setFont(f);
		lblWeight.setFont(f);
		
		txtName.setFont(f);
		txtAge.setFont(f);
		txtPhone.setFont(f);
		txtHeight.setFont(f);
		txtWeight.setFont(f);

		rdbtnM.setFont(f);
		rdbtnF.setFont(f);
		
		gbc.insets = new Insets(10, 10, 10, 10);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(lblName, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(lblAge, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(lblPhone, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(lblGender, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(lblHeight, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(lblWeight, gbc);		
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(btnBack, gbc);
		
//		panel2.add(btnBack);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel2.add(txtName, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel2.add(txtAge, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel2.add(txtPhone, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel2.add(rdbtnM, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel2.add(rdbtnF, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel2.add(txtHeight, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		panel2.add(txtWeight, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel2.add(btnCalculate, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		panel2.add(btnConvert, gbc);
		
		ActionListener back = ae -> {
			Bm b = new Bm();
			dispose();
		};
		btnBack.addActionListener(back);
		
		ActionListener calculate = ae -> {
			try {
				if(txtName.getText().equals("")) {
					throw new IncompleteNameException("Name field empty");
				}
				String name = txtName.getText();
				if(name.matches("^[a-zA-Z]*$")==false) {
					throw new NumberInNameException("Name contains number"); 
				} else if (name.matches("^[a-zA-Z]{1}$")) {
					throw new MinimumInNameException("Name contains less than 2 chars"); 
				}
				
				if(txtAge.getText().equals("")) {
					throw new IncompleteAgeException("Gender field empty");
				}
				String strAge = txtAge.getText();
				if(strAge.matches("^[0-9]*$")==false) {
					throw new CharInAgeException("age contains character");
				}
				int age = Integer.parseInt(txtAge.getText());
				if(age<0 || age>150) {
					throw new OutOfRangeAgeException("Age out of range");
				}
				
				if(txtPhone.getText().equals("")) {
					throw new IncompletePhoneException("Phone field empty");
				}
				String strPhone = txtPhone.getText();
				if(strPhone.matches("^[0-9]*$")==false) {
					throw new CharInPhoneException("character in phone");
				}
				long phone = Long.parseLong(txtPhone.getText());
				if((txtPhone.getText().matches("\\d{10}")) == false)
					throw new InvalidPhoneException("invalid phone no.");
	
				if(!(rdbtnM.isSelected() || rdbtnF.isSelected())) {
					throw new IncompleteGenderException("Gender field empty");
				}			
				String gender;
				if(rdbtnM.isSelected())
					gender = "M";
				else
					gender = "F";
				
				if(txtHeight.getText().equals("")) {
					throw new IncompleteHeightException("Height field empty");
				}
				String strHeight = txtHeight.getText();
				if(strHeight.matches("^[0-9]*[.]*[0-9]*$")==false) {
					throw new CharInHeightException("char in height");
				}
				Float height = Float.parseFloat(txtHeight.getText());
				if(height<0 || height>2.4384) {
					throw new OutOfRangeHeightException("height out of range");
				}
				
				if(txtWeight.getText().equals("")) {
					throw new IncompleteWeightException("Weight field empty");
				}
				String strWeight = txtWeight.getText();
				if(strWeight.matches("^[0-9]*[.]*[0-9]*$")==false) {
					throw new CharInWeightException("char in weight");
				}
				Float weight = Float.parseFloat(txtWeight.getText());		
				if(weight<0) {
					throw new OutOfRangeWeightException("weight out of range");
				}
				
				
				DBHandler.calculateBMI(name, age, phone, gender, height, weight);
			
			}
			catch(IncompleteNameException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Name field empty", "Warning", JOptionPane.WARNING_MESSAGE);
				txtName.requestFocus();
			}
			catch(NumberInNameException e) {
				JOptionPane.showMessageDialog(c, "Name should contain characters only", "Error", JOptionPane.ERROR_MESSAGE);
				txtName.setText("");
				txtName.requestFocus();
			}
			catch(MinimumInNameException e) {
				JOptionPane.showMessageDialog(c, "Name should contain atleast 2 characters", "Error", JOptionPane.ERROR_MESSAGE);
				txtName.requestFocus();
			}
			catch(IncompleteAgeException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Age field empty", "Warning", JOptionPane.WARNING_MESSAGE);
				txtAge.requestFocus();
			}
			catch(CharInAgeException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Only +ve Integers allowed", "Warning", JOptionPane.WARNING_MESSAGE);
				txtAge.setText("");
				txtAge.requestFocus();
			}
			catch(OutOfRangeAgeException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Age range 0 - 150 allowed", "Warning", JOptionPane.WARNING_MESSAGE);
				txtAge.setText("");
				txtAge.requestFocus();
			}
			catch(IncompletePhoneException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Phone field empty", "Warning", JOptionPane.WARNING_MESSAGE);
				txtPhone.requestFocus();
			}
			catch(CharInPhoneException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Only +ve Integers allowed", "Warning", JOptionPane.WARNING_MESSAGE);
				txtPhone.setText("");
				txtPhone.requestFocus();
			}
			catch(InvalidPhoneException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Invalid Phone no. [should be 10 digits]", "Error", JOptionPane.ERROR_MESSAGE);
				txtPhone.requestFocus();
			}
			catch(IncompleteGenderException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Gender not specified", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			catch(IncompleteHeightException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Height field empty", "Warning", JOptionPane.WARNING_MESSAGE);
				txtHeight.requestFocus();
			}
			catch(CharInHeightException e) {
				JOptionPane.showMessageDialog(new JDialog(), "only +ve float no.s allowed", "Error", JOptionPane.ERROR_MESSAGE);
				txtHeight.setText("");
				txtHeight.requestFocus();
			}
			catch(OutOfRangeHeightException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Height out of range [0 - 2.4384]", "Error", JOptionPane.ERROR_MESSAGE);
				txtHeight.setText("");
				txtHeight.requestFocus();
			}
			catch(IncompleteWeightException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Weight field empty", "Warning", JOptionPane.WARNING_MESSAGE);
				txtWeight.requestFocus();
			}
			catch(CharInWeightException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Only +ve float no.s allowed", "Error", JOptionPane.ERROR_MESSAGE);
				txtWeight.setText("");
				txtWeight.requestFocus();
			}
			catch(OutOfRangeWeightException e) {
				JOptionPane.showMessageDialog(new JDialog(), "Weight out of range", "Error", JOptionPane.ERROR_MESSAGE);
				txtWeight.requestFocus();
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(new JDialog(), "issue: " +e, "Error", JOptionPane.ERROR_MESSAGE);
			}
		};
		btnCalculate.addActionListener(calculate);
		
		ActionListener convert = ae -> {
			Bcon co = new Bcon();
//			String res = Float.toString(co.resy);
//			txtHeight.setText(res);
//			dispose();
		};
		
		
		btnConvert.addActionListener(convert);
		
		setVisible(true);
	}
}


class IncompleteNameException extends Exception {
	String msg;
	IncompleteNameException(String msg) {
		this.msg = msg;
	}
}
class NumberInNameException extends Exception {
	String msg;
	NumberInNameException(String msg) {
		this.msg = msg;
	}
}
class MinimumInNameException extends Exception {
	String msg;
	MinimumInNameException(String msg) {
		this.msg = msg;
	}
}

class IncompleteAgeException extends Exception {
	String msg;
	IncompleteAgeException(String msg) {
		this.msg = msg;
	}
}
class CharInAgeException extends Exception {
	String msg;
	CharInAgeException(String msg) {
		this.msg = msg;
	}
}
class OutOfRangeAgeException extends Exception {
	String msg;
	OutOfRangeAgeException(String msg) {
		this.msg = msg;
	}
}

class CharInPhoneException extends Exception {
	String msg;
	CharInPhoneException(String msg) {
		this.msg = msg;
	}
}
class IncompletePhoneException extends Exception {
	String msg;
	IncompletePhoneException(String msg) {
		this.msg = msg;
	}
}
class InvalidPhoneException extends Exception {
	String msg;
	InvalidPhoneException(String msg) { 
		this.msg = msg;
	}
}

class IncompleteGenderException extends Exception {
	String msg;
	IncompleteGenderException(String msg) {
		this.msg = msg;
	}
}

class IncompleteHeightException extends Exception {
	String msg;
	IncompleteHeightException(String msg) {
		this.msg = msg;
	}
}
class CharInHeightException extends Exception {
	String msg;
	CharInHeightException(String msg) {
		this.msg = msg;
	}
}
class OutOfRangeHeightException extends Exception {
	String msg;
	OutOfRangeHeightException(String msg) {
		this.msg = msg;
	}
}

class IncompleteWeightException extends Exception {
	String msg;
	IncompleteWeightException(String msg) {
		this.msg = msg;
	}
}
class CharInWeightException extends Exception {
	String msg;
	CharInWeightException(String msg) {
		this.msg = msg;
	}
}
class OutOfRangeWeightException extends Exception {
	String msg;
	OutOfRangeWeightException(String msg) {
		this.msg = msg;
	}
}