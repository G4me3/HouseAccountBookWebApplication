package com.example.demo;

public class Calculation {

	//年間出費の計算
	static int CalcYearExpenditure(int year) {
		int totalOfEx=0;
		for(int sum:Account.AllExpenditures)
			totalOfEx+=sum;
		return totalOfEx;
	}

	//年間収入の計算
	static int  CalcYearIncome(int year) {
		int totalOfIncome=0;
		for(int sum:Account.AllIncomes)
			totalOfIncome+=sum;
			return totalOfIncome;
	}

	//最大出費の計算
	static int CalcMaxExpenditure(int year) {
		int maxExpenditure=Account.AllExpenditures.get(0);
		for(int max:Account.AllExpenditures) {
			if(maxExpenditure<max)
				maxExpenditure=max;
		}
		return maxExpenditure;
	}

	//最大収入の計算
	static int CalcMaxIncome(int year) {
		int maxIncome=Account.AllIncomes.get(0);
		for(int max:Account.AllIncomes) {
			if(maxIncome<max)
				maxIncome=max;
		}
		return maxIncome;
	}

}
