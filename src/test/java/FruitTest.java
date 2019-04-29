import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class FruitTest {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Before
    public void setUp() {
        Fruit appleFruit = new Fruit("사과", 700, 100, "high");
        Fruit bananaFruit = new Fruit("바나나", 1500, 50, "high");
        Fruit watermelonFruit = new Fruit("수박", 15000, 50, "high");
        Fruit mangoFruit = new Fruit("망고", 2000, 50, "high");
        Fruit orangeFruit = new Fruit("오랜지", 1000, 10, "high");
        Fruit grapeFruit = new Fruit("포도", 3000, 10, "low");

        fruitList.add(appleFruit);
        fruitList.add(bananaFruit);
        fruitList.add(watermelonFruit);
        fruitList.add(mangoFruit);
        fruitList.add(orangeFruit);
        fruitList.add(grapeFruit);
    }
    @Test
    public void testQualityOfFruit() {
        assertThat(fruitList.get(0).getQuality(), is("high")); //테스트코드//
    }

    @Test
    public void testPriceOfFruit() {
        assertThat(fruitList.get(4).getPrice(), is(2000)); //테스트코드
    }

    // 품질이 낮은 과일에 할인 적용
    @Test
    public void applyDiscountPrice(){
        int testIndex = 1;
        String quality = fruitList.get(testIndex).getQuality();
        if(quality.equals("low")){
            fruitList.get(testIndex).setPrice(fruitList.get(testIndex).getPrice()/2);
        }
    }

    // 과일 판매
    @Test
    public void checkSaledFruit(){
        int sellFruitIndex = 1;
        int wantCount = 1;
        System.out.println("바나나 "+wantCount+"개 사러 왔습니다!");
        int recivedMoney = 1500;
        System.out.println("여기 "+recivedMoney+"원이요.");

        assertThat(fruitList.get(sellFruitIndex).getPrice()*wantCount, is(recivedMoney));
        System.out.println("여기 바나나 있습니다. 감사합니다~");
    }

    // 과일 종류 다양성 테스트
    @Test
    public void isManyKindOfFruit(){
        assertThat(fruitList.size(),is(1));
        verify(fruitList, times(1)).size();
    }

    //과일 가격보다 적은 가격을 받을 경우 테스트
    @Test
    public void testLessThanSalePriceCase() {
        assertThat(fruitList.get(2).comparePrice(10000), is(false));
    }

    //특정 과일의 갯수를 제대로 반환하는지 테스트
    @Test
    public void testCheckCount() {
        String fruitName = "포도";
        int index = 0;
        for (; index < fruitList.size(); index++) {
            if (fruitList.get(index).getName() == fruitName) break;
        }
        assertThat(fruitList.get(index).getCount(), is(10));
    }


//    @Test
//    public void 계좌신규생성() {
//        Fruit fruit = new Fruit();
//
//        fruit.getBalance();
//        assertThat(fruit.getBalance(), is(0));
//
//    }
//
//    @Test
//    public void 예금테스트() {
//        Fruit fruit = new Fruit();
//
//        fruit.deposit(1000);
//        assertThat(fruit.getBalance(), is(1000)); //테스트코드
//    }
//
//    @Test
//    public void 출금테스트() {
//        Fruit fruit = new Fruit();
//
//        fruit.deposit(2000);
//        assertThat(fruit.getBalance(), is(2000)); //테스트코드
//
//        fruit.withraw(500);
//        assertThat(fruit.getBalance(), is(1500)); //테스트코드
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void 잔액보다큰금액은인출x() {
//        Fruit fruit = new Fruit();
//
//        fruit.deposit(300);
//        fruit.withraw(500);
//        assertThat(fruit.getBalance(), is(-200));
//    }


}