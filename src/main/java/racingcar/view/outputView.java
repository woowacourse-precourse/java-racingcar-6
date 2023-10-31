package racingcar.view;

import java.util.List;

public class outputView {

    public static void printRacingResult(List<String> carNames, int round){
        System.out.println("\n실행 결과");

        for(int i = 0; i < round; i++){
            printRoundState(carNames);
        }
    }

    private static void printRoundState(List<String> carNames){
        for(String carName : carNames){
            System.out.print(carName + " : ");
            System.out.println("--전진횟수");
        }
        System.out.println();
    }
}
