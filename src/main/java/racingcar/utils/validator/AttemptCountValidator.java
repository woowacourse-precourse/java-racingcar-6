package racingcar.utils.validator;

public class AttemptCountValidator implements Validator{

    @Override
    public void validate(String context) {
        if (!context.matches("[0-9]+")) {
            throw new IllegalArgumentException("잘못된 입력을 했습니다.");
        }
    }
}
