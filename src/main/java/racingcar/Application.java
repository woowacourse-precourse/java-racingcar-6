package racingcar;

import static camp.nextstep.edu.missionutils.Console.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Game game = new Game();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = readLine();
        validateCarNames(carNamesInput);

        List<Car> cars = game.generateCars(carNamesInput);


        System.out.println("시도할 회수는 몇회인가요?");
        String roundCountInput = readLine();
        validateRoundCount(roundCountInput);

        int roundCount = game.generateRoundCount(roundCountInput);

        game.showProcessingBoard(cars, roundCount);
        game.showResultBoard(cars);
    }

    public static void validateCarNames(String carNamesInput) {
        String[] carNames = carNamesInput.split(",");
        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    public static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validateRoundCount(String roundCountInput) {
        for (int index = 0; index < roundCountInput.length(); index++) {
            validateRoundCountCharacter(roundCountInput.charAt(index));
        }
    }


    public static void validateRoundCountCharacter(char characterAtRoundCountInput) {
        if (!Character.isDigit(characterAtRoundCountInput)) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }


}
