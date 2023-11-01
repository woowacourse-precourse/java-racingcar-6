package racingcar.model;

import static racingcar.model.GameRule.MOVE_CONDITION;
import static racingcar.model.RandomNumberGenerator.randomNumberGenerator;

public class Car {
    private final Name name;
    private int position;

    public Car(String name){
        this.name = new Name(name);
        this.position = 0;
    }

    public void move(){
        if (MOVE_CONDITION <= randomNumberGenerator()){
            position++;
        }
    }
    public String getName() {
        return name.getCarName();
    }

    public int getPosition(){
        return position;
    }

}
