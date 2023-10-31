package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Cars {
    final private String START_PRINT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private String GO = "-";
    private String inputCarName = null;

    public Cars() {
    }


    public List createCars() {
        System.out.println(START_PRINT);
        String inputCarName = Console.readLine();
        String[] inputCarNames = inputCarName.split(",");
        List<String> inputCarNameList = Arrays.stream(inputCarNames).toList();

        return inputCarNameList;
    }

    public Cars(int tryCount) {

    }

    public void sprint(List<String> carsNameList, int inputTryCount) {

    }

}
