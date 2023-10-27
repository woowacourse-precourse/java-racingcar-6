package racingcar;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Race race;
    private View raceView = new View();

    public void startRace(){

        String carNameInput = raceView.printStartMeg();
        String [] carNames = splitCarNames(carNameInput);

        this.race = new Race(carNames);

        int countNumber = raceView.printGoCount();

        raceView.printResultMeg();

        for(int i=0; i<countNumber; i++){
            for(int j=0; j<carNames.length; j++){
                race.moveCars(carNames[j]);
            }
            raceView.printRaceResult(race.getCars());
        }
        String winnerCar = checkWinner();
        raceView.printWinner(winnerCar);
    }

    private String[] splitCarNames(String carNameInput){

        String[] carNames = carNameInput.split(",");

        for(int i=0; i<carNames.length;i++){
            carNames[i] = carNames[i].trim();
        }

        return carNames;
    }

    private int maxCount(){

        int maxMove = -1;

        for(Car car : race.getCars()){

            if(car.getMove() > maxMove){
                maxMove = car.getMove();
            }
        }

        return maxMove;
    }

    private String checkWinner(){

        int maxMove = maxCount();
        List<String> winnerCar = new ArrayList<>();

        for(Car car : race.getCars()){
            if(car.getMove() == maxMove){
                winnerCar.add(car.getName());
            }
        }

        return String.join(", ", winnerCar);
    }
}
