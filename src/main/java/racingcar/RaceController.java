package racingcar;

import java.util.ArrayList;

public class RaceController {

    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<String> winners = new ArrayList<>();
    RaceView raceView = new RaceView();
    int attempts;

    public void startRace() {
        // 입력 받은 자동차 이름 설정
        initializeCars(raceView.inputCarNames());
        attempts = raceView.inputNumberOfAttempts();
        System.out.println("실행 결과");
        while (attempts != 0) {
            for (Car car : cars) {
                moveCarIfRandomNumberIsFourOrHigher(car);
            }
            raceView.displayRaceProgress(cars);
            attempts--;
        }
        raceView.displayWinner(findWinner());
    }

    public void initializeCars(String inputCar) {
        String[] inputCars = inputCar.split(",");
        for (String car : inputCars) {
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
