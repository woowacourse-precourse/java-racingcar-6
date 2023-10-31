package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.CarService;

public class Application {

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        String forwardMovementCount = Console.readLine();
        System.out.println();

        CarService carService = new CarService(carNames, forwardMovementCount);
        carService.moveForward();
        carService.finalWinnerCar();

    }

}
