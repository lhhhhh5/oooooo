package ssm.web.mapper;


import org.apache.ibatis.annotations.Mapper;
import ssm.web.po.Product;

import java.util.List;


//@Mapper
public interface ProductMapper {

    /**
     * 查询所有商品
     */
    List<Product> findAll();

    /**
     * 更新
     * 返回条数
     */
    int updateProduct(Product product);

    /**
     * 删除
     * @param pid  商品id
     * @return 条数
     */
    int deleteByPid(Integer pid);

    /**
     * 保存商品
     * @param product
     * @return 添加行数
     */
    int saveProduct(Product product);
}
