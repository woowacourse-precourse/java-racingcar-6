package racingcar.view;

import java.util.List;

public class Output {
    public static void printRaceStart(){
        System.out.println("\n실행 결과");
    }
    public static void printCarResult(String carName, int moveLength){
        System.out.println(carName + " : " + "-".repeat(moveLength));
    }

    public static void roundFinish() {
        System.out.println();
    }

    public static void printRaceResult(List<String> carNames){
        System.out.println("최종 우승자 : " + String.join(", ", carNames));
    }
}
