package Javase.usuallyclass.compare;

public class Goods implements Comparable{
    private String name;
    private int price;

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o){
        if(o instanceof Goods){
            Goods goods = (Goods) o;
            if(this.price< goods.price){
                return -1;
            }else if((this.price> goods.price)){
                return 1;
            }else {
                return 0;
            }
        }
            throw new RuntimeException("不是一个类");

    }
}
