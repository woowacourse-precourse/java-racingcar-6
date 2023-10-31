package racingcar.racingmanager;


import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.global.message.GameProgressMessage;
import racingcar.view.PrintRaceResult;

import java.util.ArrayList;
import java.util.List;

public class StartGame {

    private static final int MOVING_FORWARD = 4;

    private final Race race;
    private final HandleNumber handleNumber;
    private final PrintRaceResult printRaceResult;

    public StartGame(Race race) {
        this.race = race;
        this.handleNumber = new HandleNumber();
        this.printRaceResult = new PrintRaceResult(race);
    }

    public void startGame(){
        System.out.println();
        GameProgressMessage.RACE_RESULT_MESSAGE.printMessage();

        for(int i = 0; i < race.getTryNum(); i++){
            progressGame();
            printRaceResult.printCarsStatus();
        }
        printRaceResult.printWinners(determineWinner());
    }

    private void progressGame(){
        List<Integer> randomNumbers = handleNumber.generateRandomNumberList(race.sizeOfCars());

        for(int i = 0; i < race.sizeOfCars(); i++){
            int randNum = randomNumbers.get(i);
            if(randNum >= MOVING_FORWARD) race.moveCar(i);
        }
    }

    private List<String> determineWinner(){
        List<String> winners = new ArrayList<>();
        int maxLocation = race.getMaxLocationOfCar();

        for(Car car : race.getCars()){
            if(maxLocation == car.getLocation()) winners.add(car.getCarName());
        }
        return winners;
    }
}
