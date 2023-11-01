package racingcar.controller;

import racingcar.view.viewInputCar;
import java.util.ArrayList;
import java.util.List;
// ,을 기준으로 모두 5글자 이하인지 체크
// 중복된 차 이름이 없는지 체크

public class controllerValidation {
    private final String DELIMITER = ",";
    public boolean controllerValidatino(){
        viewInputCar inputData = new viewInputCar();
        String[] splitData = inputString.split(DELIMITER);
        List<String> stringList = new ArrayList<>();
        for (String item : splitData) {
            stringList.add(item);
        }

        for(String item : stringList){

        }
    }
}
