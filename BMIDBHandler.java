import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.io.*;

public class BMIDBHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class DBHandler {
	public static void calculateBMI(String name, int age, Long phone, String gender, float height, float weight) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:", "root", "BH1902");
			
			Statement st = con.createStatement();
			
			st.executeQuery("use BMI");
			float bmi = weight/(height*height);
			String sql = "insert into bmi_data values(default, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setLong(3, phone);
			stmt.setString(4, gender);
			stmt.setFloat(5, height);
			stmt.setFloat(6, weight);
			stmt.setFloat(7, bmi);
			
			stmt.executeUpdate();
			
			String str="";
			if(bmi<15)
				str = "Very severely underweight";
			else if(bmi<=16)
				str = "Severely underweight";
			else if(bmi<18.5)
				str = "Under weight";
			else if(bmi<=25)
				str = "Normal (healthy weight)";
			else if(bmi<=30)
				str = "Overweight";
			else if(bmi<=35)
				str = "Moderately Obese";
			else if(bmi<=40)
				str = "Severly Obese";
			else
				str = "Very Severly Obese";
			
			JOptionPane.showMessageDialog(new JDialog(), "Your bmi is " +bmi +"\nAnd you are " +str);
			
			con.close();
		}
		catch(Exception e) {
			System.out.println("Issue: " +e);
		}
	}
	
	public static String viewBMI() {		
		String data = "*****************\n";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:", "root", "BH1902");
			
			Statement st = con.createStatement();
			
			st.executeQuery("use BMI");
			String sql = "select * from bmi_data";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				data = data +"Name = " +rs.getString(2) + "\nAge = " +rs.getInt(3) + "\nPhone = " +rs.getLong(4) + "\nGender = " +rs.getString(5) + "\nBMI = " +rs.getFloat(8) +"\n*****************\n";
			}
			
			con.close();
		}
		catch(Exception e) {
			System.out.println("Issue: " +e);
		}
		
		return data;
	}
	
	public static void exportData() {
		String data="";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:", "root", "BH1902");
			
			Statement st = con.createStatement();
			
			st.executeQuery("use BMI");
			String sql = "select * from bmi_data";
			
			ResultSet rs = st.executeQuery(sql);
			
			
			File f = new File("export_data", "export-data.csv");
			
			if(!f.exists()) {
				f.createNewFile();
			}
			
//			FileWriter fw = new FileWriter(f,true);
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			data = "id,name,age,phone,gender,height,weight,bmi";
			pw.println(data);
			while(rs.next()) {
				data = rs.getInt(1) +"," +rs.getString(2) +"," +rs.getInt(3) + "," +rs.getLong(4) + "," +rs.getString(5) + "," +rs.getFloat(6) +"," +rs.getFloat(7) +"," +rs.getFloat(8);
				pw.println(data);			
			}
			pw.close();
			JOptionPane.showMessageDialog(new JDialog(), "Data Exported Successfully");
			
			con.close();
		}
		catch(Exception e) {
			System.out.println("Issue: " +e);
		}
	}
	
	public static String countRowsFromTable() {
		String count="";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql:", "root", "BH1902");
			
			Statement st = con.createStatement();
			
			st.executeQuery("use BMI");
			String sql = "select count(*) from bmi_data";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				count = count + rs.getInt(1);
			}
			
//			JOptionPane.showMessageDialog(new JDialog(), count);
			
			con.close();
		}
		catch(Exception e) {
			System.out.println("Issue: " +e);
		}
		
		return count;
	}
}