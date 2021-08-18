package com.example.demo;

public class Week {
	public String day1;
	public String day2;
	public String day3;
	public String day4;
	public String day5;
	public String day6;
	public String day7;
	public String expenditure1;
	public String expenditure2;
	public String expenditure3;
	public String expenditure4;
	public String expenditure5;
	public String expenditure6;
	public String expenditure7;
	public String income1;
	public String income2;
	public String income3;
	public String income4;
	public String income5;
	public String income6;
	public String income7;



	//29
	public Week(String day1,
			String expenditure1,String income1) {
		this.day1=day1;
		this.expenditure1=expenditure1;
		this.income1=income1;
	}

	//30
	public Week(String day1,String day2,
			String expenditure1,String expenditure2,
			String income1,String income2) {
		this.day1=day1;
		this.day2=day2;
		this.expenditure1=expenditure1;
		this.expenditure2=expenditure2;
		this.income1=income1;
		this.income2=income2;
	}

	//31
	public Week(String day1,String day2,String day3,
			String expenditure1,String expenditure2,String expenditure3,
			String income1,String income2,String income3) {
		this.day1=day1;
		this.day2=day2;
		this.day3=day3;
		this.expenditure1=expenditure1;
		this.expenditure2=expenditure2;
		this.expenditure3=expenditure3;
		this.income1=income1;
		this.income2=income2;
		this.income3=income3;
	}

	//default
	public Week(String day1,String day2,String day3,String day4,String day5, String day6,String day7,
			String expenditure1,String expenditure2,String expenditure3,String expenditure4,String expenditure5,String expenditure6,String expenditure7,
			String income1,String income2,String income3,String income4,String income5,String income6,String income7) {
		this.day1=day1;
		this.day2=day2;
		this.day3=day3;
		this.day4=day4;
		this.day5=day5;
		this.day6=day6;
		this.day7=day7;
		this.expenditure1=expenditure1;
		this.expenditure2=expenditure2;
		this.expenditure3=expenditure3;
		this.expenditure4=expenditure4;
		this.expenditure5=expenditure5;
		this.expenditure6=expenditure6;
		this.expenditure7=expenditure7;
		this.income1=income1;
		this.income2=income2;
		this.income3=income3;
		this.income4=income4;
		this.income5=income5;
		this.income6=income6;
		this.income7=income7;
	}
}
