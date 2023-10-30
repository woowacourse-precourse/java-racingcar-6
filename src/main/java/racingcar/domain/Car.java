package racingcar.domain;

public class Car{

    private String name;
    private int forwardCount;

    public Car(String name){
        throwIfInvalidNameLength(name);
        this.name = name;
        this.forwardCount = 0;
    }

    private void throwIfInvalidNameLength(String name){
        if(name.length()>5){
            throw new IllegalArgumentException("Racing car name length cannot be more than 5.");
        }
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
