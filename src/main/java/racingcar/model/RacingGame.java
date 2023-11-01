package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.vo.Attempt;
import racingcar.model.vo.CarName;

public class RacingGame {
    private List<Car> carGroup;

    private RacingGame(List<CarName> carNameGroup) {
        this.carGroup = carNameGroup.stream()
                .map(Car::new)
                .toList();
    }

    public static RacingGame init(String carNames) {
        List<CarName> list = Arrays.stream(carNames.split(","))
                .map(CarName::new)
                .toList();
        return new RacingGame(list);
    }

    public String playGame(Attempt attempt) {
        String result = "";
        for (int i = 0; i < attempt.getIterateCount(); i++) {
            result += playGameOneRound();
        }
        return result;
    }

    private String playGameOneRound() {
        return carGroup.stream()
                .map(car -> {
                    car.playGameOneRound();
                    return car.toString();
                })
                .collect(Collectors.joining("\n", "", "\n\n"));
    }

    public String determineWinner() {
        int max = findMaxDistance();
        List<String> winnerList = findwinnerList(max);
        return separateComma(winnerList);
    }

    private int findMaxDistance() {
        return carGroup.stream()
                .mapToInt(car -> car.getCarLocationLength())
                .max()
                .orElse(0);
    }

    private List<String> findwinnerList(int max) {
        // find winner with max distance
        return carGroup.stream()
                .filter(car -> max == car.getCarLocationLength())
                .map(car -> car.getName())
                .map(carName -> carName.toString())
                .collect(Collectors.toList());
    }

    private String separateComma(List<String> list) {
        return String.join(", ", list);
    }
}
