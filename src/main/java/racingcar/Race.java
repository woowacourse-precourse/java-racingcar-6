package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.core.Core;
import racingcar.model.Car;
import racingcar.utils.Utils;

import java.util.List;

public class Race {
    Core core = new Core();

    public void run() {
        List<String> carNames = getCarNames();
        int count = core.getCount();
        List<Car> cars = core.getCarListByCarNames(carNames);
        showResult(cars, count);
        printWinner(core.getWinner(cars));
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        List<String> carNames = core.stringToStringList(carName);
        Utils.validateCarNameLength(carNames);
        return carNames;
    }

    public void showResult(List<Car> cars, int count) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            core.forwardOrStop(cars);
            core.printResult(cars);
        }
    }

    public void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}