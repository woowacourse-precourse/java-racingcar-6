package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameUI {
    // 자동차 주행거리 출력
    public void printCarDistance(Car car) {
        System.out.println(car.getCarName() + " : " + car.getDistanceDriven());
    }
    // 줄바꿈
    public void printNewLine() {
        System.out.println();
    }

    private void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private void printInputAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private void printExecutionResultMessage() {
        System.out.println("실행 결과");
    }

    private void printFinalWinner(String winner) {
        System.out.println("최종 우승자" + " : " + winner);
    }

    public void gameUiLogic() {
        User user = new User();
        GameManager gameManager = new GameManager(user);

        printInputCarNameMessage();
        String inputCarNames = readLine();
        printInputAttemptNumber();
        String inputStr = readLine();
        int attemptNumber = Integer.parseInt(inputStr);
        printNewLine();
        printExecutionResultMessage();
        user.makeCars(inputCarNames);
        user.tryDriving(attemptNumber);
        printFinalWinner(gameManager.announceWinner());
    }
}
