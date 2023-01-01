package com.telusko.web.dao;

import java.sql.*;
import com.telusko.web.model.Alien;

public class AlienDao {

	public Alien getAlien(int aid) {
		Alien a = new Alien();
		a.setAid(101);
		a.setAname("Navin R");
		a.setTech("Java");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/navin", "root",
					"TestYantra@2022");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from alien where aid=" + aid);
			if (rs.next()) {
				a.setAid(rs.getInt("aid"));
				a.setAname(rs.getString("aname"));
				a.setTech(rs.getString("tech"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return a;
	}
}
