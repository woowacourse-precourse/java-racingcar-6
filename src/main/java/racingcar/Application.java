package racingcar;

import racingcar.Controller.Racing;
import racingcar.Controller.RacingWinner;
import racingcar.View.PlayNumberInput;
import racingcar.View.CarNameInput;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayNumberInput playNumberInput = new PlayNumberInput();
        CarNameInput playerNameInput = new CarNameInput();


        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> players = playerNameInput.playerList();

        System.out.println("시도할 회수는 몇회인가요?");
        int repeatTime = playNumberInput.playNumber();
        System.out.println();
        System.out.println("실행 결과");

        Racing racing = new Racing();
        RacingWinner racingWinner = new RacingWinner();
        //실제 게임 수행 부분.
        Map<String, String> racingResult = racing.saveRaceGame(repeatTime, players);
        //결과 출력.
        racingWinner.printRaceWinner(racingResult, racingWinner.findWinner(racingResult));

    }
}
