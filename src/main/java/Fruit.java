import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Fruit {
    private String name;
    private int price;
    private int count;
    private String quality;
}
