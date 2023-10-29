package racingcar;

public class RacingGame {

    private static final String REQUIRE_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public void GameStart(){
        printMessage(REQUIRE_CAR_NAME_MESSAGE);
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
