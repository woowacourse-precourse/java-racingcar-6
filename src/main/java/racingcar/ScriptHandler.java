package racingcar;

import java.util.ArrayList;

public class ScriptHandler {

    private static final String REQUIRE_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUIRE_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String PROGRESS_RESULT = "실행결과";

    private Judgement judgement = new Judgement();
    private int winnerNumber;

    public void printGetCarNameScript() {
        System.out.println(REQUIRE_CAR_NAME_MESSAGE);
    }

    public void printGetAttemptScript() {
        System.out.println(REQUIRE_ATTEMPT_NUMBER_MESSAGE);
    }

    public void printSimpleResultScript() {
        System.out.println(PROGRESS_RESULT);
    }

    public void printCarMovement(ArrayList<Car> car, int index) {
        String carName = car.get(index).getCarName();
        int movement = car.get(index).getCarMovement();
        System.out.printf("%s : ", carName);
        for (int i = 0; i < movement; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(ArrayList<String> winnerList) {
        winnerNumber = judgement.checkWinnersNumber(winnerList);
        if (winnerNumber == 1) {
            printSoloWinner(winnerList);
        }
        if (winnerNumber > 1) {
            printJointWinner(winnerList);
        }
    }

    public void printSoloWinner(ArrayList<String> winnerList) {
        System.out.printf("최종 우승자 : %s", winnerList.get(0));
    }

    public void printJointWinner(ArrayList<String> winnerList) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size() - 1; i++) {
            System.out.print(winnerList.get(i) + ", ");
        }
        System.out.println(winnerList.get(winnerList.size() - 1));
    }
}
