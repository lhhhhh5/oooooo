package ssm.web.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer pid;
    private String pname;
    private Double price;
    private String category_name;

    public Product(String pname, Double price, String category_name) {
        this.pname = pname;
        this.price = price;
        this.category_name = category_name;
    }
}
