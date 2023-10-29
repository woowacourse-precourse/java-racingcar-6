package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    CarList carList;
    int count;
    StringBuilder sb;

    public RacingGame() {
        sb = new StringBuilder();
        retrieveCarList();
        retrieveCount();

        String[] carNameList = carList.getCarNameList();

        for (int i=0; i<count; i++) {
            for (String carName : carNameList) {
                checkMoving(carName);
            }
            sb.append('\n');
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

        printMoving(carName);
    }

    private void printMoving(String carName) {
        int position = carList.getPosition(carName);
        sb.append(carName);
        sb.append(" : ");
        sb.append(position);
        sb.append('\n');
    }

}
