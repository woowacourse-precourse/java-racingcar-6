package racingcar.view;

import static racingcar.constant.InfoMessage.*;

public class Printer {

    public static void printLineBreak() {
        System.out.println();
    }

    public static void printCarChoiceMessage() {
        System.out.println(CAR_CHOICE);
    }

    public static void printRoundChoiceMessage() {
        System.out.println(ROUND_CHOICE);
    }

    public static void printResultHeadMessage() {
        System.out.println(RESULT_HEAD);
    }

    public static void printResultMessage(String carName, String dashPosition) {
        System.out.printf("%s : %s\n", carName, dashPosition);
    }

    public static void printWinnerHeadMessage() {
        System.out.printf(WINNER_MESSAGE + " : ");
    }

    public static void printWinnerMessage(String carName) {
        System.out.print(carName + ", ");
    }

    public static void printLastWinnerMessage(String carName) {
        System.out.println(carName);
    }

}
