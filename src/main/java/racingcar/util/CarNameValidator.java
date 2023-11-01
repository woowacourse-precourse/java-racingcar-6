package racingcar.util;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarNameValidator extends Validator {
    private static final Pattern VALID_CAR_NAME_REGEXP = Pattern.compile("[a-zA-Z가-힣0-9]+");
    private static final String NAME_SEPARATOR = ",";
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void validate(String inputCarNames) {
        validateEmptyInput(inputCarNames);
        String[] carNames = validateSeparator(inputCarNames);
        validateCarNumber(carNames);
        validateOverNameLength(carNames);
        validateDupleCarName(carNames);
    }

    /***
     * 구분자가 쉼표인지 체크하는 메서드
     */
    private String[] validateSeparator(String inputCarNames) {
        if (!isValidCarNameSeparator(inputCarNames)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_COMMA_ERROR.getErrorMessage());
        }
        return inputCarNames.split(NAME_SEPARATOR);
    }

    private boolean isValidCarNameSeparator(String inputCarNames) {
        return Arrays.stream(inputCarNames.split(NAME_SEPARATOR))
                .allMatch(this::isValidCarName);
    }

    private boolean isValidCarName(String carName) {
        Matcher matcher = VALID_CAR_NAME_REGEXP.matcher(carName);
        return matcher.matches();
    }

    /***
     * 차 이름을 하나만 입력했는지 확인하는 메서드
     */
    private void validateCarNumber(String[] carNames) {
        if (carNames.length == 1) throw new IllegalArgumentException(ErrorMessage.CAR_NUM_ERROR.getErrorMessage());
    }

    /***
     * 차 이름중에 5글자 초과한게 있는지 확인하는 메서드
     */
    private void validateOverNameLength(String[] carNames) {
        if (!isNameOverLength(carNames))
            throw new IllegalArgumentException(ErrorMessage.OVER_LENGTH_ERROR.getErrorMessage());
    }

    private boolean isNameOverLength(String[] carNames) {
        return Arrays.stream(carNames).allMatch(name -> name.length() <= MAX_NAME_LENGTH);
    }

    /***
     * 차 이름중에 중복된 이름이 있는지 확인하는 메서드
     */
    private void validateDupleCarName(String[] carNames) {
        Set<String> uniqueCarNameSet = Arrays.stream(carNames).collect(Collectors.toSet());

        if(carNames.length != uniqueCarNameSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLE_CAR_NAME_ERROR.getErrorMessage());
        }
    }
}
