package racingcar.util;

public class BlankValidator {
    private static final String PLESASE_INPUT_ANY_WORLD = "내용을 입력해주세요";

    public void isEmpty(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(PLESASE_INPUT_ANY_WORLD);
        }
    }
}
