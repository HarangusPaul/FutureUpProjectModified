package ro.zynk.futureup.controllers.responses;

public class SumResponse extends BaseResponse {
    private float money;

    public SumResponse() {
    }

    @Override
    public String toString() {
        return "SumResponse{" +
                "money=" + money +
                '}';
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public SumResponse(float money) {
        this.money = money;
    }
}
