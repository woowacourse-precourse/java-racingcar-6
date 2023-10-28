package racingcar;

import racingcar.model.GameResult;

public class View {
    private static final String DISTANCE_FORMATTER = "-";

    public static void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void inputGameTime() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void outputEmptyLine() {
        System.out.println();
    }

    public static void ouputBeforeGameResult() {
        System.out.println("실행결과");
    }

    public static void ouputGameResult(GameResult gameResult) {
        System.out.printf("%s : %s", gameResult.getName(), formDistance(gameResult.getPosition()));
    }

    public static void ouputGameWinner(String winners) {
        
    }

    private static String formDistance(int distance) {
        return DISTANCE_FORMATTER.repeat(distance);
    }
}
