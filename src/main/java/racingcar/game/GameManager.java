package racingcar.game;

import racingcar.Object.Player;

import java.util.List;

public class GameManager {
    Game game;
    Player player = new Player();
    public void start(){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameList = InputManager.parseCarName(player.inputAnswer());

        System.out.println("시도할 회수는 몇회인가요?");
        int turn = InputManager.parseIntTurnAnswer(player.inputAnswer());

        game = new Game(turn,carNameList);

       System.out.println("실행 결과");
        for (int i = 0 ; i < game.getTurn() ; i++){
            game.moveGameCars();
            game.displayGameScore();
            System.out.println();
        }
        game.displayGameWinner();
    }
}
