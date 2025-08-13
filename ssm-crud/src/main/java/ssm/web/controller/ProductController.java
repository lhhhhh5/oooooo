package ssm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ssm.web.enums.OperationStatus;
import ssm.web.po.Product;
import ssm.web.service.ProductService;
import ssm.web.utiles.ResponseData;
import ssm.web.utiles.ResultUtiles;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("list")
    public ResponseData findAll(){
        try {
            List<Product> products = productService.findAll();
            int i=1/0;
            return ResultUtiles.result(OperationStatus.SUCCESS,products);
        } catch (Exception e) {
            return ResultUtiles.result(OperationStatus.FAIL,e.getMessage());
        }
    }

    /**
     *
     * @param product
     * @return json
     */
    @PutMapping("/update")
    public ResponseData UpdateProduct(@RequestBody Product product){
        try {
            productService.updateProduct(product);

            return ResultUtiles.result(OperationStatus.SUCCESS,product);
        }catch (Exception e) {
            return ResultUtiles.result(OperationStatus.FAIL,e.getMessage());
        }
    }

    @PostMapping("/add")
    public ResponseData AddProduct(@RequestBody Product product){
        try{
            productService.saveProduct(product);
            return ResultUtiles.result(OperationStatus.SUCCESS,product);
        }catch (Exception e) {
            return ResultUtiles.result(OperationStatus.FAIL,e.getMessage());
        }
    }

    @DeleteMapping("/delete/{pid}")
    public ResponseData DeleteProduct(@PathVariable("pid") Integer pid){
        try{
            productService.deleteByPid(pid);
            return ResultUtiles.result(OperationStatus.SUCCESS,pid);
        }catch (Exception e) {
            return ResultUtiles.result(OperationStatus.FAIL,e.getMessage());
        }
    }
}
