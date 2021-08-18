package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Account {
	static List<String> day=new ArrayList<>();			//日にちの格納用
	static List<Week> week=new ArrayList<>();
	static List<Integer> AllExpenditures=new ArrayList<>();//出費の格納用
	static List<String> expenditure=new ArrayList<>();
	static List<Integer> AllIncomes=new ArrayList<>();		//収入の格納用
	static List<String> income=new ArrayList<>();

	static void show(int year,int month) {
		//ローカルDBの接続
		try {
			Class.forName("org.h2.Driver");
			String url="jdbc:h2:tcp://localhost/~/test";
			Connection con=DriverManager.getConnection(url,"sa","");
			String sql="SELECT * FROM BOOK"+year+"_"+month;
			Statement st=con.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery(sql);


			if(day.size()>=JDBC.mdays[JDBC.isLeap(year)][month]) {
				day.clear();
				week.clear();
				expenditure.clear();
				income.clear();
			}
			//データの格納
			while(rs.next()) {
				day.add(rs.getString(1));
				expenditure.add(String.valueOf(rs.getInt(2)));
				income.add(String.valueOf(rs.getInt(3)));
			}

			int count=0;
			int count1=0;
			int count2=0;

			week.add(new Week(day.get(count),day.get(++count),day.get(++count),day.get(++count),day.get(++count),day.get(++count),day.get(++count),
					expenditure.get(count1),expenditure.get(++count1),expenditure.get(++count1),expenditure.get(++count1),expenditure.get(++count1),expenditure.get(++count1),expenditure.get(++count1),
					income.get(count2),income.get(++count2),income.get(++count2),income.get(++count2),income.get(++count2),income.get(++count2),income.get(++count2)));

			for(int i=0;i<3;i++) {
				week.add(new Week(day.get(++count),day.get(++count),day.get(++count),day.get(++count),day.get(++count),day.get(++count),day.get(++count),
						expenditure.get(++count1),expenditure.get(++count1),expenditure.get(++count1),expenditure.get(++count1),expenditure.get(++count1),expenditure.get(++count1),expenditure.get(++count1),
						income.get(++count2),income.get(++count2),income.get(++count2),income.get(++count2),income.get(++count2),income.get(++count2),income.get(++count2)));
			}

			if(day.size()==29)
				week.add(new Week(day.get(++count),	expenditure.get(++count1),income.get(++count2)));
			else if(day.size()==30)
				week.add(new Week(day.get(++count),day.get(++count),expenditure.get(++count1),expenditure.get(++count1),income.get(++count2),income.get(++count2)));
			else
				week.add(new Week(day.get(++count),day.get(++count),day.get(++count),expenditure.get(++count1),expenditure.get(++count1),expenditure.get(++count1),income.get(++count2),income.get(++count2),income.get(++count2)));

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	static void setter(int year,int month, int day,int select,int howMuch) {

		try {
			Class.forName("org.h2.Driver");
			String url="jdbc:h2:tcp://localhost/~/test";
			Connection con=DriverManager.getConnection(url,"sa","");
			String sql3="SELECT * FROM BOOK"+year+"_"+month;
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql3);

			//出費
			if(select==0) {
				for(int i=0;i<day;i++)
					rs.next();

				if(rs.getInt(2)>0)
					howMuch+=rs.getInt(2);

				String sql="UPDATE BOOK"+year+"_"+month+" SET 出費="+howMuch+"WHERE 日="+day;
				st.executeUpdate(sql);
				show(year,month);

			}
			//収入
			if(select==1) {
				for(int i=1;i<day;i++)
					rs.next();

				if(rs.getInt(3)>0)
					howMuch+=rs.getInt(3);

				String sql2="UPDATE BOOK"+year+"_"+month+" SET 収入="+howMuch+"WHERE 日="+day;
				st.executeUpdate(sql2);
				show(year,month);
			}

			con.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	static void aggregate(int year) {
		try {
			Class.forName("org.h2.Driver");
			String url="jdbc:h2:tcp://localhost/~/test";
			Connection con=DriverManager.getConnection(url,"sa","");

			for(int month=1;month<13;month++) {
				String sql="SELECT * FROM BOOK"+year+"_"+month;
				Statement st=con.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=st.executeQuery(sql);

				while(rs.next()) {
					AllExpenditures.add(rs.getInt(2));
					AllIncomes.add(rs.getInt(3));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
