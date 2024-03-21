package com.MJN.demo;

import com.sun.org.apache.bcel.internal.Const;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuestionThreeTest {
    @Test
    void questionThree(){
        Fruit apple = new Fruit(Constant.PRICE_OF_APPLE,Constant.CODE_OF_APPLE);
        Fruit strawberry = new Fruit(Constant.PRICE_OF_STRAWBERRY,Constant.CODE_OF_STRAWBERRY);
        Fruit mango = new Fruit(Constant.PRICE_OF_MANGO,Constant.CODE_OF_MANGO);

        double sumApple = calPrice(1,apple);
        double sumStrawberry = calPrice(1,strawberry);
        double sumMango = calPrice(1,mango);

        double total = sumApple+sumStrawberry+sumMango;
        System.out.println("您购买的水果总价为："+total);
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
