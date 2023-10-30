package racingcar;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Cars {
    private final List<Car> carList;

    Cars(List<String> carNames) {
        carList = carNames.stream()
                .map(Car::new)
                .toList();
    }

    void tryMoveAll(List<Integer> movePowers) {
        if (movePowers.size() != carList.size()) {
            throw new IllegalArgumentException("이동 세기목록 크기는 자동차 개수와 같아야 합니다.");
        }
        IntStream.range(0, carList.size())
                .forEach(moveEachCar(movePowers));
    }

    private IntConsumer moveEachCar(List<Integer> movePowers) {
        return index -> {
            Car car = carList.get(index);
            int movePower = movePowers.get(index);
            car.tryMove(movePower);
        };
    }

    @Override
    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    String calculateWinner() {
        int winnerMoveForwardCount = getWinnerMoveForwardCount();
        return carList.stream()
                .filter(car -> car.getMoveForwardCount() == winnerMoveForwardCount)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int getWinnerMoveForwardCount() {
        return carList.stream()
                .mapToInt(Car::getMoveForwardCount)
                .max().orElse(0);
    }

    int carCount(){
        return carList.size();
    }
}
