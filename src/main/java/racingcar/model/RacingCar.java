package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCar implements Car {

    Integer mileage;
    String name;

    public RacingCar(String carName) throws IllegalArgumentException {
        this.mileage = 0;
        this.name = carName;
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public Integer getMileage() {
        return this.mileage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void goForward() {
        int random = pickNumberInRange(0, 9);
        if (random >= 4) {
            ++this.mileage;
        }
    }
}
