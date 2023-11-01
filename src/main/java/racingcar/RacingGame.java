package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    private final User user;
    private final CarList carList;
    private final String[] carNameList;
    private final int count;
    private int max = -1;
    private final StringBuilder sb;

    public RacingGame() {
        user = new User();
        carList = new CarList(user.initCarList());
        carNameList = retrieveCarList();
        count = retrieveCount();
        sb = new StringBuilder();
    }

    public void startRacingGame() {
        sb.append("\n실행 결과\n");

        for (int i = 0; i < count; i++) {
            for (String carName : carNameList) {
                checkMoving(carName);
                checkPositionAndMax(carName);
            }
            sb.append('\n');
        }

        checkWinner();

        System.out.println(sb);
    }

    private String[] retrieveCarList() {
        return carList.getCarNameList();
    }

    private int retrieveCount() {
        return user.initCount();
    }

    private void checkMoving(String carName) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            carList.moveForward(carName);
        }
    }

    private void checkPositionAndMax(String carName) {
        int position = carList.getPosition(carName);
        if (position > max) {
            max = position;
        }
        printPosition(carName, position);
    }

    private void printPosition(String carName, int position) {
        sb.append(carName);
        sb.append(" : ");
        sb.append("-".repeat(position));
        sb.append('\n');
    }

    private void checkWinner() {
        boolean flag = false;

        sb.append("최종 우승자 : ");

        for (String carName : carNameList) {
            int position = carList.getPosition(carName);

            if (position < max) {
                continue;
            }

            if (flag) {
                sb.append(", ");
            }
            sb.append(carName);
            if (!flag) {
                flag = true;
            }
        }
    }

}
