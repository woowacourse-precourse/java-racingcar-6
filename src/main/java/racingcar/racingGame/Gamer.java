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

        String[] splitArr = inputCarName.split(",");
        checkCarName(splitArr);

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

    public void checkCarName(String[] carArr) {

        for (String car : carArr) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            } else if (car.trim().isEmpty()) {
                throw new IllegalArgumentException("공백인 자동차 이름은 입력이 불가능 합니다.");
            }
        }
    }


}