package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

public class RacingCarService {
    private static final String START_GAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static RacingCars cars = new RacingCars();

    public void exec() {
        createRacingCar();
    }

    private void createRacingCar() {
        System.out.println(START_GAME_MESSAGE);
        String[] input_car = Console.readLine().split(",");
        Arrays.stream(input_car).forEach(e -> cars.add(new RacingCar(e)));
    }
}
