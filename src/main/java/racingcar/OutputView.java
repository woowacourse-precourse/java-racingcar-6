package racingcar;

import java.util.List;

public class OutputView {

    private static final String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public OutputView() {
    }

    public void printRacingCarGameResult(List<String> carNameList, List<Integer> carMovingCountList) {
        for (int i = 0; i < carNameList.size(); i++) {
            String carName = carNameList.get(i);

            int carMovingCount = carMovingCountList.get(i);
            String carMovingCountString = changeCarMovingCountToString(carMovingCount);

            System.out.println(carName + " : " + carMovingCountString);
        }
    }

    public String changeCarMovingCountToString(int carMovingCount) {
        String carMovingCountString = "";

        for (int i = 0; i < carMovingCount; i++) {
            carMovingCountString += "-";
        }
        return carMovingCountString;
    }

    public void printNameMessage() {
        System.out.println(NAME_MESSAGE);
    }

    public void printCountMessage() {
        System.out.println(COUNT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printWinnerMessage() {
        System.out.println(WINNER_MESSAGE);
    }
}
