package racingcar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.ConsoleResultView;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RaceController {
    private final InputView consoleInputView;

    public RaceController(InputView consoleInputView) {
        this.consoleInputView = consoleInputView;
    }

    /**
     * 사용자가 입력한 자동차 이름들과 시도 횟수를 통해 경주를 진행합니다. 경주가 끝나면 경주 결과를 출력합니다.
     */
    public void runRace() {
        List<String> carNames = getValidatedCarNames();
        int attemptNumber = getValidatedRoundNumber();

        List<Car> cars = initCars(carNames);
        Race race = initRace(cars, attemptNumber);

        List<HashMap<String, Integer>> raceResult = race.getRaceResult();
        List<String> winners = Race.getWinners(raceResult);

        ResultView consoleResultView = new ConsoleResultView(raceResult, winners);
        consoleResultView.displayRaceResults();
        consoleResultView.displayWinners();
    }

    /**
     * 사용자가 입력한 자동차 이름들을 유효성 검사를 마친 후 반환합니다.
     *
     * @return 사용자가 입력한 자동차 이름들
     */
    private List<String> getValidatedCarNames() {
        List<String> carNames = consoleInputView.getCarNamesInput();
        CarNameValidator.validate(carNames);
        return carNames;
    }

    /**
     * 사용자가 입력한 시도 횟수를 유효성 검사를 마친 후 반환합니다.
     *
     * @return 사용자가 입력한 시도 횟수
     */
    private int getValidatedRoundNumber() {
        String attemptNumber = consoleInputView.getAttemptInput();
        AttemptNumberValidator.validate(attemptNumber);
        return Integer.parseInt(attemptNumber);
    }

    /**
     * @param carNames 사용자가 입력한 자동차 이름들
     * @return 자동차 이름들을 가진 자동차들의 리스트
     */
    private List<Car> initCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    /**
     * @param participatedCars 경주에 참가하는 자동차들의 목록
     * @param attemptNumber    사용자가 입력한 시도 횟수
     * @return Race 객체
     */
    private Race initRace(List<Car> participatedCars, int attemptNumber) {
        return new Race(participatedCars, attemptNumber);
    }
}