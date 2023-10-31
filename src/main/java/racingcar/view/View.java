package racingcar.view;

public class View {

    public static void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printEnterAttemptCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printGameProcess(String gameLog) {
        System.out.println("\n실행 결과");
        System.out.println(gameLog);
    }

    public static void printGameResult(String result) {
        System.out.println("최종 우승자 : " + result);
    }
}
