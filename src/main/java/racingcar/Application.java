package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // 1. 입력값이 숫자, 영문, 쉼표로만 구성되어있는지 확인한다
        CarValidator.validateNameUsingCommas(input);
        List<String> carNameList = List.of(input.split(","));

        // 2. 이름이 5글자 이하인지 확인해서 participantCars 에 포함시킨다
        List<Car> participantCars = new ArrayList<>();
        for (String carName : carNameList) {
            CarValidator.validateNameLength(carName);

            Car car = new Car(carName);
            participantCars.add(car);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String tryCount = Console.readLine();
        int intTryCount = Integer.parseInt(tryCount);
        RacingCountValidator.validateRacingCount(tryCount);

        Game game = new Game(participantCars, intTryCount);
        game.playGame();
    }
}
