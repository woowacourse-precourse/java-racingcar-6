package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class GamePlayView {

    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPTS_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String SHOW_GAME_RESULT = "실행결과";
    private static final String SHOW_WINNER = "최종 우승자 : ";


    public String inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public int inputAttemptsCount() {
        System.out.println(INPUT_ATTEMPTS_COUNT_MESSAGE);
        String attemptStr = Console.readLine();
        int attemptsCount = Integer.parseInt(attemptStr);

        return attemptsCount;
    }

    public void showResult(List<Car> carList, int attempts) {
        System.out.println(SHOW_GAME_RESULT);

        for (int i = 0; i < attempts; i++) {
            for (Car car : carList) {
                car.controlMovement();
                System.out.printf("%s : %s%n", car.getName(), car.reportMovement());
            }
            System.out.println();
        }
    }

    public void showWinner(List<String> winnerList) {
        String winner = winnerList.get(0);

        for (int i = 1; i < winnerList.size(); i++) {
            winner += "," + winnerList.get(i);
        }

        System.out.println(SHOW_WINNER + winner);
    }
}
