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
            if (ConstStandard.INVALID_NAMES_INPUT_SEPARATORS.contains(str)) {
                throw new IllegalArgumentException();
            }
        }
    }
    private void validateNameLength(String carsInput) {
        for (String carName : carsInput.split(ConstStandard.CRITERIA_NAMES_INPUT_SEPARATOR)) {
            // 순수 이름값에 대해서만 길이를 재기 위해 String.trim() 을 수행합니다.
            carName = carName.trim();
            if (carName.length() > ConstStandard.CRITERIA_NAME_LENGTH_UPPER_LIMIT) {
                throw new IllegalArgumentException();
            }
            validateBlank(carName);
        }
    }

}
