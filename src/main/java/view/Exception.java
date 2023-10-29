package view;

public class Exception {

    private static final String NAME_WARNING = "자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 1자 이상, 5자 이하만 가능합니다.";

    public static void nameVerification(String[] carNames) {

        for (String carName : carNames) {
            checkLength(carName);
        }

    }

    private static void checkLength(String carName) {

        try {
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new IllegalArgumentException(NAME_WARNING);
            }
        } catch (IllegalStateException ignored) {

        }
    }

}
