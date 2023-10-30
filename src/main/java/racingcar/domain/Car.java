package racingcar.domain;

public class Car {
    private static final int CAN_GO_FORWARD_START = 4;
    private int forward;
    public int goForward(int random){
        if(random >= 4){
            forward++;
        }
        return this.forward;
    }
}
