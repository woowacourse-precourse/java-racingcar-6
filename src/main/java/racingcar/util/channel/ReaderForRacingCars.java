package racingcar.util.channel;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.constant.ConstStandard;

public class ReaderForRacingCars extends Reader {
    private static final String SPLIT_SEPARATOR = "";
    public ReaderForRacingCars() {
        super();
    }
    @Override
    public String read() {
        String carsInput = Console.readLine().trim();
        validateBlank(carsInput);
        validateSeparator(carsInput);
        validateNameLength(carsInput);
        return carsInput;
    }

    private void validateSeparator(String carsInput) {
        for (String str : carsInput.split(SPLIT_SEPARATOR)) {
            if (ConstStandard.INVALID_SEPARATES.contains(str)) {
                throw new IllegalArgumentException();
            }
        }
    }
    private void validateNameLength(String carsInput) {
        for (String carName : carsInput.split(ConstStandard.CRITERIA_SEPARATE)) {
            if (carName.trim().length() > ConstStandard.CRITERIA_NAME_UPPER_LIMIT) {
                throw new IllegalArgumentException();
            }
        }
    }

}
