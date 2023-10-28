package racingcar.domain;

public class Car {
    private String name;
    private int forwardNum;
    private int randomNum;

    public Car(String name){
        this.name = name;
        this.forwardNum = 0;
    }

    public int getForwardNum(){
        return this.forwardNum;
    }

    public int getRandomNum(){
        return this.randomNum;
    }
}
