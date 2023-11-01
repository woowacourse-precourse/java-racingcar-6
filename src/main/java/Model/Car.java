package Model;

import View.carRaceOutputService;
import Validator.CarNameValidator;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int moves = 0;

    public Car(String name) {
        CarNameValidator.getInstance().validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getMoves() {
        return this.moves;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean shouldMoveFoward() {
        int randomNumber = getRandomNumber();
        if (randomNumber >= 4) {
            return true;
        }
        return false;

    }

    private void moveForward() {
        this.moves++;
    }

    public void race() {
        int n = getRandomNumber();
        if (shouldMoveFoward()) {
            moveForward();
        }
        carRaceOutputService.getInstance().printCarStatus(this);
    }


}
