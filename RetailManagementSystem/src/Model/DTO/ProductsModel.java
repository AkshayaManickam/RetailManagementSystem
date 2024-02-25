package model.dto;

public class ProductsModel {
    private int product_id;
    private int supplier_id;
    private String product_name;
    private int price;
    private int quantity;
    private String category;
    private int product_credits;
    public ProductsModel(){
        this.product_id=0;
        this.supplier_id=0;
        this.product_name=null;
        this.price=0;
        this.quantity=0;
        this.category=null;
        this.product_credits=0;
    }
    ProductsModel(int product_id,int supplier_id,String product_name,int price,int quantity,String category,int product_credits){
        this.product_id=product_id;
        this.supplier_id=supplier_id;
        this.product_name=product_name;
        this.price=price;
        this.quantity=quantity;
        this.category=category;
        this.product_credits=product_credits;
    }
    public void setProductId(int product_id){
        this.product_id=product_id;
    }
    public void setSupplierId(int supplier_id){
        this.supplier_id=supplier_id;
    }
    public void setProductName(String product_name){
        this.product_name=product_name;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public void setProductCredits(int product_credits){
        this.product_credits=product_credits;
    }
    public int getProductId(){
        return this.product_id;
    }
    public int getSupplierId(){
        return this.supplier_id;
    }
    public String getProductName(){
        return this.product_name;
    }
    public int getPrice(){
        return this.price;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public String getCategory(){
        return this.category;
    }
    public int getProductCredits(){
        return this.product_credits;
    }
}
