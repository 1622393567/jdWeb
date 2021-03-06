public class User {
    private String userName;//用户名字
    private String userId;//用户ID
    private String userPassWord;//用户密码
    private String userPhone;//用户密码
    private Order order;//用户订单

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public User() {

    }

    public User(String userName, String userId, String userPassWord, Order order,String userPhone) {
        this.userName = userName;
        this.userId = userId;
        this.userPassWord = userPassWord;
        this.order = order;
        this.userPhone=userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
