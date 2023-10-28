package racingcar;

public class Application {

    public static void main(String[] args) {
        GameUI gameUI = new GameUI();
        Cars cars = new Cars();
        Game game = new Game(cars);

        // 이름 입력 문구를 받는다.
        gameUI.requestNames();
        cars.settingNames();

        // 횟수 입력 문구를 받는다.
        gameUI.requestTryNumber();
        game.settingChance();

        // 게임을 진행시킨다.
        game.running();
    }
}
