package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;
import racingcar.player.Player;

public class InputView {
    public void readyToInput(Car car, Player player) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        car.createName(carName);

        System.out.println("시도할 횟수는 몇회인가요?");
        String tryCount = Console.readLine();
        player.moveOnInput(tryCount);

        Console.close();
    }
}
