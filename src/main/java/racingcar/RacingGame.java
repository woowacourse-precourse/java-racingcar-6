package racingcar;

public class RacingGame {

    private static final int MIN_NAME_SIZE = 1;
    private static final int MAX_NAME_SIZE = 5;

    private static final String startingPhrase = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String attemptingPhrase = "시도할 회수는 몇회인가요?";
    private static final String resultPhrase = "실행 결과";
    private static final String winnerPhrase = "최종 우승자 : ";

    public void startGame() {
        System.out.println(startingPhrase);
    }
}
