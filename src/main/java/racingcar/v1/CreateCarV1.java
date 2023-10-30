package racingcar.v1;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class CreateCarV1 {

    public String input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }

    public String[] carName(String input) {
        String[] carName = input.split(",");
        return carName;
    }

    public int carCount(String[] carName) {
        int carCount = carName.length;
        return carCount;
    }

    public Map<String, Integer> raceState(String[] carName) {
        Map<String, Integer> raceState = null;
        for (int i = 0; i < carName.length; i++) {
            raceState.put(carName[i], 0);
        }
        return raceState;
    }



}
