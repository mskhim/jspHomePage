package co.kh.dev.home.model;

import java.sql.Date;

public class ShopOrderVO {
    private int no;              // 주문 번호
    private int groupNo;         // 그룹 번호
    private String customerId;   // 고객 ID
    private int shopNo;       // 상품 번호
    private int qt;              // 수량
    private Date subDate;        // 주문 날짜
    private int state;           // 상태

    // 기본 생성자
    public ShopOrderVO() {}

    // 매개변수 있는 생성자
    public ShopOrderVO(int no, int groupNo, String customerId, int productNo, int qt, Date subDate, int state) {
        this.no = no;
        this.groupNo = groupNo;
        this.customerId = customerId;
        this.shopNo = productNo;
        this.qt = qt;
        this.subDate = subDate;
        this.state = state;
    }

    // Getter와 Setter
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getSHopNo() {
        return shopNo;
    }

    public void setShopNo(int productNo) {
        this.shopNo = productNo;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public Date getSubDate() {
        return subDate;
    }

    public void setSubDate(Date subDate) {
        this.subDate = subDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ShopOrderVO [no=" + no + ", groupNo=" + groupNo + ", customerId=" + customerId
                + ", productNo=" + shopNo + ", qt=" + qt + ", subDate=" + subDate + ", state=" + state + "]";
    }
}