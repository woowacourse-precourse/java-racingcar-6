package racingcar;

import racingcar.car.Car;
import racingcar.player.Player;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/* 객체 지향 프로그래밍
 * 1. 기능을 가지고 있는 클래스를 인스턴스화(=객체)한다.
 * 2. 필요한 기능을 (역할에 맞는) 인스턴스가 수행하게 한다.(의인화)
 * 3. 각 결과를 종합한다.
 * */
public class RacingCarGame {
    private int COUNT = 0;
    private Car car;
    private Player player;

    private OutputView outputView;

    public void run() {
        ready();

        while (COUNT != player.getCount()) {
            playCar();
            COUNT++;
            currentResult();
        }

        System.out.println(outputView.printToResult(car.winnerList()));
    }

    private void ready() {
        InputView inputView = new InputView();
        outputView = new OutputView();
        car = new Car();
        player = new Player();

        inputView.readyToInput(car, player);
    }

    private void playCar() {
        car.driving();
    }

    private void currentResult() {
        if (COUNT == 1) {
            System.out.println("\n실행 결과");
        }
        String result = outputView.resultForMiddle(car.getNames(), car);
        System.out.println(result);
    }
}
