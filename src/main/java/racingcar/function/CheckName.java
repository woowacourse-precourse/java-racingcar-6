package racingcar.function;

public class CheckName {
    public static void validate(String inputNames) {
        if (inputNames == null || inputNames.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }

        String[] names = inputNames.split(",");
        for (String name : names) {
            validateSingleName(name);
        }
    }

    private static void validateSingleName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름을 4글자 이내로 입력해 주세요: " + name);
        }

        if (!name.matches("[a-z]+")) {
            throw new IllegalArgumentException("영어로 입력해 주세요: " + name);
        }
    }
}