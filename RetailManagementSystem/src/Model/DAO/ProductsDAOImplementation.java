package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        String query = "SELECT COUNT(*) FROM product__details";
        PreparedStatement preparedStatement =DBConnectivity.con.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int rowCount = resultSet.getInt(1);
        return rowCount;
    }
}
