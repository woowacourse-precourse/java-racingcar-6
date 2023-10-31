package racingcar.outputView;

import racingcar.util.FixedNumber;

public class Output {
    public static void executeResult() {
        System.out.println(FixedNumber.output);
    }

    public static void winnerResult() {
        System.out.print(FixedNumber.result);
    }

    public static void lineBreaking() {
        System.out.println();
    }
}
