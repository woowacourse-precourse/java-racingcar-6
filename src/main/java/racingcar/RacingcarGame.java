package racingcar;

import static racingcar.Constants.REQUEST_CAR_NAME;
import static racingcar.Constants.REQUEST_NUM_OF_TRIALS;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingcarGame {
    private Cars racingCars;
    private int rounds;
    public void execute(){
        start();
        play();
        end();
    }
    private void start(){
        this.racingCars = registerCars();
        this.rounds = registerRounds();
    }
    private void play(){
        for(int i=0;i<rounds;i++){
            racingCars.playRound();
        }
    }

    private void end(){

    }
    private int registerRounds() {
        System.out.println(REQUEST_NUM_OF_TRIALS);
        return Integer.parseInt(Console.readLine());
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
