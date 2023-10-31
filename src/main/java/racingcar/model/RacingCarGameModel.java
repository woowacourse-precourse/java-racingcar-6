package racingcar.model;

import java.util.List;

public class RacingCarGameModel {
    private int roundNumber;
    private List<RacingCar> carList;

    public RacingCarGameModel() {}

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void setCarList(List<RacingCar> carList) {
        this.carList = carList;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public List<RacingCar> getCarList() {
        return carList;
    }

    public void decrementRoundNumber() {
        roundNumber--;
    }
}
