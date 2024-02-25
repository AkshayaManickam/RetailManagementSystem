package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.DBConnectivity;
import Model.DTO.ProductsModel;

public class ProductsDAOImplementation implements ProductsDAO{
    DBConnectivity db=new DBConnectivity();
    public int addProduct(ProductsModel pmodel) throws Exception{
        db.getConnectivity();
        PreparedStatement preparedStatement =null;
        String query="insert into product_details(product_id,supplier_id,product_name,price,quantity,category,product_credits) values (?,?,?,?,?,?,?)" ;
        preparedStatement = DBConnectivity.con.prepareStatement(query);
        preparedStatement.setInt(1, pmodel.getProductId());
        preparedStatement.setInt(2, pmodel.getSupplierId());
        preparedStatement.setString(3,pmodel.getProductName());
        preparedStatement.setInt(4, pmodel.getPrice());
        preparedStatement.setInt(5, pmodel.getQuantity());
        preparedStatement.setString(6,pmodel.getCategory());
        preparedStatement.setInt(7, pmodel.getProductCredits());
        int rs = preparedStatement.executeUpdate();
        return rs;
    }
    public int getProductId() throws Exception{
        db.getConnectivity();
        String query = "SELECT COUNT(*) FROM product_details";
        PreparedStatement preparedStatement =DBConnectivity.con.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int rowCount = resultSet.getInt(1);
        return rowCount;
    }
    public int removeProducts(ProductsModel pmodel) throws Exception{
        db.getConnectivity();
        String query="delete from product_details where product_name=? and category=? and supplier_id=?";
        PreparedStatement preparedStatement = DBConnectivity.con.prepareStatement(query);
        preparedStatement.setString(1, pmodel.getProductName());
        preparedStatement.setString(2, pmodel.getCategory());
        preparedStatement.setInt(3, pmodel.getSupplierId());
        int rs = preparedStatement.executeUpdate();
        return rs;
    }
    public int updateProductName(ProductsModel pmodel,String newName) throws Exception{
        db.getConnectivity();
        String query="update product_details set product_name=? where product_name=? and category =? and supplier_id=?";
        PreparedStatement preparedStatement = DBConnectivity.con.prepareStatement(query);
        preparedStatement.setString(1, newName);
        preparedStatement.setString(2, pmodel.getProductName());
        preparedStatement.setString(3, pmodel.getCategory());
        preparedStatement.setInt(4, pmodel.getSupplierId());
        int rs = preparedStatement.executeUpdate();
        return rs;
    }
    public int updateProductQuantity(ProductsModel pmodel,int newQuantity) throws Exception{
        db.getConnectivity();
        String query="update product_details set quantity=? where product_name=? and category =? and supplier_id=?";
        PreparedStatement preparedStatement = DBConnectivity.con.prepareStatement(query);
        preparedStatement.setInt(1, newQuantity);
        preparedStatement.setString(2, pmodel.getProductName());
        preparedStatement.setString(3, pmodel.getCategory());
        preparedStatement.setInt(4, pmodel.getSupplierId());
        int rs = preparedStatement.executeUpdate();
        return rs;
    }
    public int updateProductPrice(ProductsModel pmodel,int newPrice) throws Exception{
        db.getConnectivity();
        String query="update product_details set price=? where product_name=? and category =? and supplier_id=?";
        PreparedStatement preparedStatement = DBConnectivity.con.prepareStatement(query);
        preparedStatement.setInt(1, newPrice);
        preparedStatement.setString(2, pmodel.getProductName());
        preparedStatement.setString(3, pmodel.getCategory());
        preparedStatement.setInt(4, pmodel.getSupplierId());
        int rs = preparedStatement.executeUpdate();
        return rs;
    }
    public int updateProductCredits(ProductsModel pmodel,int newcredits) throws Exception{
        db.getConnectivity();
        String query="update product_details set product_credits=? where product_name=? and category =? and supplier_id=?";
        PreparedStatement preparedStatement = DBConnectivity.con.prepareStatement(query);
        preparedStatement.setInt(1, newcredits);
        preparedStatement.setString(2, pmodel.getProductName());
        preparedStatement.setString(3, pmodel.getCategory());
        preparedStatement.setInt(4, pmodel.getSupplierId());
        int rs = preparedStatement.executeUpdate();
        return rs;
    }
    public ResultSet searchProducts(ProductsModel pmodel) throws Exception{
        db.getConnectivity();
        String query = "SELECT * FROM product_details WHERE supplier_id=?";
        PreparedStatement preparedStatement = DBConnectivity.con.prepareStatement(query);
        preparedStatement.setInt(1, pmodel.getSupplierId());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    public List<ProductsModel> getAllProducts() throws Exception{
        db.getConnectivity();
        List<ProductsModel> productList = new ArrayList<>();
        String query = "SELECT * FROM product_details";
        PreparedStatement preparedStatement = DBConnectivity.con.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            ProductsModel product = new ProductsModel();
            product.setProductId(resultSet.getInt("product_id"));
            product.setSupplierId(resultSet.getInt("supplier_id"));
            product.setProductName(resultSet.getString("product_name"));
            product.setPrice(resultSet.getInt("price"));
            product.setQuantity(resultSet.getInt("quantity"));
            product.setCategory(resultSet.getString("category"));
            product.setProductCredits(resultSet.getInt("product_credits"));
            productList.add(product);
        }
        return productList;
    }
}
