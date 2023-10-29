package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingApp {

    private int executeCount;
    private List<RacingCar> racingCarList = new ArrayList<>();

    public void run() {
        String input = getPlayerList();
        createRacingCarList(input);
    }

    private String getPlayerList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private void createRacingCarList(String input){
        List<String> nameList = getNameListFromInput(input);
        createRacingCarListByNameList(nameList);
    }

    private void createRacingCarListByNameList(List<String> nameList) {
        nameList.forEach(name -> racingCarList.add(new RacingCar(name)));
    }

    private List<String> getNameListFromInput(String input) {
        return Arrays.stream(input.split(",")).collect(Collectors.toList());
    }


}
