package racingcar;

public class Car {
    private String name;
    private int forwardCnt;

    public Car(String name){
        this.name = name;
        this.forwardCnt = 0;
    }

    public void goForward(){
        forwardCnt++;
    }
}
