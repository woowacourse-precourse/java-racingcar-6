package controller;

import static constant.Exception.DUPLICATED_NAME;
import static constant.Exception.NON_NUMERIC;
import static constant.Exception.OVER_LIMIT_NAME_LENGTH;
import static constant.Message.COMMA;

import dto.RacingStatusDTO;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import service.RacingCarService;

public class RacingCarController {

    private static final int LIMIT_NAME_LENGTH = 5;

    private RacingCarService racingCarService = new RacingCarService();

    public Set<String> extractName(String input) {
        List<String> carNameList = Arrays.asList(input.split(COMMA.getMessage()));
        validateLimitNameLength(carNameList);
        Set<String> carNameSet = validateDuplicateName(carNameList);

        racingCarService.generateRacingCar(carNameSet);
        return carNameSet;
    }

    public List<List<RacingStatusDTO>> racing(String input) {
        validateIsNumeric(input);
        int cycle = changeInputToInt(input);

        return racingCarService.racing(cycle);
    }

    public List<String> showResult() {
        return racingCarService.judgeWinners();
    }

    private int changeInputToInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateLimitNameLength(List<String> carNameList) {
        carNameList.stream().forEach(carName -> {
            if (carName.length() > LIMIT_NAME_LENGTH) {
                throw new IllegalArgumentException(OVER_LIMIT_NAME_LENGTH.getMessage());
            }
        });
    }

    private Set<String> validateDuplicateName(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME.getMessage());
        }

        return carNameSet;
    }

    private void validateIsNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(NON_NUMERIC.getMessage());
            }
        }
    }

}
