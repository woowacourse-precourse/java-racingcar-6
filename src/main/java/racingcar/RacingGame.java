package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

    private final User user;
    private CarList carList;
    private String[] carNameList;
    private int count;
    private int max = -1;
    private final StringBuilder sb;

    public RacingGame() {
        user = new User();
        retrieveCarList();
        retrieveCount();
        sb = new StringBuilder();
    }

    public void startRacingGame() {
        sb.append("\n실행 결과\n");

        for (int i=0; i<count; i++) {
            for (String carName : carNameList) {
                checkMoving(carName);
                checkPositionAndMax(carName);
            }
            sb.append('\n');
        }

        checkWinner();

        System.out.println(sb);
    }

    private void retrieveCarList() {
        carList = new CarList(user.initCarList());
        carNameList = carList.getCarNameList();
    }

    private void retrieveCount() {
        count = user.initCount();
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
        for (int i=0; i<position; i++) {
            sb.append('-');
        }
        sb.append('\n');
    }

    private void checkWinner() {
        boolean flag = false;
        int arrLength = carNameList.length;

        sb.append("최종 우승자 : ");

        for (int i=0; i<arrLength; i++) {
            String carName = carNameList[i];
            int position = carList.getPosition(carName);

            if (flag && position == max) {
                sb.append(", ");
            }
            if (position == max) {
                sb.append(carName);
                flag = true;
            }
        }
    }

}
