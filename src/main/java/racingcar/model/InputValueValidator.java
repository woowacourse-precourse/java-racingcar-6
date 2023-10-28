package racingcar.model;

public class InputValueValidator {

    // 자동차 입력값을 배열로 변환
    public String[] changeArrayType (String input) {
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
        if (value.isBlank()) {
            throw new IllegalArgumentException("에러! 띄어쓰기는 언더스코어('_')를 활용해주세요.");
        }
        if (value.isEmpty() || value.contains(",")) {
            throw new IllegalArgumentException("에러! 공백이나 쉼표를 입력할 수 없습니다.");
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
