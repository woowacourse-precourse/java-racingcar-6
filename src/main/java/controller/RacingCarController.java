package controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import service.RacingCarService;
import util.View;

public class RacingCarController {

    private static final String DUPLICATED_NAME = "중복된 이름을 사용할 수 없습니다.";
    private static final String OVER_LIMIT_NAME_LENGTH = "5자 이상의 이름은 입력할 수 없습니다.";
    private static final String COMMA = ",";
    private static final int LIMIT_NAME_LENGTH = 5;

    private RacingCarService racingCarService = new RacingCarService();

    public void extractName(String input) {
        List<String> carNameList = Arrays.asList(input.split(COMMA));
        validateLimitNameLength(carNameList);
        Set<String> carNameSet = validateDuplicateName(carNameList);

        racingCarService.generateRacingCar(carNameSet);
    }

    public void startRacing(String input) {
        validateIsNumeric(input);
        int cycle = changeInputToInt(input);

        View.printRacingResultMessage();
        View.printMessage(racingCarService.racing(cycle));
    }

    public void showResult() {
        View.printMessage(racingCarService.judgeWinners());
    }

    private int changeInputToInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateLimitNameLength(List<String> carNameList) {
        carNameList.stream().forEach(carName -> {
            if (carName.length() > LIMIT_NAME_LENGTH) {
                throw new IllegalArgumentException(OVER_LIMIT_NAME_LENGTH);
            }
        });
    }

    private Set<String> validateDuplicateName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME);
        }

        return carNameSet;
    }

    private void validateIsNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }

}
