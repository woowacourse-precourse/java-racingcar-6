package racingcar.race;

import racingcar.car.Car;
import racingcar.variables.ErrorMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceController {

    private static RaceViewer viewer;
    private String result = "실행 결과\n";
    private static List<Car> cars;
    private int N ;

    public RaceController(RaceViewer viewer) {
        this.viewer = viewer;
        this.cars = new ArrayList<>();
    }

    public void startRace(){
        String[] carsAsString = viewer.getCars();
        for(String carName : carsAsString){
            checkValidName(carName);
            cars.add(new Car(carName));
        }

        N = viewer.nTimes();
        playRaces();
        checkWinner();
        viewer.printResult(result);

    }

    private void checkWinner(){
        int maxCoord = cars.stream()
                .mapToInt(Car::getCoord)
                .max()
                .orElse(0);

        List<String> winnerNames = cars.stream()
                .filter(car -> car.getCoord() == maxCoord)
                .map(Car::getName)
                .collect(Collectors.toList());

        result = result + "최종 우승자 : " + String.join(", ", winnerNames);
    }

    private void checkValidName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_ERROR.getErrorMessage());
        }
    }

    private void playRaces() {
        // play race N times
        for(int i = 0 ; i < N ; i++){
           calcResult();
        }
    }

    private String calcResult() {
        String tmpres = "";

        for (Car car : cars){
            car.tryMovingForword();
            tmpres = tmpres + car + "\n";
        }

        return result = result + tmpres + "\n";
    }

    String getResult() {
        return result;
    }


}
