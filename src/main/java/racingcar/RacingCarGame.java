package racingcar;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.car.Car;
import racingcar.car.name.CarName;
import racingcar.car.name.CarNameParser;
import racingcar.io.UserIo;

public class RacingCarGame {

    private final CarNameParser carNameParser;
    private final CarMovementDecider carMovementDecider;

    public RacingCarGame(CarNameParser carNameParser, CarMovementDecider carMovementDecider) {
        this.carNameParser = carNameParser;
        this.carMovementDecider = carMovementDecider;
    }

    public void run(UserIo userIo) {
        List<CarName> carNameList = getCarNameList(userIo);

        RacingAttempt racingAttempt = getRacingAttempt(userIo);

        List<Car> carList = createCarList(carNameList);
        List<RacingResult> racingResultList = race(carList, racingAttempt);
    }

    private List<CarName> getCarNameList(UserIo userIo) {
        userIo.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String carNameLine = userIo.readLine();
        return carNameParser.parse(carNameLine);
    }

    private RacingAttempt getRacingAttempt(UserIo userIo) {
        userIo.print("시도할 회수는 몇회인가요?\n");
        return new RacingAttempt(userIo.readLine());
    }

    private List<Car> createCarList(List<CarName> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .toList();
    }

    private List<RacingResult> race(List<Car> carList, RacingAttempt racingAttempt) {
        IntStream.range(0, racingAttempt.getAttempts())
                .forEach(i -> carMovementDecider.move(carList));

        return carList.stream()
                .map(car -> new RacingResult(car.getCarName(), car.getDistanceDriven()))
                .toList();
    }
}
