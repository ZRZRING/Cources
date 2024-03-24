interface ComputeTotalSales {
	public double totalSalesByYear();
}

class Television implements ComputeTotalSales {
	public double totalSalesByYear() {
		return 10000;
	}
}

class Computer implements ComputeTotalSales {
	public double totalSalesByYear() {
		return 20000;
	}
}

class Mobile implements ComputeTotalSales {
	public double totalSalesByYear() {
		return 30000;
	}
}

class Shop {
	double totalSales;
	ComputeTotalSales[] goods;

	Shop(ComputeTotalSales[] goods) {
		this.goods = goods;
	}

	public double giveTotalSales() {
		totalSales = 0;
		for (int i = 0; i < goods.length; i++) {
			totalSales = totalSales + goods[i].totalSalesByYear();
		}
		return totalSales;
	}
}

public class Sale {
	public static void main(String[] args) {
		ComputeTotalSales[] goods = new ComputeTotalSales[40];
		for (int i = 0; i < goods.length; i++) {
			if (i % 3 == 0) {
				goods[i] = new Television();
			} else if (i % 3 == 1) {
				goods[i] = new Computer();
			} else if (i % 3 == 2) {
				goods[i] = new Mobile();
			}
		}
		Shop shop = new Shop(goods);
		System.out.println("所有商品的年销售额为:" + shop.giveTotalSales());
	}
}