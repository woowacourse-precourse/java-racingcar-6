package racingcar.Validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarNameInputValidator {
    private final String ASK_MORE_THAN_TWO = "2개 이상의 차 이름을 입력하세요";
    private final String ASK_NO_VOID_NAME = "빈 칸은 입력할 수 없습니다. 쉼표 앞뒤에 이름을 반드시 적어주세요";
    private final String ASK_NO_DUPLICATION = "중복된 이름을 입력 불가합니다";
    private final String ASK_VALID_NAME_LENGTH = "차 이름은 5자 이하로 입력해주세요";
    private final String ASK_ONLY_CHARACTER_INPUT = "쉼표로 구분된 차 이름은 문자(알파벳, 한극)로만 입력 가능합니다";
    private final String ASK_ONE_SPACE_BETWEEN_CHAR = "문자와 문자 사이이 공백은 한 칸까지만 가능합니다";
    private final String ASK_NO_SPACE_IN_START_OR_END_POSITION = "이름의 앞 뒤에 공백 없이 쉼표(,)로 구분해서 입력해주세요";

    private String VOID_NAME = "";
    private int MINIMUM_PARTICIPANT = 2;
    private int MAXIMUM_NAME_LENGTH = 5;

    public void validate(String carNameInput) {
        List<String> carNameInputList = Arrays.asList(carNameInput.split(","));
        areNamesMoreThanTwo(carNameInputList);
        isVoidNameIncluded(carNameInputList);
        isNameStartOrEndWithSpace(carNameInputList);
        isNameOnlyWithChar(carNameInputList);
        isNameWithConSequenceSpaces(carNameInputList);
        isNameLengthBelowFive(carNameInputList);
        isNameNotDuplicated(carNameInputList);
    }

    public void areNamesMoreThanTwo(List<String> carNameInputList) throws IllegalArgumentException {
        if (carNameInputList.size() < MINIMUM_PARTICIPANT) {
            throw new IllegalArgumentException(ASK_MORE_THAN_TWO);
        }
    }

    public void isVoidNameIncluded(List<String> carNameInputList) throws IllegalArgumentException {
        for (String carName : carNameInputList) {
            if (carName.equals(VOID_NAME)) {
                throw new IllegalArgumentException(ASK_NO_VOID_NAME);
            }
        }
    }

    public void isNameLengthBelowFive(List<String> carNameInputList) throws IllegalArgumentException {
        for (String carName : carNameInputList) {
            if (carName.length() > MAXIMUM_NAME_LENGTH) {
                throw new IllegalArgumentException(ASK_VALID_NAME_LENGTH);
            }
        }
    }

    public void isNameOnlyWithChar(List<String> carNameInputList) throws IllegalArgumentException {
        for (String carName : carNameInputList) {
            if (carName.matches("^[a-zA-Z가-힣 ]*$")) {
                return;
            }
            throw new IllegalArgumentException(ASK_ONLY_CHARACTER_INPUT);
        }
    }

    public void isNameStartOrEndWithSpace(List<String> carNameInputList) throws IllegalArgumentException {
        for (String carName : carNameInputList) {
            if (carName.startsWith(" ") || carName.endsWith(" ")) {
                throw new IllegalArgumentException(ASK_NO_SPACE_IN_START_OR_END_POSITION);
            }
        }
    }

    public void isNameWithConSequenceSpaces(List<String> carNameInputList) throws IllegalArgumentException {
        for (String carName : carNameInputList) {
            if (carName.matches("^(?!.*  )[\\s\\S]*$")) {
                return;
            }
            throw new IllegalArgumentException(ASK_ONE_SPACE_BETWEEN_CHAR);
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
