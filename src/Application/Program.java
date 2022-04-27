package Application;

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
		Scanner sc = new Scanner (System.in);
		
		
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(resp == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			
			else if(resp == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manuFacture = date.parse(sc.next());
				list.add(new UsedProduct(name, price, manuFacture));
			}
			else {
				list.add(new Product(name, price));
			}
					
		}
		
		System.out.println();
		System.out.println("PRICE TAGS: ");
		
		for(Product pro : list) {
			System.out.println(pro.PriceTag());
		}
		
		sc.close();		

	}

}
