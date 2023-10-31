package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {

    List<Car> carList;

    public void start() {
        saveCar();
        runRace(attemptsCheck(), carList);
    }

    public void saveCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameList = Arrays.asList(readLine().split(","));
        carNameCheck(carNameList);
    }

    public void carNameCheck(List<String> carNameList) {
        carList = new ArrayList<>();
        for (String name : carNameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            carList.add(new Car(name));
        }

    }

    public int attemptsCheck() {
        System.out.println("시도할 회수는 몇회인가요?");
        return numberCheckException(readLine());
    }

    // 예외처리
    public int numberCheckException(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void runRace(int attemptsCheck, List<Car> carList) {
        System.out.println();
        for (int attempt = 0; attempt < attemptsCheck; attempt++) {
            for (Car car : carList) {
                car.move();
                System.out.println(car.getName() + " : " + car.getPositionString());
            }
            System.out.println();
        }
        List<String> winners = winners(carList);
        System.out.println("최종 우승자 : " + String.join(", ", winners));

    }

    public List<String> winners(List<Car> carList) {
        List<Integer> positions = carList.stream()
                .map(car -> {
                    return car.getPosition();
                }).toList();

        Optional<Integer> maxPositionOptional = positions.stream()
                .max((position1, position2) -> Integer.compare(position1, position2));

        int maxPosition = maxPositionOptional.orElse(0);
        return findWinners(carList, maxPosition);
    }


    public List<String> findWinners(List<Car> carList, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }


}



