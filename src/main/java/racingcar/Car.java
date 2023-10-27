package racingcar;

public class Car {
    private final Name name;
    private final Position position;

    public Car(Name name,Position position){
        this.name=name;
        this.position=position;
    }

    public String getNameValue(){
        return name.getName();
    }

    public void attemptForward(){
        position.attemptForward();
    }

    public String getCurrentPositionStatus(){
        return position.switchPositionToSlash();
    }

}
