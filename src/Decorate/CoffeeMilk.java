package Decorate;

/**
 * 模拟咖啡
 * 1、抽象组件：需要装饰的抽象对象（接口或者抽象父类）
 * 2、具体组件：需要装饰的对象
 * 3、抽象装饰类:包含了对抽象组件的引用以及装饰者共有的方法
 * 4、具体装饰类: 被装饰的对象
 */
public class CoffeeMilk {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        Suger suger = new Suger(coffee);
        System.out.println(suger.info()+"-->"+suger.cost());
        Milk milk = new Milk(suger);
        System.out.println(milk.info()+"-->"+milk.cost());
    }
}
//抽象组件
interface Drink{
    double cost();
    String info();
}
//具体组件
class Coffee implements  Drink{
    private String name = "原味咖啡";

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}
//抽象装饰类

abstract class DecorateStuff implements Drink{
    private Drink drink;

    public DecorateStuff(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}
//具体装饰类

class Milk extends DecorateStuff{
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()+4;
    }

    @Override
    public String info() {
        return super.info()+"加入了牛奶";
    }
}

class Suger extends DecorateStuff{
    public Suger(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()+2;
    }

    @Override
    public String info() {
        return super.info()+"加入了糖";
    }
}

