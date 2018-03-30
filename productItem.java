package CSInterview;

public class productItem {
	private int num = 0;
	private String item = null;
	private float price = 0;
	private boolean imported = false; 
	private boolean exempted = false; 
	private float tax = 0;
	private float priceTax = 0;
	

	public float getPrice()
	{
		return price;
	}
	public String getItem()
	{
		return item;
	}
	public void setItem(String nome)
	{
		this.item = nome;
	}
	public boolean isImported()
	{
		return imported;
	}
	public void setImported(boolean imported)
	{
		this.imported = imported;
	}
	public boolean isExempted()
	{
		return exempted;
	}
	public void setExempted(boolean exempted)
	{
		this.exempted = exempted;
	}
	public void setPrice(float price)
	{
		this.price = price;
	}
	public int getNum()
	{
		return num;
	}
	public void setNum(int num)
	{
		this.num = num;
	}
	
	public float getPriceTax()
	{
		return priceTax;
	}
	
	public void setPriceTax()
	{
		this.priceTax = this.getPrice() + this.getTax();
	}
	
	public float getTax()
	{
		float appliedTax;
		if(this.imported && !this.isExempted())
		{
			appliedTax = 0.15f;
		}
		else if(this.isImported() && this.isExempted())
		{
			appliedTax = 0.05f;
		}
		else if( !this.isImported() && !this.isExempted())
		{
			appliedTax = 0.1f;
		}
		else
		{
			appliedTax = 0;
		}
		tax = appliedTax * price;
		// rounding rules 
        tax = (float)(Math.ceil(tax / 0.05) * 0.05);      
            
		return tax;
	}
	
	
}



