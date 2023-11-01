package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;

public class RacingService {

    private final int MAX_NAME_LENGTH = 5;

    public void startGame() {
        // TODO: read input
        String[] carNames = readCarNames();
        Integer tryCount = readTryCount();
        System.out.println();

        // TODO: Game setting
        Game game = new Game(tryCount);
        for (String carName : carNames) {
            game.addCar(new Car(carName));
        }

        // TODO: Game Start
        System.out.println("실행 결과");
        while (!game.isOver()) {
            game.playStep();
        }

        // TODO: print result
        game.printWinner();
    }

    private String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = readLine();
        return validateCarName(carNamesInput);
    }

    private String[] validateCarName(String carNames) {
        String[] nameList = carNames.split(",");
        if (nameList.length < 1) {
            throw new IllegalArgumentException();
        }

        for (String name : nameList) {
            validate(name);
        }

        return nameList;
    }

    private void validate(String name) {
        if (name.length() < 1 || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private Integer readTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCountInput = readLine();
        return validateTryCount(tryCountInput);
    }

    private Integer validateTryCount(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
