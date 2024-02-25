package Views;


public class Customers extends Admin {
    public void customerPage() throws Exception{
        System.out.println("\nWELCOME TO CUSTOMER MANAGEMENT PAGE\n");
		int ch;
		do
		{
			System.out.println("\n*****************************************************\n");
			System.out.println("1 - ADD CUSTOMERS");
			System.out.println("2 - REMOVE CUSTOMERS");
			System.out.println("3 - ALTER CUSTOMERS INFO");
			System.out.println("4 - VIEW ALL CUSTOMERS");
			System.out.println("5 - EXIT PAGE");
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : \n");
			ch=obj.nextInt();
			if(ch==1)
				addCustomers();
			else if(ch==2)
				removeCustomers();
			else if(ch==3)
				alterCustomersInfo();
			else if(ch==4)
				viewCustomers();
		}while(ch<=4);
    }
    public void addCustomers() throws Exception{

    }
    public void removeCustomers() throws Exception{

    }
    public void alterCustomersInfo() throws Exception{

    }
    public void viewCustomers() throws Exception{
        
    }
}

