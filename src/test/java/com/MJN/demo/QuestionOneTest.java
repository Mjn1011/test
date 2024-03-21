package com.MJN.demo;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuestionOneTest {
    @Test
    void questionOne(){
        Fruit apple = new Fruit(Constant.PRICE_OF_APPLE,Constant.CODE_OF_APPLE);
        Fruit strawberry = new Fruit(Constant.PRICE_OF_STRAWBERRY,Constant.CODE_OF_STRAWBERRY);

        int sumApple = calPrice(2,apple);
        int sumStrawberry = calPrice(1,strawberry);

        int total = sumApple+sumStrawberry;
        System.out.println("您购买的水果总价为："+total);
    }

    /**
     *
     * @param kilogram 斤
     * @param fruit 水果对象
     * @return 总价
     */
    public int calPrice(int kilogram, Fruit fruit){
        if (kilogram<0){
            throw new RuntimeException("重量错误， 请重新输入.");
        }
        if (StringUtils.isNotBlank(fruit.getCode())){
            if (fruit.getCode().equals(Constant.CODE_OF_STRAWBERRY) || fruit.getCode().equals(Constant.CODE_OF_APPLE)){
                return kilogram*fruit.getPrice();
            } else {
                throw new RuntimeException("水果代码错误。");
            }
        } else{
            throw new RuntimeException("水果代码错误。");
        }
    }

}
