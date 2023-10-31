package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public final class Race {
    private final List<Car> cars;
    private final int tryNumber;

    private Race(List<Car> cars, int tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public int getCarsLength() {
        return cars.size();
    }

    public String getCar(int carIndex) {
        return cars.get(carIndex).getName();
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public int getRaceAccumulation(int raceIndex) {
        return cars.get(raceIndex).getRaceAccumulation();
    }

    public void increaseChanceScore(int raceIndex) {
        Car car = cars.get(raceIndex);
        car.increaseRaceAccumulation();
    }

    public static Race initializeRaceInformation() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();
        List<Car> cars = new ArrayList<>();
        for (String car : carInput.split(",")) {
            cars.add(new Car(car, 0));
        }
        checkNameError(cars);
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.parseInt(Console.readLine());
        return new Race(cars, tryNumber);
    }

    public static Race initializeRaceInformation(String carInput, int tryNumber, List<Integer> raceAccumulations) {
        List<Car> cars = new ArrayList<>();
        String[] carArray = carInput.split(",");
        for (int index = 0; index < carArray.length; index++) {
            cars.add(new Car(carArray[index], raceAccumulations.get(index)));
        }
        return new Race(cars, tryNumber);
    }

    private static void checkNameError(List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException("5자를 넘는 이름을 입력하셨습니다. 오류 발생");
            }
            if (car.getName().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름으로 공백 값을 입력하셨습니다. 오류 발생");
            }
        }
    }

    public List<String> findFinalWinner() {
        int maxScore = 0;
        List<String> WinnerNames = new ArrayList<>();
        for (Car car : cars) {
            int carRaceAccumulation = car.getRaceAccumulation();
            String carName = car.getName();
            if (carRaceAccumulation > maxScore) {
                maxScore = carRaceAccumulation;
                WinnerNames.clear();
                WinnerNames.add(carName);
            } else if (carRaceAccumulation == maxScore) {
                WinnerNames.add(carName);
            }
        }
        return WinnerNames;
    }
}
