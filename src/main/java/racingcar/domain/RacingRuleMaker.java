package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingRuleMaker {

    private List<String> cars = new ArrayList<>();
    private int allRoundCount;
    ErrorCheck errorCheck = new ErrorCheck();

    public RacingRuleMaker() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        namingCar();
        System.out.println("시도할 회수는 몇회인가요?");
        inputRacingRound();
    }

    public List<String> namingCar() {

        String carNames = Console.readLine();
        //문자열 -> ArrayList , 자동차 이름 끝단 공백 제거
        cars = Arrays.stream(carNames.split(","))
                .map(String::strip)
                .collect(Collectors.toList());

        errorCheck.carNameCheck(cars);
        return cars;
    }

    public void inputRacingRound() {

        String inputRacingRound = Console.readLine();
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
