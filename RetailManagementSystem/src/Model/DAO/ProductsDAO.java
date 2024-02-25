package model.dao;

import java.sql.ResultSet;
import java.util.List;

import model.dto.ProductsModel;

public interface ProductsDAO {
    int addProduct(ProductsModel pmodel) throws Exception;
    int getProductId() throws Exception;
    int removeProducts(ProductsModel pmodel) throws Exception;
    int updateProductName(ProductsModel pmodel,String newName) throws Exception;
    int updateProductQuantity(ProductsModel pmodel,int newQuantity) throws Exception;
    int updateProductPrice(ProductsModel pmodel,int newPrice) throws Exception;
    int updateProductCredits(ProductsModel pmodel,int newcredits) throws Exception;
    ResultSet searchProducts(ProductsModel pmodel) throws Exception;
    public List<ProductsModel> getAllProducts() throws Exception;
}
