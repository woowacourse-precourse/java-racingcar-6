package racingcar.input;

public class Input {
    private static void print(InputMessage message) {
        System.out.println(message.getMessage());
    }
    public static void printEnterCarNames() {
        print(InputMessage.ENTER_CAR_NAMES);
    }

    public static void printEnterRound() {
        print(InputMessage.ENTER_ROUND);
    }
}
