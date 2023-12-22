package racingcar.view;

public class OutputView {
    public static void printProgress(String output) {
        System.out.println("실행 결과");
        System.out.println(output);
    }

    public static void printResult(String output) {
        System.out.println("최종 우승자 : " + output);
    }
}
