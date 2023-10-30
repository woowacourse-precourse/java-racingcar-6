package racingcar.Validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarNameInputValidator {
    private final String ASK_MORE_THAN_TWO = "2개 이상의 차 이름을 입력하세요";
    private final String ASK_NO_DUPLICATION = "중복된 이름을 입력 불가합니다";
    private final String ASK_VALID_NAME_LENGTH = "차 이름은 5자 이하로 입력해주세요";

    private int MINIMUM_PARTICIPANT = 2;
    private int MAXIMUM_NAME_LENGTH = 5;



    public void validate(String carNameInput) {
        List<String> carNameInputList = Arrays.asList(carNameInput.split(","))
        areNamesMoreThanTwo(carNameInputList);
        isNameLengthBelowFive(carNameInputList);
        isNameNotDuplicated(carNameInputList);
    }

    public void areNamesMoreThanTwo(List<String> carNameInputList) throws IllegalArgumentException {
        if (carNameInputList.size() < MINIMUM_PARTICIPANT) {
            throw new IllegalArgumentException(ASK_MORE_THAN_TWO);
        }
    }

    public void isNameLengthBelowFive(List<String> carNameInputList) throws IllegalArgumentException {
        for (String carName : carNameInputList) {
            if (carName.length() > MAXIMUM_NAME_LENGTH) {
                throw new IllegalArgumentException(ASK_VALID_NAME_LENGTH);
            }
        }
    }

    public void isNameNotDuplicated(List<String> carNameInputList) throws IllegalArgumentException {
        HashSet<String> carNameSet = new HashSet<String>();
        carNameSet.addAll(carNameInputList);

        if (carNameSet.size() != carNameInputList.size()) {
            throw new IllegalArgumentException(ASK_NO_DUPLICATION);
        }
    }

}
