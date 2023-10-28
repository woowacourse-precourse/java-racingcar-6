package racingcar.car;

public class CarInfo {
    String name;
    boolean isForward;
    int moveCount;


    public CarInfo(String name){
        this.name = name;
        this.isForward = false;
        this.moveCount = 0;
    }
}
