package racingcar.domain;

import racingcar.exception.RacingCarException;
import racingcar.parser.Parser;

import java.util.List;

import static racingcar.exception.ErrorMessage.SYSTEM_ERROR;

public class Cars {
    private final List<Car> racingCars;

    // Car Constructor
    private Cars(final String input) {
        List<String> carNames = Parser.parseCarNames(input);
        this.racingCars = createCars(carNames);
    }

    // Cars Static Factory Method
    public static Cars create(final String input) {
        return new Cars(input);
    }

    // 경주할 자동차를 1회전 전진시킨다.
    public void playRound() {
        racingCars.forEach(Car::move);
    }

    // 자동차들의 현재 주행 결과를 '이름 : dashes' 형태의 String List로 반환
    public List<String> generateResults() {
        return racingCars.stream()
                .map(Car::generateRoundResult)
                .toList();
    }

    // 현재 진행 라운드에서 가장 점수가 높은 Car List를 반환한다.
    public List<String> getWinnerNames() {
        return racingCars.stream()
                .filter(car -> car.isSameScore(getMaxScore()))
                .map(Car::getName)
                .toList();
    }

    // List<Car> racingCars에서 가장 점수가 높은 자동차의 점수를 구한다.
    public Integer getMaxScore() {
        return racingCars.stream()
                .mapToInt(Car::getScore)
                .max()
                .orElseThrow(() -> RacingCarException.of(SYSTEM_ERROR));
    }

    // 파싱된 이름들을 바탕으로 자동차를 생성하고 List에 담아 반환한다.
    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::create)
                .toList();
    }
}
