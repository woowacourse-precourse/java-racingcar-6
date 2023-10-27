package racingcar;

import java.util.ArrayList;

public class RaceController {

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<String> winners = new ArrayList<>();
    RaceView raceView = new RaceView();
    ErrorHandler errorHandler = new ErrorHandler();
    int attempts;

    public void startRace() {
        // 입력 받은 자동차 이름 설정
        initializeCars(raceView.inputCarNames());
        attempts = raceView.inputNumberOfAttempts();
        int temp_attempts = attempts;

        System.out.println("실행 결과");
        while (temp_attempts != 0) {
            for (Car car : cars) {
                moveCarIfRandomNumberIsFourOrHigher(car);
            }
            raceView.displayRaceProgress(cars);
            System.out.println();
            temp_attempts--;
        }

        raceView.displayWinner(findWinner());
    }

    public void initializeCars(String inputCar) {
        String[] inputCars = inputCar.split(",");
        for (String car : inputCars) {
            errorHandler.checkErrorCarName(car);
            cars.add(new Car(car));
        }
    }

    public void moveCarIfRandomNumberIsFourOrHigher(Car car) {
        if (car.generateRandomNumber() >= 4) {
            modifyCar(car);
        }
    }

    public void modifyCar(Car car) {
        car.setProgress();
    }

    public String findWinner() {
        for (Car car : cars) {
            if (car.getProgress().length() == attempts) {
                winners.add(car.getName());
            }
        }
        return String.join(",", winners);
    }


}
