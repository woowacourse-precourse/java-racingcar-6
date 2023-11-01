package racingcar.view;
import camp.nextstep.edu.missionutils.Console;

public class View {
    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public static int getRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("양의 정수값만 입력해주세요.");
        }
    }

    public static void displayResults(String result) {
        System.out.println(result);
    }

    public static void displayWinners(String winners) {
        System.out.println("\n최종 우승자 : " + winners);
    }
}
