package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc=  new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter the number of products ");
		int n = sc.nextInt();
		List <Product>list = new ArrayList <>();
		
		for(int c=1; c<=n ; c++) {
			System.out.println(" PRODUCT#" + c + "data: ");
			System.out.println("Common. used or imported (c/u/i) ?");
			char cui = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Price: ");
			Double price =sc.nextDouble();
			
			if(cui == 'i') {
				System.out.println("Customs fee: ");
				Double cu = sc.nextDouble();
				Product product = new ImportedProduct(name, price, cu);
				list.add(product);
				}
			 else if ( cui == 'u') {
				System.out.println(" Manufacture date: ");
				Date md =sdf.parse(sc.next());
				Product product = new UsedProduct(name, price, md);
				list.add(product);
				
			}
	
			 else {
				 Product product = new Product(name, price);
				 list.add(product);
			 }
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
	sc.close();
	}

}
