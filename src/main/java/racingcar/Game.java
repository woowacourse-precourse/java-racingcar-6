package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private int count;
    private List<Car> cars;
    private String winner;

    Game() {
    }

    public void run() {
        this.cars = new ArrayList<>();
        carsNameInput();
        System.out.println("시도할 횟수는 몇회인가요?");
        try {
            this.count = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        System.out.println();
        while (this.count != 0) {
            startRacing(cars);
            racingStepInfo(cars);
            count--;
        }
        findWinner(cars);
        System.out.printf("최종 우승자 : %s", this.winner);

    }

    public List<Car> carsNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String carName = Console.readLine();
            String[] carNames = carName.split(",");
            validateName(carNames);
            return createCars(carNames);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> createCars(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], ""));
        }
        return cars;
    }

    public void validateName(String[] carNames) throws Exception {
        for (String str : carNames) {
            if (str.length() > 5) {
                throw new Exception();
            }
        }
    }

    public void startRacing(List<Car> cars) {
        for (Car racingCar : cars) {
            if (isRacing()) {
                racingCar.setMove("-");
            }
        }
    }

    public boolean isRacing() {
        if (createRandom() >= 4) {
            return true;
        } else {
            return false;
        }
    }

    public int createRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void racingStepInfo(List<Car> cars) {
        for (Car carInfo : cars) {
            System.out.println(carInfo);
        }
        System.out.println();
    }

    public void findWinner(List<Car> cars) {
        String bucket = "";

        for (Car doneCar : cars) {
            if (bucket.length() < doneCar.getMove().length()) {
                bucket = doneCar.getMove();
                this.winner = doneCar.getName();
            } else if (bucket.length() == doneCar.getMove().length()) {
                this.winner += ", " + doneCar.getName();
            }
        }
    }

}
