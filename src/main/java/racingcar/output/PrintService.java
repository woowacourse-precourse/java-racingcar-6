package racingcar.output;

public class PrintService {
    public static void inputCarNameRequest() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void askAttemtCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void show(String carName, int straightCount) {
        System.out.printf("%s : %s\n",carName,"-".repeat(straightCount));
    }
}
