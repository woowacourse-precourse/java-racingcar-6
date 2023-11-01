package racingcar;

public class Exception {
    private enum Message {
        INVALID_CAR_COUNT("쉼표로 구분된 자동차 이름이 최소 2개 이상이어야 합니다."),
        INVAILD_NAME_LENGTH("자동차 이름은 1글자 이상, 5글자 이하이어야 합니다."),
        NOT_UNIQUE_CAR("중복된 자동차 이름이 있습니다."),
        ;

        private final String label;

        Message(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }

    public static void invalidCarCount()
    {
        throw new IllegalArgumentException(Message.INVALID_CAR_COUNT.label());
    }

    public static void invaildNameLength()
    {
        throw new IllegalArgumentException(Message.INVAILD_NAME_LENGTH.label());
    }

    public static void notUniqueCar()
    {
        throw new IllegalArgumentException(Message.NOT_UNIQUE_CAR.label());
    }
}
