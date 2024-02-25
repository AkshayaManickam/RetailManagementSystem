package views;

public class Admin extends Shop {
    public void adminPage() throws Exception{
        int ch;
        do
		{
			System.out.println("\n*****************************************************\n");
			System.out.println("1 - MANAGE PRODUCTS");
			System.out.println("2 - MANAGE CUSTOMERS");
			System.out.println("3 - MANAGE SUPLIERS");
			System.out.println("4 - GENERATE BILL");
			System.out.println("5 - EDIT PROFILE");
			System.out.println("6 - EXIT");
			System.out.println("*****************************************************\n");
            System.out.print("Enter choice : ");
            ch=obj.nextInt();
			if(ch==1)
			{
				Products product=new Products();
				product.productsPage();
			}
			else if(ch==2)
			{
				Customers customer=new Customers();
                customer.customerPage();
			}
			else if(ch==3)
			{
				Supliers supliers=new Supliers();
                supliers.supliersPage();
			}
            else if(ch==4){
                Bills bill=new Bills();
                bill.billPage();
            }
            else if(ch==5){
                //edit profile
            }
		}while(ch<=5);
    }
}
