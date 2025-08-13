package ssm.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.web.mapper.ProductMapper;
import ssm.web.po.Product;
import ssm.web.service.ProductService;

import java.util.Collections;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    @Override
    @Transactional(readOnly = true)//事务管理标签，
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteByPid(Integer pid) {
        productMapper.deleteByPid(pid);
    }

    @Override
    public void saveProduct(Product product) {
        productMapper.saveProduct(product);
    }
}
