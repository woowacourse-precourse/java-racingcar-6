package racingcar;

public class Exceptions {

    public void isInvalidCarNameLength(String input) {
        if (input.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
    }

    public void isInvalidGapName(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("이름에는 공백이 들어갈 수 없습니다.");
        }
    }

    public void isInvalidNullName(String input) {
        if (input.contains(",,")) {
            throw new IllegalArgumentException("이름은 null이 될 수 없습니다.");
        }
    }

    public void isInvalidStringCount(String input){
        try {
            int intValue = Integer.parseInt(input);
            return;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("횟수는 숫자만 입력 가능합니다.");
        }
    }
}
