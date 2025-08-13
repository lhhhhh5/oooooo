package ssm.web.service;

import ssm.web.po.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有商品
     */
    List<Product> findAll();

    /**
     * 更新
     * 返回条数
     */
    void updateProduct(Product product);

    /**
     * 删除
     * @param pid  商品id
     * @return 条数
     */
    void deleteByPid(Integer pid);

    /**
     * 保存商品
     * @param product
     * @return 添加行数
     */
    void saveProduct(Product product);
}
