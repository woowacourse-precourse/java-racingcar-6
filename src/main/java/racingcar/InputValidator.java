package racingcar;

public class InputValidator {
    //정수이며 양수인지를 검증하고 String 타입으로 들어온 입력을 int 타입으로 변경해주는 메서드
    public int parseAndValidateRoundNumber(String input) {
        try {
            int parsedInput = Integer.parseInt(input);
            validateRoundNumber(parsedInput);
            return parsedInput;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 정수이어야 합니다.");
        }
    }


    public void validateRoundNumber(int input) {
        if (input < 1) {
            throw new IllegalArgumentException("이동 횟수는 양수이어야 합니다.");
        }
    }

    //자동차 이름 입력시 이름이 없거나 5자가 초과된 이름을 검증하는 메서드
    public void validateCarNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            String trimmedName = name.trim();
            if (trimmedName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
        }
    }
}
