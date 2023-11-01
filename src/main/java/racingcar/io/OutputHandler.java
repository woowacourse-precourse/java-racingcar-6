package racingcar.io;

public class OutputHandler {
    public static void printCarStatus(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printErrorMessage(String message){
        System.err.println(message);
    }
}
