package racingcar.view;

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
}
