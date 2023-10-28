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
    public List<String> playOneRound() {
        racingCars.forEach(Car::play);
        return generateResults();
    }

    // 자동차들의 현재 주행 결과를 '이름 : dashes' 형태의 String List로 반환
    public List<String> generateResults() {
        return racingCars.stream()
                .map(Car::generateResult)
                .toList();
    }

    // 현재 진행 라운드를 바탕으로, WinnerResult 객체를 리턴한다.
    public WinnerResult createWinnerResult() {
        List<Car> winners = racingCars.stream()
                .filter(car -> car.isSameScore(getMaxScore()))
                .toList();

        return WinnerResult.create(winners);
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
