package racingcar;

import static racingcar.Constants.REQUEST_CAR_NAME;
import static racingcar.Constants.REQUEST_NUM_OF_TRIALS;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingcarGame {
    private int trials;
    public RacingcarGame(){

    }
    public void start(){
        Cars racingCars = registerCars();
        registerNumOfTrials();

    }


    private void registerNumOfTrials() {
        System.out.println(REQUEST_NUM_OF_TRIALS);
        this.trials = Integer.parseInt(Console.readLine());
    }

    private Cars registerCars() {
        System.out.println(REQUEST_CAR_NAME);
        String inputValue = Console.readLine();
        List<Car> cars = Arrays.stream(inputValue.split(","))
                .map(Car::new)
                .toList();
        Cars racingCars = new Cars(cars);
        return racingCars;
    }


}
