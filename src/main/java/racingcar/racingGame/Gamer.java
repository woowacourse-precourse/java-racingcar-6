package racingcar.racingGame;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Gamer {

    public List<String> getCarName() {

        String inputCarName = Console.readLine();
        
        //TODO: 입력 유효성 검사 필요

        List<String> carNameList = divideCarName(inputCarName);

        return carNameList;
    }

    public List<String> divideCarName(String inputCarName) {

        List<String> carNameList = new ArrayList<>();

        String[] splitArr = inputCarName.split(", ");

        for(String car: splitArr) {
            carNameList.add(car);
        }

        return carNameList;
    }

    public int getTryNum() {

        String tryNum = Console.readLine();
        
        //TODO: 시도 횟수 유효성 검사 필요

        return Integer.parseInt(tryNum);
    }




}