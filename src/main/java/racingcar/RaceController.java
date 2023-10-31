package racingcar;

import java.util.ArrayList;

public class RaceController {


    RaceView raceView = new RaceView();
    ErrorHandler errorHandler = new ErrorHandler();

    public void startRace() {
        // 입력 받은 자동차 이름 설정
        ArrayList<Car> cars = new ArrayList<>();
        initializeCars(cars, raceView.inputCarNames());

        int attempts = raceView.inputNumberOfAttempts();
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

        raceView.displayWinner(findWinner(cars, attempts));
    }

    public void initializeCars(ArrayList<Car> cars, String inputCar) {
        String[] inputCars = inputCar.split(",");
        for (String car : inputCars) {
            errorHandler.checkErrorCarName(car);
            cars.add(new Car(car));
        }
    }

    public int moveCarIfRandomNumberIsFourOrHigher(Car car) {
        int num = car.generateRandomNumber();
        if (num >= 4) {
            modifyCar(car);
        }
        return num;
    }

    public void modifyCar(Car car) {
        car.setProgress();
    }

    public String findWinner(ArrayList<Car> cars, int attempts) {
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getProgress().length() == attempts) {
                winners.add(car.getName());
            }
        }
        return String.join(",", winners);
    }


}
