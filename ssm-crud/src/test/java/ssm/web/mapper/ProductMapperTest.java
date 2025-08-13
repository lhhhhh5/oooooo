package ssm.web.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ssm.web.po.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringJUnitConfig(locations = "classpath:spring/application-dao.xml")
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;


    @Test
    void findAll() {
        List<Product> products = productMapper.findAll();
        products.forEach(System.out::println);
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteByPid() {
    }

    @Test
    void saveProduct() {
    }
}