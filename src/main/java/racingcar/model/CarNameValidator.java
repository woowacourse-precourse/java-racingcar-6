package racingcar.model;

import java.util.List;

public class CarNameValidator {
    private static final String INPUT_HAS_SPACE = "입력 값에 스페이스 값이 존재합니다.";
    private static final String INPUT_HAS_ZERO_LENGTH = "입력 값에 길이가 0인 자동차가 존재합니다.";
    private static final String INPUT_HAS_OVER_FIVE_LENGTH = "입력 값에 길이가 5가 넘는 자동차가 존재합니다.";
    private static final String INPUT_HAS_DUPLICATED_NAME = "입력 값에 중복 값이 존재합니다.";
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final int ZERO_LENGTH = 0;
    private List<String> carName;

    public List<String> validateCarName(String carNames){
        if(hasSpace(carNames)){
            throw new IllegalArgumentException(INPUT_HAS_SPACE);
        }
        carName = convertCarName(carNames);
        return carName;
    }

    private List<String> convertCarName(String carNames){
        return List.of(carNames.split(COMMA));
    }

    private static boolean hasSpace(String carNames){
        return carNames.contains(SPACE);
    }

    private static boolean hasZeroLength(List<String> carNames){
        return carNames.stream()
                .anyMatch(car -> car.length() == ZERO_LENGTH);
    }
}
