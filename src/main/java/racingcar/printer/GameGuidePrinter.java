package racingcar.printer;

public class GameGuidePrinter {
    private static final String carNameInputMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String tryCountMessage = "시도할 회수는 몇회인가요?";
    private static final String resultMessage = "실행 결과";
    private static final String finalWinnerMessage = "최종 우승자 : ";

    public String getCarNameInputMessage() {
        return carNameInputMessage;
    }

    public String getTryCountMessage() {
        return tryCountMessage;
    }
}
