package racingcar;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.car.Car;
import racingcar.car.name.CarName;
import racingcar.car.name.CarNameParser;
import racingcar.io.UserIo;
import racingcar.result.RacingCarResultFormatter;
import racingcar.result.RacingResult;

public class RacingCarGame {

    private final CarNameParser carNameParser;
    private final CarMovementDecider carMovementDecider;
    private final RacingCarResultFormatter racingCarResultFormatter;

    public RacingCarGame(
            CarNameParser carNameParser,
            CarMovementDecider carMovementDecider,
            RacingCarResultFormatter racingCarResultFormatter) {
        this.carNameParser = carNameParser;
        this.carMovementDecider = carMovementDecider;
        this.racingCarResultFormatter = racingCarResultFormatter;
    }

    public void run(UserIo userIo) {
        List<CarName> carNameList = getCarNameList(userIo);

        RacingAttempt racingAttempt = getRacingAttempt(userIo);

        List<Car> carList = createCarList(carNameList);
        List<RacingResult> racingResultList = race(carList, racingAttempt, userIo);

        userIo.print(racingCarResultFormatter.formatFinalResult(racingResultList));
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

    private List<RacingResult> race(List<Car> carList, RacingAttempt racingAttempt, UserIo userIo) {
        userIo.print("\n실행결과\n");

        IntStream.range(0, racingAttempt.getAttempts())
                .forEach(i -> {
                    carMovementDecider.move(carList);

                    List<RacingResult> rountResultList = carList.stream()
                            .map(car -> new RacingResult(car.getCarName(), car.getDistanceDriven()))
                            .toList();

                    userIo.print(racingCarResultFormatter.formatRoundResult(rountResultList));
                });

        return carList.stream()
                .map(car -> new RacingResult(car.getCarName(), car.getDistanceDriven()))
                .toList();
    }
}
