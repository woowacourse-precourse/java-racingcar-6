package racingcar.RacingService;

import racingcar.model.Car;
import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static racingcar.model.RacingRule.isOkToUseAttemptCount;
import static racingcar.model.RacingRule.isOkToUseCarName;
import static racingcar.view.InputView.getAttemptCountFromUser;
import static racingcar.view.InputView.getCarNamesFromUser;
import static racingcar.view.OutputView.displayAttemptPrompt;
import static racingcar.view.OutputView.displayCarNamePrompt;

public class RacingService {
    private List<Car> cars;
    private List<String> carNameList;
    private int totalRound;

    public void initializeGame() {
        readyCarName();
        readyAttemptCount();
        readyCars();
    }

    /**
     * 자동차 이름 세팅
     */
    protected void readyCarName() {
        displayCarNamePrompt();

        List<String> cadidateNameList = getCarNameList();

        if(validateCarNameList(cadidateNameList)) {
            carNameList = cadidateNameList;
        }
    }

    protected List<String> getCarNameList() {
        String carNames = getCarNamesFromUser();

        List<String> carNameList = Arrays.stream(carNames.split(","))
                .map(String::trim)
                .collect(toList());

        return carNameList;
    }

    protected boolean validateCarNameList(List<String> carNameList) {
        for(String carName : carNameList){
            isOkToUseCarName(carName);
        }

        return true;
    }

    /**
     * 시도할 횟수 세팅
     */
    protected void readyAttemptCount() {
        displayAttemptPrompt();
        totalRound = getAttemptCount();
    }

    protected int getAttemptCount() {
        int attemptCountFromUser = getAttemptCountFromUser();

        isOkToUseAttemptCount(attemptCountFromUser);

        return attemptCountFromUser;
    }

    /**
     * 레이싱할 자동차 등록
     */
    protected void readyCars() {
        cars = new ArrayList<>();
        for(String carName : carNameList) {
            cars.add(new Car(carName, new RandomNumberGenerator()));
        }
    }

    // test를 위한 getter
    protected List<Car> getCars() {
        return cars;
    }
}
