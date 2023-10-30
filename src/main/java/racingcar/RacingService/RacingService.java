package racingcar.RacingService;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static racingcar.model.RacingRule.isOkToUseCarName;
import static racingcar.view.InputView.getAttemptCountFromUser;
import static racingcar.view.InputView.getCarNamesFromUser;
import static racingcar.view.OutputView.displayCarNamePrompt;

public class RacingService {
    private List<Car> cars;
    private List<String> carNameList;
    private List<String> totalRound;

    /**
     * 자동차 이름 세팅
     */
    public void readyCarName() {
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


}
