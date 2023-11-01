package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    public void start(List<Car> carList, int attemptsNumber) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < attemptsNumber; i++) {
            racingCar(carList);
            System.out.println();
        }
        List<String> winners = getWinners(carList);
        winnerPrintout(winners);
    }

    private List<String> getWinners(List<Car> carList) {
        return winnerSelect(carList);
    }

    private void winnerPrintout(List<String> result) {
        System.out.println("최종 우승자 : " + String.join(",", result));
    }

    public void racingCar(List<Car> carList) {
        for (Car car : carList) {
            if (shouldMove(getRandomNumber())) car.move();
            System.out.println(car.getCarStatus());
        }
    }

    public boolean shouldMove(int randomNumber) {
        getRandomNumber();
        return randomNumber >= 4;
    }

    private int getRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    public List<String> winnerSelect(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getPositionLength)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPositionLength() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
