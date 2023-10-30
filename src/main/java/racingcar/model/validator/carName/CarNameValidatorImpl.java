package racingcar.model.validator.carName;

import static racingcar.util.GameConstants.COUNT_OF_CAR;
import static racingcar.util.GameConstants.MAXIMUM_CAR_NAME_LENGTH;
import static racingcar.util.GameConstants.MINIMUM_CAR_NAME_LENGTH;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidatorImpl implements CarNameValidator{

    @Override
    public void validateCount(String[] inputs) {
        if (inputs.length != COUNT_OF_CAR) {
            throw new IllegalArgumentException(COUNT_OF_CAR + "개의 이름을 입력해주세요.");
        }
    }

    @Override
    public void validateLength(String[] inputs) {
        for (String input : inputs) {
            validateEachLowerLength(input);
            validateEachUpperLength(input);
        }
    }

    private void validateEachLowerLength(String input) {
        if (input.length() < MINIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("길이가 " + MINIMUM_CAR_NAME_LENGTH + " 이상인 이름을 입력해주세요.");
        }
    }

    private void validateEachUpperLength(String input) {
        if (input.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("길이가 " + MAXIMUM_CAR_NAME_LENGTH + " 이하인 이름을 입력해주세요.");
        }
    }

    @Override
    public void validateDuplicate(String[] inputs) {
        Set<String> inputSet = new HashSet<>();
        for (String input : inputs) {
            inputSet.add(input);
        }

        if (inputSet.size() != COUNT_OF_CAR) {
            throw new IllegalArgumentException("중복되지 않은 이름을 입력해주세요.");
        }
    }

    @Override
    public void validateAll(String[] inputs) {
        validateCount(inputs);
        validateLength(inputs);
        validateDuplicate(inputs);
    }
}
