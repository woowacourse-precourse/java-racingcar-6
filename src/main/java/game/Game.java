package game;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static exception.Validator.validateCarNameLength;
import static exception.Validator.validateNaturalNumber;
import static random.RandomNumber.pickRandomNumber;

public class Game {
    public void start() {
        String[] carNameList = getCarNameInput();
        final int ROUND = getRoundInput();

        printResult(carNameList, ROUND);
    }

    private String[] getCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = readLine().split(",");
        validateCarNameLength(carNameList);

        return carNameList;
    }

    private int getRoundInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        final int ROUND = Integer.parseInt(readLine());
        validateNaturalNumber(ROUND);

        System.out.println();
        return ROUND;
    }

    private boolean canCarMoveForward(int number) {
        final int MIN_FORWARD_COUNT = 4;

        return number >= MIN_FORWARD_COUNT;
    }

    private void printResult(String[] carNameList, int round) {
        System.out.println("실행 결과");

        final int CAR_NAME_LENGTH = carNameList.length;

        int[] forwardCounts = new int[CAR_NAME_LENGTH];
        StringBuilder sb = new StringBuilder();

        for (int i = round; i > 0; i--) {
            getResult(carNameList, CAR_NAME_LENGTH, forwardCounts, sb, i);
        }

        System.out.print(sb);
    }

    private void getResult(String[] carNameList, int carNameLength, int[] result, StringBuilder sb, int i) {
        for (int j = 0; j < carNameLength; j++) {
            if (canCarMoveForward(pickRandomNumber())) {
                result[j]++;
            }
        }

        for (int k = 0; k < carNameLength; k++) {
            sb.append(carNameList[k])
                    .append(" : ")
                    .append("-".repeat(result[k]))
                    .append("\n");
        }

        if (i > 1) sb.append("\n");
    }
}

