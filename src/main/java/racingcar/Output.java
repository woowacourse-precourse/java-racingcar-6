package racingcar;

public class Output {
    public static void startMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static void roundMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult(int j, String[][] gameArray) {
        String array[][] = gameArray;
        System.out.println(gameArray[j][0] + ": ");
    }

    public static void printWinner(){

    }


}
