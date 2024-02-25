package Views;

import java.sql.ResultSet;
import java.util.List;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
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
			System.out.println("\n*****************************************************\n");
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
			    searchProducts();
				//write code
		}while(ch<=6);
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
			p_id=getPId();
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
				System.out.println("Product not added");
			}
            
        }while(ch=='y' || ch=='Y');
	}
	public void removeProducts() throws Exception{
		char ch=' ';
		int s_id;
        String p_name,category;
        do{
            System.out.println("Enter the Details to Remove Product\n");
            System.out.println("*****************************************************");
			System.out.println("Enter the supplier_id");
			s_id=obj.nextInt();
            obj.nextLine();
            System.out.println("Enter the product Name");
            p_name=obj.nextLine();
            System.out.println("Enter the product Category");
            category=obj.nextLine(); 
			pmodel.setSupplierId(s_id);
            pmodel.setProductName(p_name);
            pmodel.setCategory(category);
            int rs=pcontrol.removeProducts(pmodel);
			if(rs==1){
				System.out.println("Product deleted Successfully");
			}
			else{
				System.out.println("Product not deleted");
			}
        }while(ch=='y' || ch=='Y');
	}
	public void alterProducts() throws Exception{
		char ch=' ';
        String p_name,category;
        int s_id;
        String p_newName;
        int newquantity,newprice,newcredits;
        do{
            System.out.println("Enter the Details to Alter Product\n");
            System.out.println("*****************************************************");
			System.out.println("1 - UPDATE PRODUCT NAME");
			System.out.println("2 - UPDATE PRODUCT QUANTITY");
			System.out.println("3 - UPDATE PRODUCT PRICE");
            System.out.println("4 - UPDATE PRODUCT CREDITS");
			System.out.println("*****************************************************\n");
			System.out.print("Enter choice : ");
			int t=obj.nextInt();
            if(t==1){
				System.out.println("Enter the Supplier id");
				s_id=obj.nextInt();
                obj.nextLine();
                System.out.println("Enter the product Name");
                p_name=obj.nextLine();
				System.out.println("Enter the product Category");
                category=obj.nextLine(); 
                System.out.println("Enter the new product Name");
                p_newName=obj.nextLine(); 
                pmodel.setSupplierId(s_id);
                pmodel.setProductName(p_name);
                pmodel.setCategory(category);
                int rs=pcontrol.updateProductName(pmodel,p_newName);
				if(rs==1){
					System.out.println("Product name updated Successfully");
				}
				else{
					System.out.println("Product not updated");
				}
            }
            else if(t==2){
                System.out.println("Enter the Supplier id");
				s_id=obj.nextInt();
                obj.nextLine();
                System.out.println("Enter the product Name");
                p_name=obj.nextLine();
				System.out.println("Enter the product Category");
                category=obj.nextLine(); 
                System.out.println("Enter the new product quantity");
                newquantity=obj.nextInt(); 
                pmodel.setSupplierId(s_id);
                pmodel.setProductName(p_name);
                pmodel.setCategory(category);
                int rs=pcontrol.updateProductQuantity(pmodel,newquantity);
				if(rs==1){
					System.out.println("Product quantity updated Successfully");
				}
				else{
					System.out.println("Product not updated");
				}
            }
            else if(t==3){
                System.out.println("Enter the Supplier id");
				s_id=obj.nextInt();
                obj.nextLine();
                System.out.println("Enter the product Name");
                p_name=obj.nextLine();
				System.out.println("Enter the product Category");
                category=obj.nextLine(); 
                System.out.println("Enter the new product price");
                newprice=obj.nextInt(); 
                pmodel.setSupplierId(s_id);
                pmodel.setProductName(p_name);
                pmodel.setCategory(category);
                int rs=pcontrol.updateProductPrice(pmodel,newprice);
				if(rs==1){
					System.out.println("Product price updated Successfully");
				}
				else{
					System.out.println("Product not updated");
				}
            }
            else if(t==4){
                System.out.println("Enter the Supplier id");
				s_id=obj.nextInt();
                obj.nextLine();
                System.out.println("Enter the product Name");
                p_name=obj.nextLine();
				System.out.println("Enter the product Category");
                category=obj.nextLine(); 
                System.out.println("Enter the new product credits");
                newcredits=obj.nextInt(); 
                pmodel.setSupplierId(s_id);
                pmodel.setProductName(p_name);
                pmodel.setCategory(category);
                int rs=pcontrol.updateProductCredits(pmodel,newcredits);
				if(rs==1){
					System.out.println("Product credits updated Successfully");
				}
				else{
					System.out.println("Product not updated");
				}
            }    
        }while(ch=='y' || ch=='Y');
	}
	public void viewProducts() throws Exception{
		List<ProductsModel> productList = pcontrol.getAllProducts();
		for (ProductsModel product : productList) {
            System.out.println("Product ID: " + product.getProductId());
			System.out.println("Supplier ID: " + product.getSupplierId());
            System.out.println("Product Name: " + product.getProductName());
			System.out.println("Product Price: " + product.getPrice());
            System.out.println("Product Quantity: " + product.getQuantity());
			System.out.println("Product Category: " + product.getCategory());
			System.out.println("Product Credits: " + product.getProductCredits());
            System.out.println("------------------------");
        }
	}
	public void searchProducts() throws Exception{
		char ch=' ';
		String category;
        int s_id;
        do{
            System.out.println("Enter the Details to search Product\n");
            System.out.println("*****************************************************");
			System.out.println("Enter the Supplier id");
			s_id=obj.nextInt();
			obj.nextLine();
			System.out.println("Enter the product Category");
			category=obj.nextLine(); 
			pmodel.setSupplierId(s_id);
            pmodel.setCategory(category);
			ResultSet rs=pcontrol.searchProducts(pmodel);
			ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
            int columnsCount = metaData.getColumnCount();
            while (rs.next()) {
				System.out.println("------------------------");
                for (int i = 1; i <= columnsCount; i++) {
					System.out.println(metaData.getColumnName(i) + "\t"+rs.getString(i));
                }
            }
        }while(ch=='y' || ch=='Y');
	}
	public int getPId() throws Exception{
        int id=pcontrol.getProductId();
        if(id==0){
            return 1;
        }
        else{
            return id+1;
        }
    }
}
