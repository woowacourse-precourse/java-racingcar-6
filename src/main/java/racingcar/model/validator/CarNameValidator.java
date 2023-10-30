package racingcar.model.validator;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {

    public String[] changeArrayType (String input) throws IllegalArgumentException {
        if(input.charAt(input.length() - 1) == ',' || input.charAt(0) == ',') {
            throw new IllegalArgumentException("에러! 최소 한 글자 이상은 입력해야 합니다.");
        }
        String[] result = input.split(",");
        checkDuplicateElements(result);
        return result;
    }

    private void checkDuplicateElements(String[] array) throws IllegalArgumentException {
        Set<String> uniqueElements = new HashSet<>();
        for (String element : array) {
            if (!uniqueElements.add(element)) {
                throw new IllegalArgumentException("에러! 자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    public void checkNameValidation(String[] input) throws IllegalArgumentException {
        for (String name : input) {
            verifyNameValidation(name);
        }
    }

    public void verifyNameValidation(String value) throws IllegalArgumentException {
        if (value.contains(" ")) {
            throw new IllegalArgumentException("에러! 공백 대신 언더스코어('_') 등의 기호를 활용해주세요.");
        }
        if (value.isEmpty()) {
            throw new IllegalArgumentException("에러! 최소 한 글자 이상은 입력해야 합니다.");
        }
        if(value.length() > 5) {
            throw new IllegalArgumentException("에러! 최대 다섯 글자까지만 입력해야 합니다.");
        }
    }
}
