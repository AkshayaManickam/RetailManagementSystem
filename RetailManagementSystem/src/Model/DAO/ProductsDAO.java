package Model.DAO;

import Model.DTO.ProductsModel;

public interface ProductsDAO {
    int addProduct(ProductsModel pmodel) throws Exception;
    int getProductId() throws Exception;
}
