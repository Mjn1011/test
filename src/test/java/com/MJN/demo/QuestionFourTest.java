package com.MJN.demo;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import static com.MJN.demo.Constant.DISCOUNT_OF_STRAWBERRY;

@SpringBootTest
class QuestionFourTest {

    @Test
    void questionFour(){
        Fruit apple = new Fruit(Constant.PRICE_OF_APPLE,Constant.CODE_OF_APPLE);
        Fruit strawberry = new Fruit(Constant.PRICE_OF_STRAWBERRY,Constant.CODE_OF_STRAWBERRY);
        Fruit mango = new Fruit(Constant.PRICE_OF_MANGO,Constant.CODE_OF_MANGO);
        double sumApple = calPrice(0,apple);
        double sumStrawberry = calPrice(0,strawberry);
        double sumMango = calPrice(21,mango);
        double total = sumApple+sumStrawberry+sumMango;
        System.out.println("您购买的水果原价为："+total);
        int totalDiscount = (int)total/100;
        total -= totalDiscount*10;
        System.out.println("商店现有优惠满100-10， 你本次的消费金额可以参与："+totalDiscount+"次");
        System.out.println("您购买的水果折后为："+total);
    }

    /**
     *
     * @param kilogram 斤
     * @param fruit 水果对象
     * @return 总价
     */
    public double calPrice(int kilogram, Fruit fruit){
        if (kilogram<0){
            throw new RuntimeException("重量错误， 请重新输入.");
        }
        if (StringUtils.isNotBlank(fruit.getCode())){
            if (fruit.getCode().equals(Constant.CODE_OF_MANGO) || fruit.getCode().equals(Constant.CODE_OF_APPLE)) {
                return kilogram*fruit.getPrice();
            } else if (fruit.getCode().equals(Constant.CODE_OF_STRAWBERRY)) {
                return kilogram*fruit.getPrice()*Constant.DISCOUNT_OF_STRAWBERRY;
            } else {
                throw new RuntimeException("水果代码错误。");
            }
        } else{
            throw new RuntimeException("水果代码错误。");
        }
    }

}
