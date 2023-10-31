package racingcar;

public class Validator {
    void validateGivenCarNames(String carNames) {
        String[] names = carNames.split(",");
        if (names.length == 1 && names[0].isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

    }

    void validateCount(String count) {
        try {
            int parsed = Integer.parseInt(count);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
