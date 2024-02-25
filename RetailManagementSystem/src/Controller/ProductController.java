package controller;

import java.sql.ResultSet;
import java.util.List;

import model.dao.ProductsDAO;
import model.dto.ProductsModel;

public class ProductController {
    private ProductsDAO pdao;
    public ProductController(ProductsDAO pdao){
        this.pdao=pdao;
    }
    public int addProduct(ProductsModel pmodel) throws Exception {
        int rs=pdao.addProduct(pmodel);
        return rs;
    }
    public int getProductId() throws Exception{
        int rs1=pdao.getProductId();
        return rs1;
    }
    public int removeProducts(ProductsModel pmodel) throws Exception{
        int rs1=pdao.removeProducts(pmodel);
        return rs1;
    }
    public int updateProductName(ProductsModel pmodel,String newName) throws Exception{
        int rs1=pdao.updateProductName(pmodel,newName);
        return rs1;
    }
    public int updateProductQuantity(ProductsModel pmodel,int newQuantity) throws Exception{
        int rs1=pdao.updateProductQuantity(pmodel,newQuantity);
        return rs1;
    }
    public int updateProductPrice(ProductsModel pmodel,int newPrice) throws Exception{
        int rs1=pdao.updateProductPrice(pmodel,newPrice);
        return rs1;
    }
    public int updateProductCredits(ProductsModel pmodel,int newcredits) throws Exception{
        int rs1=pdao.updateProductCredits(pmodel,newcredits);
        return rs1;
    }
    public ResultSet searchProducts(ProductsModel pmodel) throws Exception{
        ResultSet rs1=pdao.searchProducts(pmodel);
        return rs1;
    }
    public List<ProductsModel> getAllProducts() throws Exception{
        List<ProductsModel> product=pdao.getAllProducts();
        return product;
    }
}
