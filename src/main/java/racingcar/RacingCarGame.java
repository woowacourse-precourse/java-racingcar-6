package racingcar;

/*
    게임 진행 클래스
    - 게임 시작 부터 종료까지 별도 클래스들로 진행 되도록 구현
 */
public class RacingCarGame {
    GameController gc = new GameController();

    public void startGame() {
        gc.inputCarName();
        gc.inputTryCount();
        System.out.println("실행 결과");
        gc.carRacing();
        gc.displayWinner();
    }
}
