package racingcar.model.validator.carName;

import static racingcar.util.GameConstants.MAXIMUM_CAR_NAME_LENGTH;
import static racingcar.util.GameConstants.MINIMUM_CAR_NAME_LENGTH;

import java.util.HashSet;
import java.util.Set;

/**
 * {@code CarNameValidator}의 구현부이다.
 * 정해진 규칙에 따라 자동차의 이름을 검증한다.
 */
public class CarNameValidatorImpl implements CarNameValidator{

    @Override
    public void validateSyntax(String[] carNamesFromUsers) {
        for (String carNameFromUser : carNamesFromUsers) {
            validateEachSyntax(carNameFromUser);
        }
    }

    private void validateEachSyntax(String carNamesFromUsers) {
        if (carNamesFromUsers.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열을 입력하지 마세요.");
        }
    }

    @Override
    public void validateLength(String[] carNamesFromUsers) {
        for (String carNameFromUser : carNamesFromUsers) {
            validateEachLowerLength(carNameFromUser);
            validateEachUpperLength(carNameFromUser);
        }
    }

    private void validateEachLowerLength(String carNameFromUser) {
        if (carNameFromUser.length() < MINIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("길이가 " + MINIMUM_CAR_NAME_LENGTH + " 이상인 이름을 입력해주세요.");
        }
    }

    private void validateEachUpperLength(String carNameFromUser) {
        if (carNameFromUser.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("길이가 " + MAXIMUM_CAR_NAME_LENGTH + " 이하인 이름을 입력해주세요.");
        }
    }

    @Override
    public void validateDuplicate(String[] carNamesFromUsers) {
        Set<String> convertToSet = new HashSet<>();
        for (String carNameFromUser : carNamesFromUsers) {
            convertToSet.add(carNameFromUser);
        }

        if (convertToSet.size() != carNamesFromUsers.length) {
            throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요.");
        }
    }

    @Override
    public void validateAll(String[] inputs) {
        validateSyntax(inputs);
        validateLength(inputs);
        validateDuplicate(inputs);
    }
}
