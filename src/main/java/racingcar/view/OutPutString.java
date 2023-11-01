package racingcar.view;

public class OutPutString {

    private static final String GuessNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GuessCountMessage = "시도할 횟수는 몇회인가요?";
    private static final String ResultMessage = "실행 결과";
    private static final String WinnerMessage = "최종 우승자 : ";
    private static final String MoveMessage = "-";

    public static void printGuessName() {
        System.out.println(GuessNameMessage); // 이름입력요구
    }

    public static void printGuessCount() {
        System.out.println(GuessCountMessage); // 횟수입력요구
    }

    public static void printResult() {
        System.out.println(ResultMessage); // 경주결과
    }

    public static void printStatus(String carName, int position) {
        System.out.println(carName + " : " + MoveMessage.repeat(position)); // 현재 round
    }

    public static void printWinner(StringBuilder winnerList) {
        System.out.println(WinnerMessage + winnerList); // WinnerList 추출
    }
}
