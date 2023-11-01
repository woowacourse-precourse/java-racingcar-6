package racingcar;

public class MessageType {
    public static void printLineBreak() {
        System.out.println();
    }

    public static void printAskCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printCarLocation(String carLocation) {
        System.out.println(carLocation);
    }

    public static void printInputCarName(String carName) {
        System.out.print(carName + " : ");
    }

    public static void printWinner() {
        System.out.print("최종 우승자 : ");
    }

    public static void printResult() {
        System.out.println("\n실행 결과");
    }

    public static void printWinnerNames(String winnerStr) {
        System.out.println(winnerStr);
    }
}
