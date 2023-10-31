package racingcar;

import racingcar.model.Game;

public class GameController {
    Game game;
    GameView gameView;

    public GameController() {
        this.game = new Game();
        this.gameView = new GameView();
    }

    public void init() {
        game.addCars(gameView.inputNameOfCars());
        game.setNumberOfAttempts(gameView.inputNumberOfAttempts());
    }

    public void play() {
        gameView.printResult(); // "실행 결과" 출력
        int numberOfAttempts = game.getNumberOfAttempts();
        // 시도 횟수만큼 돌면서
        for (int i = 0; i < numberOfAttempts; i++) {
            game.startRound();                  // 한 라운드 수행
            gameView.printResultOfRound(game);  // 결과 출력
        }
    }

    public void finish() {
        game.findWinners();
        gameView.printWinners(game);
    }

    public void start() {
        init();
        play();
        finish();
    }

}
