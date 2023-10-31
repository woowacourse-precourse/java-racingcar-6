package racingcar.exeption;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomizedException {
    public static void numberUpException(List<String> carList){
        for(int i = 0 ; i< carList.size();i++){
            if(carList.get(i).length()>5){
                throw new IllegalArgumentException();
            }

        }
    }

    public static void sameNameCarException(List<String> carList){
        Set<String> uniqueNames = new HashSet<>();

        for (String carName : carList) {
            if (uniqueNames.contains(carName)) {
                throw new IllegalArgumentException("같은 자동차 입니다.: " + carName);
            }
            uniqueNames.add(carName);
        }
    }

    public static void emptyCarNameException(List<String> carList) {
        for (String carName : carList) {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("빈칸을 입력할 수는 없습니다.");
            }
        }
    }
}
