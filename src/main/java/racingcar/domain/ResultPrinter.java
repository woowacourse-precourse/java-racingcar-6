package racingcar.domain;

public class ResultPrinter {
    private static String getUserName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String getTry = "시도할 회수는 몇회인가요?";
    private static String winner = "최종 우승자 : ";

    public static void startMessage() {
        System.out.println(getUserName);
    }

    public static void getTryMessage() {
        System.out.println(getTry);
    }
}
