package racingcar.service;

import static racingcar.constant.Constant.SPLIT_REGEX;
import static racingcar.constant.ExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE;
import static racingcar.constant.ExceptionMessage.CAR_NAME_INCLUDE_BLANK_EXCEPTION_MESSAGE;
import static racingcar.constant.ExceptionMessage.CAR_NAME_OVER_LENGTH_EXCEPTION_MESSAGE;
import static racingcar.constant.ExceptionMessage.SET_NOT_NUMBER_EXCEPTION_MESSAGE;
import static racingcar.constant.ExceptionMessage.SET_RANGE_EXCEPTION_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.dto.FinalResultDto;
import racingcar.dto.SetResultDto;
import racingcar.model.Car;
import racingcar.model.Game;

public class CarRacingGameService {
    public Car getCar(String carNameInput) {
        List<String> carNameInputList = List.of(carNameInput.split(SPLIT_REGEX));

        validateCarNameInput(carNameInputList);

        return new Car(carNameInputList);
    }

    private static void validateCarNameInput(List<String> carNameInputList) {
        checkDuplicateName(carNameInputList);
        checkBlank(carNameInputList);
        checkNameLength(carNameInputList);
    }

    private static void checkDuplicateName(List<String> carNameInputList) {
        Set<String> inputCarNameSet = new HashSet<>(carNameInputList);

        if (inputCarNameSet.size() != carNameInputList.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private static void checkBlank(List<String> carNameInputList) {
        for (String inputCarName : carNameInputList) {
            if (inputCarName.contains(" ")) {
                throw new IllegalArgumentException(CAR_NAME_INCLUDE_BLANK_EXCEPTION_MESSAGE);
            }
        }
    }

    private static void checkNameLength(List<String> carNameInputList) {
        for (String inputCarName : carNameInputList) {
            if (inputCarName.length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_OVER_LENGTH_EXCEPTION_MESSAGE);
            }
        }
    }

    public Game getGame(Car cars, String gameSetInput) {
        validateGameSetInput(gameSetInput);

        return new Game(cars, gameSetInput);
    }

    public static void validateGameSetInput(String gameSetInput) {
        isNumber(gameSetInput);
        checkRange(gameSetInput);
    }

    private static void isNumber(String gameSetInput) {
        try {
            Integer.parseInt(gameSetInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(SET_NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static void checkRange(String gameSetInput) {
        int set = Integer.parseInt(gameSetInput);

        if (set < 1 || set > 99) {
            throw new IllegalArgumentException(SET_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public boolean isContinue(Game game) {
        return game.isContinue();
    }

    public SetResultDto playSet(Game game) {
        game.playSet();

        return new SetResultDto(game.getCars());
    }

    public FinalResultDto getFinalResult(Game game) {
        return new FinalResultDto(game.getWinnerList());
    }
}
