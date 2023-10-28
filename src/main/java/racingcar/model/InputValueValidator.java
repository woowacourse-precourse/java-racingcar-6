package racingcar.model;

public class InputValueValidator {

    // 자동차 입력값을 배열로 변환
    // WARNING : 입력값의 마지막 인덱스가 쉼표면 거르지 못함
    public String[] changeArrayType (String input) throws IllegalArgumentException {
        if(input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException("에러! 최소 한 글자 이상은 입력해야 합니다.");
        }
        String[] result = input.split(",");
        return result;
    }

    // 자동차 이름 입력값 검증(쉼표 제외한 영어. 한글, 숫자, 기호 전부 가능케)
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

    // 이동 횟수 입력값 검증
    public void checkMovementCount(String value) throws IllegalArgumentException {
        try {
            int intValue = Integer.parseInt(value);
            if (intValue <= 0) {
                throw new IllegalArgumentException("에러! 이동 횟수는 1 이상의 정수만 입력해야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("에러! 이동 횟수는 정수만 입력해야 합니다.");
        }
    }
}
