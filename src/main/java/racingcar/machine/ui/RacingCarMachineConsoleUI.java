package racingcar.machine.ui;

import racingcar.machine.car.Car;
import racingcar.machine.car.CarInterface;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarMachineConsoleUI implements RacingCarMachineUI {
    @Override
    public void displayRequestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public List<String> inputCarNames() {
        return Arrays.stream(readLine().split(",")).toList();
    }

    @Override
    public void displayRequestNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    @Override
    public int inputNumberOfAttempts() {
        return Integer.parseInt(readLine());
    }

    @Override
    public void displayRaceResult() {
        System.out.println("실행결과");
    }

    @Override
    public void displayRaceProgress(List<CarInterface> cars) {
        cars.forEach(car -> System.out.println(car.carMoveLength()));
        System.out.println();
    }

    @Override
    public void displayFinalWinner(String winners) {
        System.out.print("최종 우승자 : " + winners);
    }
}
