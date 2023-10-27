package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;
import racingcar.model.Game;

public class CarRacingGameService {
    public Car getCar(String carNameInput) {
        List<String> carNameInputList = List.of(carNameInput.split(","));

        validateCarNameInput(carNameInputList);

        return new Car(carNameInputList);
    }

    private void validateCarNameInput(List<String> carNameInputList) {
        checkDuplicateName(carNameInputList);
        checkBlank(carNameInputList);
        checkNameLength(carNameInputList);
    }

    private void checkDuplicateName(List<String> carNameInputList) {
        Set<String> inputCarNameSet = new HashSet<>(carNameInputList);

        if (inputCarNameSet.size() != carNameInputList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private void checkBlank(List<String> carNameInputList) {
        for (String inputCarName : carNameInputList) {
            if (inputCarName.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름은 공백을 포함할 수 없습니다.");
            }
        }
    }

    private void checkNameLength(List<String> carNameInputList) {
        for (String inputCarName : carNameInputList) {
            if (inputCarName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 넘길 수 없습니다.");
            }
        }
    }

    public Game getGame(Car cars, String gameSetInput) {
        validateGameSetInput(gameSetInput);

        return new Game(cars, gameSetInput);
    }

    private void validateGameSetInput(String gameSetInput) {
        isNumber(gameSetInput);
        checkRange(gameSetInput);
    }

    private void isNumber(String gameSetInput) {
        try {
            Integer.parseInt(gameSetInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

    private void checkRange(String gameSetInput) {
        int set = Integer.parseInt(gameSetInput);

        if (set < 1 || set > 99) {
            throw new IllegalArgumentException("1이상 99이하의 숫자만 입력이 가능합니다.");
        }
    }

    public boolean isContinue(Game game) {
        return game.isContinue();
    }

    public void playSet(Game game) {
        game.playSet();
    }
}
