package racingcar.domain;

public class RacingCarManager {
    private final CarList carList;

    public RacingCarManager(CarNameList carNameList) {
        carList = new CarList(carNameList);
    }

    public void playRacingGame() {
        for (Car car : carList.getCarList()) {
            car.moveOrStop();
        }
    }

    public CarList getCarList() {
        return this.carList;
    }

    public CarList getMostDistanceCarList() {
        return this.carList.getMostDistanceCarList();
    }
}