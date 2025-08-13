package ssm.web.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ssm.web.po.Product;
import ssm.web.service.ProductService;

import static org.junit.jupiter.api.Assertions.*;

//@SpringJUnitConfig(locations = {"classpath:spring/application-dao.xml","classpath:spring/application-service.xml"})
@SpringJUnitConfig(locations = "classpath:spring/application-*.xml")
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    void findAll() {
        productService.findAll().forEach(System.out::println);
    }

    @Test
    void updateProduct() {
        Product product = new Product(13, "索尼单反相机", 7999.0, "数码相机");
        productService.updateProduct(product);
    }

    @Test
    void deleteByPid() {
    }

    @Test
    void saveProduct() {
    }
}