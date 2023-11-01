package racingcar.view;

public class Output {
    private static final String inputCarsName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String inputAttempt = "시도할 회수는 몇회인가요?";

    public static void inputCarsNamePrint() {
        System.out.println(inputCarsName);
    }

    public static void inputAttemptNumPrint() {
        System.out.println(inputAttempt);
    }
}