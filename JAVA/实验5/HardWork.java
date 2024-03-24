abstract class Employee {
	abstract double earnings();
}

class YearWorker extends Employee {
	int year;
	double yearSalary;

	YearWorker(int y, double s) {
		this.year = y;
		this.yearSalary = s;
	}

	double earnings() {
		return year * yearSalary;
	}

}

class MonthWorker extends Employee {
	int month;
	double monthSalary;

	MonthWorker(int m, double s) {
		this.month = m;
		this.monthSalary = s;
	}

	double earnings() {
		return month * monthSalary;
	}

}

class WeekWorker extends Employee {
	int week;
	double weekSalary;

	WeekWorker(int w, double s) {
		this.week = w;
		this.weekSalary = s;
	}

	double earnings() {
		return week * weekSalary;
	}

}

public class HardWork {
	public static void main(String[] args) {
		Employee[] e = new Employee[3];
		e[0] = new YearWorker(1, 100000);
		e[1] = new MonthWorker(12, 6000);
		e[2] = new WeekWorker(48, 1400);
		double sum;
		sum = e[0].earnings() + e[1].earnings() + e[2].earnings();
		System.out.println("总工资为：" + sum);
	}
}