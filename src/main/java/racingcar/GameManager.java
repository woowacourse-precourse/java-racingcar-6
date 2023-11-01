package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    User user = new User();
    public void start() {
        List<String> carNames = user.setCar();
        List<Car> carList = listOfCars(carNames);
        int cnt = user.setMoves();

        System.out.println("실행 결과");

        for (int i = 0; i < cnt; i++) {
            List<Integer> randomNumbers = RandomNumberGenerator.generateRandomNumber(carList.size());
            move(carList, randomNumbers);
            user.listOfResult(carList);
        }

        List<String> winners = getWinners(carList);
        user.printWinners(winners);
    }

    private List<Car> listOfCars(List<String> carNames) {
        List<Car> carList = new ArrayList<Car>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    private void move(List<Car> carList, List<Integer> randomNumbers) {
        for (int i = 0; i < carList.size(); i++) {
            if(randomNumbers.get(i) >= 4) carList.get(i).addMove();
        }
    }

    private List<String> getWinners(List<Car> carList) {
        List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        for (Car car : carList) {
            int distance = car.getDistance();

            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(car.getName());
            } else if (distance == maxDistance) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
