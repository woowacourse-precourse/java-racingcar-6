package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MyCar {
    private final int ID;
    private final String CAR_NAME;
    private int pressure;
    private String forward;
    private int forwardCount;
    public MyCar(int id, String carName) {
        this.ID = id;
        this.CAR_NAME = carName;
        this.forward = "";
        this.forwardCount = 0;
    }

    public void builderForward() {
        forward();
    }
    public void forward() {
        pressure = Randoms.pickNumberInRange(0, 9);
        if (pressure >= 4) {
            forward += "-";
            forwardCount++;
        }
    }
    public int getForwardCount() {
        return forwardCount;
    }

    public void setForward(String hyphen) {
        this.forward = hyphen;
    }

    public String getCarName() {
        return CAR_NAME;
    }

    @Override
    public String toString() {
        return CAR_NAME + " : " +
                forward;
    }

}