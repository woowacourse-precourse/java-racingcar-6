package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingRuleMaker {

    private List<String> cars = new ArrayList<>();
    private int allRoundCount;

    public RacingRuleMaker() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        namingCar();
        System.out.println("시도할 회수는 몇회인가요?");
        inputRacingRound();

    }

    public List<String> namingCar() {
        String carNames = Console.readLine();

        String[] carsNamesArray = carNames.split(",");
        cars = Arrays.asList(carsNamesArray);
        return cars;
    }

    public void inputRacingRound() {
        String inputRacingRound = Console.readLine();

        allRoundCount = Integer.parseInt(inputRacingRound);
    }

    public List<String> getCars() {

        return cars;
    }

    public int getAllRoundCount() {

        return allRoundCount;
    }

}
