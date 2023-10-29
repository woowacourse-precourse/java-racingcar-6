package racingcar;

public class Car {
    String name;
    Integer location;
    Integer currentValue;
    Boolean isWinner;
    Car(String name){
        this.name = name;
        location = 0;
        currentValue = 0;
        isWinner = false;
    }
    public void advance(Integer movingDistance){
        location += movingDistance;
    }
    public Integer getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setCurrentValue(Integer currentValue) {
        this.currentValue = currentValue;
    }
    public Integer getCurrentValue() {
        return currentValue;
    }
    public void setWinner(){
        isWinner = true;
    }
    public Boolean isWinner(){
        return isWinner;
    }
}
