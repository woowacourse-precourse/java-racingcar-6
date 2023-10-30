package racingcar.RacingService;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static racingcar.model.RacingRule.isOkToUseCarName;
import static racingcar.view.InputView.getCarNamesFromUser;

public class RacingService {
    private List<Car> cars;
    private List<String> carNameList;

    /**
     * 자동차 이름 세팅
     */
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

    public void readyCarName() {
        List<String> cadidateNameList = getCarNameList();
        if(validateCarNameList(cadidateNameList)) {
            carNameList = cadidateNameList;
        }
    }



}
