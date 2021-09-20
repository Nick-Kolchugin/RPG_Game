public class Merchant implements Seller{

    private String name;

    public Merchant(String name) {
        this.name = name;
    }

    @Override
    public String sell(Goods goods) {
        String result = "";
        if(goods == Goods.POTION){
            result = "potion";
        }
        return result;
    }

    public enum Goods{
        POTION
    }

}
