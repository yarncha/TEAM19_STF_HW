import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Fruit {
    private String name;
    private int price;
    private int count;
    private String quality;

    //가격 비교 메소드
    public boolean comparePrice(int customerMoney){
        if(customerMoney>=this.price){
            return true;
        }else{
            return false;
        }

    }
}
