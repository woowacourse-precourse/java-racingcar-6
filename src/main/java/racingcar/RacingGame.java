package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    CarList carList;
    int count;

    public RacingGame() {
        retrieveCarList();
        retrieveCount();

        String[] carNameList = carList.getCarNameList();

        for (String carName : carNameList) {
            checkMoving(carName);
        }
    }

    private void retrieveCarList() {
        CarList carlist = new CarList();
    }

    private void retrieveCount() {
        User user = new User();
        count = user.initCount();
    }

    private void checkMoving(String carName) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            carList.moveForward(carName);
        }
    }

}
