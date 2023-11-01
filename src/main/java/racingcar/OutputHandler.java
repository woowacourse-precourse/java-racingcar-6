package racingcar;

public class OutputHandler {
    public static void printMessage(String message){
        System.out.println(message);
    }
    public static void printCarStatus(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }

    public static void printErrorMessage(String message){
        System.err.println(message);
    }
}
