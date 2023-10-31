package racingcar.io;

public final class GameConsoleOutput {

    private GameConsoleOutput() {
    }

    public static void print(String output) {
        System.out.println(output);
    }

    public static void print() {
        System.out.println();
    }
}
