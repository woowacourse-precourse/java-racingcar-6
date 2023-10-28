package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {

    private static final String NAME_VIEW = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String TIME_VIEW = "시도할 회수는 몇회인가요?";

    private static final String RESULT_HEADER_VIEW = "실행 결과";

    private static final String WINNER_VIEW = "최종 우승자 : ";

    private static final String CAR_NAME_DELIMITER = ",";

    public static List<String> renderAndReadName() {
        System.out.println(NAME_VIEW);
        return List.of(Console.readLine().trim().split(CAR_NAME_DELIMITER));
    }

    public static int renderAndReadTime() {
        System.out.println(TIME_VIEW);
        return Integer.parseInt(Console.readLine().trim());
    }

    public static void renderResultHeader() {
        System.out.println(RESULT_HEADER_VIEW);
    }

    public static void renderResult(final List<String> results) {
        results.forEach(System.out::println);
        System.out.println();
    }

    public static void renderWinner(final String winner) {
        System.out.println(WINNER_VIEW + winner);
    }

}
