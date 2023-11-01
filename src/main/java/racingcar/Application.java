package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Game;
import racingcar.view.GameView;
import racingcar.view.RepeatingGameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public void init(Class<? extends Game> gameClass, Class<? extends GameView> viewClass,
                     Class<? extends GameController> controllerClass, String messagePath) {
        Game game;
        GameView gameView;
        GameController gameController;

        try {
            game = gameClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("게임 인스턴스 생성 오류", e);
        }

        try {
            gameView = viewClass.getDeclaredConstructor(String.class).newInstance(messagePath);
        } catch (Exception e) {
            throw new IllegalArgumentException("게임 뷰 인스턴스 생성 오류", e);
        }

        try {
            gameController = controllerClass.getDeclaredConstructor(Game.class, RepeatingGameView.class)
                    .newInstance(game, gameView);
        } catch (Exception e) {
            throw new IllegalArgumentException("게임 컨트롤러 인스턴스 생성 오류", e);
        }

        gameController.play();
    }
}
