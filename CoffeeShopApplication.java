/*
 * @author llh
 * @date 2022/10/23
 */
import  java.io.*;
import  java.util.*;

public class CoffeeShopApplication{

	private static BufferedReader  stdIn =
		new  BufferedReader(new  InputStreamReader(System.in));
	private static PrintWriter  stdOut =
		new  PrintWriter(System.out, true);
	private static PrintWriter  stdErr =
		new  PrintWriter(System.err, true);

	private CoffeeShop coffeeShop;

	private static final int MIN_NUMBER = 0;
	
	private static final int MAX_NUMBER = 50;

	private static final double MIN_COST = 2.0;
	
	private static final double MAX_COST = 50.0;

	public static void main(String[]  args) throws IOException  {

		CoffeeShopApplication application = new  CoffeeShopApplication();

		application.run();
	}

	private void run() throws IOException  {

		coffeeShop = new  CoffeeShop();

		int  choice = getChoice();

		while (choice != 0)  {

			if (choice == 1)  {

				coffeeShop.addCoffee(readCoffee());
			} else if (choice == 2)  {

				stdOut.println(coffeeShop.toString());
			} else if (choice == 3)  {

				stdOut.println("Total Cost: " + coffeeShop.getTotalCost());
			}

			choice = getChoice();
		}
	}

	private int getChoice() throws IOException  {
		System.out.println("please enter your choice");
			try {
				int choice = Integer.parseInt(stdIn.readLine());
				if (choice < 0 || choice > 3) {

					stdErr.println("请输入0-3之间的任意整数");
				}
				return choice;
			} catch (NumberFormatException e) {
				throw e;
			}
	}

	private Coffee readCoffee() throws IOException {
		System.out.println("please enter the information about coffee");
		String str = stdIn.readLine();
		String []split = str.split("_");
		if(split.length != 4) {

			stdErr.println("输入错误，请按id_name_taste_cost的格式重新输入");
			readCoffee();
		}
		try {
			int id = Integer.parseInt(split[0]); 
			String name = split[1];
			String taste = split[2];
			double price = Double.parseDouble(split[3]);
			if( id < 0 || price <= 0) {

				stdErr.println("输入无效，只能输入正数");
				readCoffee();
			}
			else if( id < MIN_NUMBER || id > MAX_NUMBER) {

				stdErr.println("输入无效，请输入0-50之间的任意整数");
				readCoffee();
			}
			else if( price < MIN_COST || price > MAX_COST) {

				stdErr.println("输入无效，请输入2-50之间的任意整数");
				readCoffee();
			}
			Coffee coffee = new Coffee(id, name, taste, price);
			System.out.println("Success!");
			return coffee;
		}  catch (NumberFormatException e) {
			throw e;
		}
	}
		
}