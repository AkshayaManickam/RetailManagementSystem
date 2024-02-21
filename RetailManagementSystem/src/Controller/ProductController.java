package Controller;

import Model.DAO.ProductsDAO;
import Model.DTO.ProductsModel;

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
}
