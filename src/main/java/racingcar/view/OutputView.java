package racingcar.view;

import java.util.stream.IntStream;

public class OutputView {
    private static final String RESULT_MESSAGE ="실행 결과";
    private static final String HYPHEN ="-";

    public void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void printMoveRacingCar(String name, int number){
        System.out.print(name + " : ");
        IntStream.range(0,number).forEach(num -> {
            System.out.print(HYPHEN);
        }
        );
        System.out.println();

    }
}
