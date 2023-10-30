package racingcar.view;

public class Output {
    public static void carStatusMessage(String name, int moveStatus) {
        System.out.println(name + " : " + "-".repeat(moveStatus));
    }

    public static void winnerMessage(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
