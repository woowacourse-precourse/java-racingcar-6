package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    CarList carList;
    String[] carNameList;
    int count;
    StringBuilder sb;

    public RacingGame() {
        sb = new StringBuilder();
        retrieveCarList();
        retrieveCount();

        carNameList = carList.getCarNameList();

        for (int i=0; i<count; i++) {
            for (String carName : carNameList) {
                checkMoving(carName);
            }
            sb.append('\n');
        }

        System.out.println(sb);
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

    private void checkWinner() {
        int max = carList.getMax();
        boolean flag = false;

        for (String carName : carNameList) {
            int position = carList.getPosition(carName);
            if (flag) {
                sb.append(", ");
            }
            if (position == max) {
                sb.append(carName);
                flag = true;
            }
        }
    }

}
