package racingcar.domain;

public class Car{

    private String name;
    private int forwardCount;

    public Car(String name, int forwardCount){
        this.name = name;
        this.forwardCount = forwardCount;
    }

    public void drive(){

    }

    public boolean isGoingForward(){
        return false;
    }

    public String printCarState(){
        return "";
    }

    public String getName(){
        return name;
    }

    public int getForwardCount(){
        return forwardCount;
    }

}
