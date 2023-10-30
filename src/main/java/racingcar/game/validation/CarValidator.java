package racingcar.game.validation;

public class CarValidator implements Validator{

    @Override
    public void execute(String name) {
        validateHavingValue(name);
        validateNameLength(name);
        validateSideBlank(name);
    }

    private void validateHavingValue(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차의 이름은 필수값입니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름이 5자 이하가 아닙니다.");
        }
    }

    private void validateSideBlank(String name) {
        if (name.startsWith(" ") || name.endsWith(" ")){
            throw new IllegalArgumentException("자동차 이름의 양 끝에는 공백이 올 수 없습니다.");
        }
    }
}
