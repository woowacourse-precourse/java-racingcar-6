package racingcar;

import racingcar.domain.Input;
import racingcar.domain.Output;
import racingcar.domain.Calculate;

import java.util.HashMap;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Input input = new Input();
        Output output = new Output();
        Calculate cal = new Calculate();

        String carNames = input.getCarName();
        int gameCount = input.getCountYouWantTry();
        HashMap<String,Integer> racers = cal.MappingNameAndCar(carNames);
        for(int i=0; i< gameCount; i++){
            racers = cal.setCarPosition(racers);
            output.printCarPosition(racers);
            System.out.println();
        }
        output.printFinalWinner(racers);
    }
}
