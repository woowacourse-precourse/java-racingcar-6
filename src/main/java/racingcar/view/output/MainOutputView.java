package racingcar.view.output;

import java.util.List;
import racingcar.dto.CarDto;

public class MainOutputView {
    private MainOutputView() {
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printReadCarNamesScript() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printReadPlayCountScript() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printWinningCars(List<CarDto> carDtos) {
        WinningCarsOutput winningCarsOutput = WinningCarsOutput.from(carDtos);
        System.out.println(winningCarsOutput.output());
    }
}
