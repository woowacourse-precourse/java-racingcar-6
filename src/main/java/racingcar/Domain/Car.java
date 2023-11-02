package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Util.OperationStatus;

public class Car {
    private String name;
    private String displacement;

    public Car(String name) {
        this.name = name;
        this.displacement = "";
    }

    public Car(String name, String displacement) {
        this.name = name;
        this.displacement = displacement;
    }

    public void runRace() {
        OperationStatus nextMovement = decide_movement();
        if(nextMovement == OperationStatus.MOVEMENT) {
            move_forward();
        }
    }

    public void showDisplacement() {
        System.out.println(this.name + " : " + this.displacement);
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getName() {
        return this.name;
    }

    private void move_forward() {
        this.displacement += "-";
    }

    private OperationStatus decide_movement() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (randomNumber >= 4) {
            return OperationStatus.MOVEMENT;
        }
        return OperationStatus.STOP;
    }


}


