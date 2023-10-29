package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name){
        ErrorManager.validateNameNull(name);
        ErrorManager.validateNameLength(name);
        this.name = name;
    }

    public void move(int power){
        if(power >= 4){
            position += 1;
        }
    }

    public int getPosition(){
        return position;
    }
}
