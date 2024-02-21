package Views;

import Controller.ProductController;
import Model.DAO.ProductsDAO;
import Model.DAO.ProductsDAOImplementation;
import Model.DTO.ProductsModel;

public class Products extends Admin{
	ProductsModel pmodel=new ProductsModel();
	ProductsDAO pdao=new ProductsDAOImplementation();
	ProductController pcontrol=new ProductController(pdao);
    public void productsPage() throws Exception{
        System.out.println("\nWELCOME TO PRODUCTS MANAGEMENT PAGE\n");
		int ch;
		do
		{
			System.out.println("*****************************************************\n");
			System.out.println("1 - ADD PRODUCTS");
			System.out.println("2 - REMOVE PRODUCTS");
			System.out.println("3 - ALTER PRODUCT INFO");
			System.out.println("4 - VIEW ALL PRODUCTS");
			System.out.println("5 - SEARCH A PARTICULAR PRODUCT");
            System.out.println("6 - CHECK OUT OF STOCK PRODUCTS");
			System.out.println("7 - EXIT PAGE");
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : \n");
			ch=obj.nextInt();
			if(ch==1)
				addProducts();
			else if(ch==2)
				removeProducts();
			else if(ch==3)
				alterProducts();
			else if(ch==4)
				viewProducts();
			else if(ch==5)
				searchProducts();
			else if(ch==6)
				System.out.println("Thank you");
			else
				System.out.println("Wrong choice ");
		}while(ch!=6);
    }
	public void addProducts() throws Exception{
		char ch=' ';
		int p_id,s_id;
        String p_name,category;
        int quantity,price,credits;
        do{
            System.out.println("Enter the Details to Add Product\n");
            System.out.println("*****************************************************");
			System.out.println("Enter the supplier id");
			s_id=obj.nextInt();
            obj.nextLine();
            System.out.println("Enter the product Name");
            p_name=obj.nextLine(); 
            System.out.println("Enter the product Price");
            price=obj.nextInt();
			System.out.println("Enter the product quantity");
            quantity=obj.nextInt();
			obj.nextLine();
			System.out.println("Enter the product Category");
			category=obj.nextLine();
            System.out.println("Enter the product Credits");
            credits=obj.nextInt();
			p_id=pcontrol.getProductId();
			pmodel.setProductId(p_id);
			pmodel.setSupplierId(s_id);
			pmodel.setProductName(p_name);
			pmodel.setPrice(price);
			pmodel.setQuantity(quantity);
			pmodel.setCategory(category);
			pmodel.setProductCredits(credits);
			int rs=pcontrol.addProduct(pmodel);
			if(rs==1){
				System.out.println("Product added Successfully");
			}
			else{
				System.out.println("Product not added Successfully");
			}
            
        }while(ch=='y' || ch=='Y');
	}
	public void removeProducts(){

	}
	public void alterProducts(){

	}
	public void viewProducts(){

	}
	public void searchProducts(){

	}
}
