package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private int counts;
    private String carNames;

    public int getCounts() {
        return counts;
    }

    public String getCarNames() {
        return carNames;
    }

    public String printExecuteText() {
        return "실행 결과";
    }

    public String printStartGameText() {
        return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    }

    public boolean isCarNameLengthFive(String carName) {
        return carName.length() <= 5;
    }

    public void inputCarName() {
        carNames = Console.readLine();
    }

    public String printHowManyCounts() {
        return "시도할 회수는 몇회인가요?";
    }

    public void inputCounts() {
        counts = Integer.parseInt(Console.readLine());
    }

    public boolean isCountsInteger() {
        try {
            inputCounts();
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isCountsPositive() {
        return counts > 0;
    }


}
