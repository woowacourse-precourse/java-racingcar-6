package racingcar;

public class RacingGame {

    private static final String REQUIRE_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUIRE_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private Player player = new Player();

    public void GameStart(){
        printMessage(REQUIRE_CAR_NAME_MESSAGE);
        player.setCarName();
        printMessage(REQUIRE_ATTEMPT_NUMBER_MESSAGE);
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
