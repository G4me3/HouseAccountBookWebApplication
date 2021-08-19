package com.example.demo;
import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ControllerOfApplication {

	public static void main(String[] args) {
		SpringApplication.run(Practice1Application.class, args);
	}

	Calendar c=Calendar.getInstance();
	int year=c.get(Calendar.YEAR);
	int month=c.get(Calendar.MONTH)+1;
	int date=c.get(Calendar.DATE);

	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		Account.show(year,month);
		Account.aggregate(year);
		mav.addObject("calendar", Account.week);
		mav.addObject("now",year+"/"+month+"/"+date);
		mav.addObject("month", month+"月の家計簿");
		mav.addObject("yearExpenditure",Calculation.CalcYearExpenditure(year));
		mav.addObject("yearIncome",Calculation.CalcYearIncome(year));
		mav.addObject("maxExpenditure",Calculation.CalcMaxExpenditure(year));
		mav.addObject("maxIncome",Calculation.CalcMaxIncome(year));
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping(value="/",method=RequestMethod.GET,params= {"day"})
	public ModelAndView index(@RequestParam("day") String day, ModelAndView mav) {
		if(day.equals("0")) {
			Account.show(year,--month);
			mav.addObject("calendar", Account.week);
			mav.addObject("now",year+"/"+month+"/"+date);
			mav.addObject("month", month+"月の家計簿");
			mav.addObject("yearExpenditure",Calculation.CalcYearExpenditure(year));
			mav.addObject("yearIncome",Calculation.CalcYearIncome(year));
			mav.addObject("maxExpenditure",Calculation.CalcMaxExpenditure(year));
			mav.addObject("maxIncome",Calculation.CalcMaxIncome(year));
			mav.setViewName("index");
			return mav;
		}else {
			Account.show(year,++month);
			mav.addObject("calendar", Account.week);
			mav.addObject("now",year+"/"+month+"/"+date);
			mav.addObject("month", month+"月の家計簿");
			mav.addObject("yearExpenditure",Calculation.CalcYearExpenditure(year));
			mav.addObject("yearIncome",Calculation.CalcYearIncome(year));
			mav.addObject("maxExpenditure",Calculation.CalcMaxExpenditure(year));
			mav.addObject("maxIncome",Calculation.CalcMaxIncome(year));
			mav.setViewName("index");
			return mav;
		}
	}

	@RequestMapping("/inputEx")
	public ModelAndView input(ModelAndView mav) {
		mav.setViewName("inputEx");
		return mav;
	}

	@RequestMapping(value="/inputEx",method=RequestMethod.POST)
	public ModelAndView inputEx(@RequestParam("expenditure")String expenditure,@RequestParam("day") String day,ModelAndView mav) {
		int expenditures=Integer.parseInt(expenditure);
		int date=Integer.parseInt(day);
		Account.setter(year, month, date,0,expenditures);
		Account.show(year,month);
		mav.addObject("calendar", Account.week);
		mav.addObject("now",year+"/"+month+"/"+date);
		mav.addObject("month", month+"月の家計簿");
		mav.addObject("yearExpenditure",Calculation.CalcYearExpenditure(year));
		mav.addObject("yearIncome",Calculation.CalcYearIncome(year));
		mav.addObject("maxExpenditure",Calculation.CalcMaxExpenditure(year));
		mav.addObject("maxIncome",Calculation.CalcMaxIncome(year));
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/inputIn")
	public ModelAndView inputIn(ModelAndView mav) {
		mav.setViewName("inputIn");
		return mav;
	}

	@RequestMapping(value="/inputIn",method=RequestMethod.POST)
	public ModelAndView inputIn(@RequestParam("income")String income,@RequestParam("day") String day,ModelAndView mav) {
		int incomes=Integer.parseInt(income);
		int date=Integer.parseInt(day);
		Account.setter(year, month, date,1,incomes);
		Account.show(year,month);
		mav.addObject("calendar", Account.week);
		mav.addObject("now",year+"/"+month+"/"+date);
		mav.addObject("month", month+"月の家計簿");
		mav.addObject("yearExpenditure",Calculation.CalcYearExpenditure(year));
		mav.addObject("yearIncome",Calculation.CalcYearIncome(year));
		mav.addObject("maxExpenditure",Calculation.CalcMaxExpenditure(year));
		mav.addObject("maxIncome",Calculation.CalcMaxIncome(year));
		mav.setViewName("index");
		return mav;
	}



}
