package CSInterview;
import java.util.Vector;
import java.math.BigDecimal;
import java.util.Scanner;

public class calculatePrice {

	private Scanner keyboard;


	public static void main(String[] args) {
		
		calculatePrice itemPrice = new calculatePrice();
					
		Vector<productItem> shoppingItems = itemPrice.insertItem();
		
		itemPrice.receiptDetails (shoppingItems);
		

	}
	
	
	private Vector<productItem> insertItem()
	{
		keyboard = new Scanner(System.in);
		String inputItem = null;
		productItem purchaseItem;

		Vector<productItem> shoppingItems = new Vector<productItem>();

		int numItems = 1;
		
				
		while(true)
		{
			purchaseItem = new productItem();

			System.out.print("Item "+numItems+" Quantity: ");
			inputItem = keyboard.nextLine();
			purchaseItem.setNum(Integer.parseInt(inputItem));

			System.out.print("Item "+numItems+" Name: ");
			inputItem = keyboard.nextLine();
			purchaseItem.setItem(inputItem);

			System.out.print("Item "+numItems+" Price: ");
			inputItem = keyboard.nextLine();
			purchaseItem.setPrice(Float.parseFloat(inputItem));


			System.out.print("Item "+numItems+" Imported[y/n]?: ");
			inputItem = keyboard.nextLine();
			if(inputItem.toLowerCase().equals("y"))
			{
				purchaseItem.setImported( true ) ;
			}

			System.out.print("Item "+numItems+" Exempted[y/n]?: ");
			inputItem = keyboard.nextLine();
			if( inputItem.toLowerCase().equals("y") )
			{
				purchaseItem.setExempted(true);
			}
		
			
			shoppingItems.add(purchaseItem);
			numItems++;

			System.out.print("Do you have more Items [y/n]?: ");
			inputItem = keyboard.nextLine();
			if(inputItem.toLowerCase().equals("n"))
			{
				break;
			}

		}
		return shoppingItems;
	}
	
	
	public void receiptDetails (Vector<productItem> shoppingItems)
	{
		float totTax = 0;
		float grossPrice = 0;
		for(int i=0; i<shoppingItems.size(); i++)
		{
			productItem purchaseItem = shoppingItems.get(i);
			purchaseItem = shoppingItems.get(i);
			totTax += purchaseItem.getTax();
			purchaseItem.setPriceTax();
			System.out.println(purchaseItem.getNum()+" "+purchaseItem.getItem()+": "+(new BigDecimal(purchaseItem.getPriceTax()).setScale(2,BigDecimal.ROUND_HALF_UP)));
			grossPrice = grossPrice+purchaseItem.getPriceTax();
		}
		System.out.println("Sales Taxes: "+(new BigDecimal(totTax).setScale(2,BigDecimal.ROUND_HALF_UP)));
		System.out.println("Total: "+(new BigDecimal(grossPrice).setScale(2,BigDecimal.ROUND_HALF_UP)));

	}

}
