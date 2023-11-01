package racingcar;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Cars cars = new Cars();

        Controller controller = new Controller();

        // 기능 1. 사용자의 입력을 받는다
        controller.readyRace();

        // 기능 2. 레이싱 게임을 진행한다.
        controller.startRace();

        // 기능 3. 최종 우승자를 결정한다.
        controller.prizeWinner();
    }
}
