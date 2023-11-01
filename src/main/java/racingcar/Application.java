package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 처리
        ConsoleUI consoleUI = new ConsoleUI();
        List<String> carNames = consoleUI.getCarNames();
        int moveNum = consoleUI.getMoveNum();

        // 자동차 객체 생성
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        // 경주 게임 실행
        RacingGame racingGame = new RacingGame(cars);
        racingGame.play(moveNum);

        // 우승자 출력
        consoleUI.printWinners(racingGame.getWinners());
    }
}
