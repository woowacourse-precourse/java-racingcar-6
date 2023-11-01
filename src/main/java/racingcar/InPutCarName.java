package racingcar;

import camp.nextstep.edu.missionutils.Console;

import javax.naming.Name;
import java.util.*;

public class InPutCarName {

    static final String SPLIT_DELIMITER = ",";
    static final String FIRST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String ERROR_CAR_NAME_SIZE_MESSAGE = "[ERROR] 자동차 이름은 5자 까지만 허용됩니다. ";
    static final int CAR_NAME_MAX_NUMBER = 5;

    public static Map<String, Integer> carName() {
        System.out.println(FIRST_MESSAGE);
        String input = Console.readLine();
        List<String> carNames = List.of(input.split(SPLIT_DELIMITER));

        Map<String, Integer> carMap = new HashMap<>();
        for (String name : carNames) {
            carMap.put(name, 0);
        }
        return carMap;
    }
    public static void carNameValidator(Map<String, Integer> carMap) {
        for(String name : carMap.keySet()){
            if(name.length()>CAR_NAME_MAX_NUMBER){
                throw new IllegalArgumentException(ERROR_CAR_NAME_SIZE_MESSAGE);
            }
        }
    }
}






