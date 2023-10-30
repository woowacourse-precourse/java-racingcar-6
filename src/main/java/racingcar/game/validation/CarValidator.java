package racingcar.game.validation;

public class CarValidator implements Validator{

    @Override
    public void execute(String name) {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름이 5자 이하가 아닙니다.");
        }
    }
}
