package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class RacingCar {

    private final List<CarState> cars;
    private final int gameTryCount;

    public RacingCar(String carNames, int gameTryCount){
        this.cars = Arrays.stream(carNames.split(",")).map(CarState::new).collect(Collectors.toList());
        this.gameTryCount = gameTryCount;
    }

    public void startGame(){

        Output.printResultmessage();

        for(int i = 0; i <= gameTryCount; i++){
            cars.forEach(CarState::move);
            Output.printRacingState(cars);
        }
        Output.printWinner(cars);

    }

    public static int findMostFartherDistance(List<CarState> cars){
        int mostFartherDistance = 0;

        for(CarState car : cars){
            if(car.getMoveCount() > mostFartherDistance){
                mostFartherDistance = car.getMoveCount();
            }
        }
        return mostFartherDistance;
    }

    private static void addWinnerList(CarState car, int mostFartherDistance, List<String> carName){
        if(car.getMoveCount() == mostFartherDistance){
            carName.add(car.getName());
        }
    }

    public static String getWinnerNames(List<CarState> cars, int mostFartherDistance){
        List<String> names = new ArrayList<>();

        for(CarState car : cars){
            addWinnerList(car, mostFartherDistance, names);
        }
        return String.join(", ",names);
    }


}
