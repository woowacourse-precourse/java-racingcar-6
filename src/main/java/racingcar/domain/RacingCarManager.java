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

}
