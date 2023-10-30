package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import racingcar.player.Player;
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

        outputView.printToResult(car.winnerList());
    }

    private void ready() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        car = new Car();
        car.createName(carName); // 경주할 자동차 이름 입력

        System.out.println("시도할 횟수는 몇회인가요?");
        String tryCount = Console.readLine();
        player = new Player();
        player.moveOnInput(tryCount); // 시도할 횟수 입력

        outputView = new OutputView();
    }

    private void playCar() {
        car.driving(car.getNames());
    }

    private void currentResult() {
        if (COUNT == 1) {
            System.out.println("\n실행 결과");
        }
        String result = outputView.resultForMiddle(car.getNames(), car);
        System.out.println(result);
    }
}
