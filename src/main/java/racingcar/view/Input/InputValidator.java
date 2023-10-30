package racingcar.view.Input;

public class InputValidator {

        // [x] 쉼표가 연속해서 있을 경우 >> 정규 표현식 split(",+")
        // [x] 쉼표 사이에 공백이 있을 경우 >> replace(" ", "");
        // [x] 공백일 경우 >> exception
        // [ ] 5대 초과일 경우
    public void validateCarString(String input) {
        if (input.trim() == null) {
            throw new IllegalArgumentException("");
        }
    }
}
