package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class RacingCarName {
    public List<String> carNameList(){
        List<String> carNames = Arrays.asList(Console.readLine().split(","));

        // Set 활용하여 중복값 확인
        Set<String> carNameSet = new HashSet<>();
        List<String> duplicateNames = new ArrayList<>();

        for (int i = 0; i < carNames.size(); i++) {
            String carName = carNames.get(i);

            //중복된 이름 포함되어 있다면
            if(carNameSet.contains(carName)) {
                duplicateNames.add(carName);
            }
            carNameSet.add(carName);

            if(!duplicateNames.isEmpty()){
                throw new IllegalArgumentException(duplicateNames.toString()+"이 중복되었습니다.");
            }

            if (carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름이 5자 초과되었습니다.");
            }else if(carName.isEmpty()){
                throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
            }
        }
        return carNames;
    }
}
