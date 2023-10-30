package racingcar.util.message;

public class Printer {
    public static void inputNameQuestion() {
        System.out.println(Message.CHOOSE_CARS_NAME);
    }
    public static void inputTimeQuestion() {
        System.out.println(Message.CHOOSE_TIME_TO_RACE);
    }
    public static void raceResult() {
        System.out.println(Message.PlAY_RESULT);
    }
    public static void finalWinner() {
        System.out.print(Message.FINAL_WINNER);
    }
    public static void positionDash() {
        System.out.print(Message.POSITION_DASH);
    }

    public static void carName(String name) {
        System.out.printf("%s : ", name);
    }
    public static void comma(){
        System.out.print(Message.COMMA);
    }
    public static void switchLine() {
        System.out.println();
    }
    public static void nowWinner(String winner) {
        System.out.print(winner);
    }
}
