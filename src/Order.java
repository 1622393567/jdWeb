public class Order {
    private int orderId;//订单编号
    private String orderGoods;//订单商品名称
    private double goodsPrrice;//商品单价
    private double orderPrice;//订单价格
    private  int  count;//订单数量

    public Order(){

    }
    public int getOrderId() {
        return orderId;
    }

    public Order(int orderId, String orderGoods, double goodsPrrice, double orderPrice, int count) {
        this.orderId = orderId;
        this.orderGoods = orderGoods;
        this.goodsPrrice = goodsPrrice;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(String orderGoods) {
        this.orderGoods = orderGoods;
    }

    public double getGoodsPrrice() {
        return goodsPrrice;
    }

    public void setGoodsPrrice(double goodsPrrice) {
        this.goodsPrrice = goodsPrrice;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
