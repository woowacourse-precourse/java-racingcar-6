package racingcar.view;

public class Message {

    public static void printLineBreak() {
        System.out.println();
    }

    public static void printAskCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printInputCarName(String carName) {
        System.out.print(carName + " : ");
    }

    public static void printCarPosition(String carPosition) {
        System.out.println(carPosition);
    }

    public static void printWinnerGuidance() {
        System.out.print("최종 우승자 : ");
    }

    public static void printResultGuidance() {
        System.out.println("실행 결과");
    }

    public static void printWinnerNames(String winnerStr) {
        System.out.println(winnerStr);
    }
}
