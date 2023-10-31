package racingcar;

public class Util {
    public static void print(MessageType messageType) {
        System.out.println(messageType.getDetail());
    }

    public static void print(MessageType messageType, String addition) {
        System.out.println(messageType.getDetail() + addition);
    }
}
