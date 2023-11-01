package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingRuleMaker {

    private List<String> cars = new ArrayList<>();
    private int allRoundCount;
    ErrorCheck errorCheck = new ErrorCheck();

    public RacingRuleMaker(String carNames, String inputRacingRound) {
        namingCar(carNames);
        inputRacingRound(inputRacingRound);
    }

    public List<String> namingCar(String carNames) {

        //문자열 -> ArrayList , 자동차 이름 끝단 공백 제거
        cars = Arrays.stream(carNames.split(","))
                .map(String::strip)
                .collect(Collectors.toList());

        errorCheck.carNameCheck(cars);
        return cars;
    }

    public void inputRacingRound(String inputRacingRound) {

        errorCheck.inputNumberCheck(inputRacingRound);
        allRoundCount = Integer.parseInt(inputRacingRound);
    }

    public List<String> getCars() {

        return cars;
    }

    public int getAllRoundCount() {

        return allRoundCount;
    }

}
