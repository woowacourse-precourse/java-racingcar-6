package racingcar;

import java.util.HashSet;
import java.util.Set;

public class ErrorExcept {
    //
    public static void errorRedundant(String carName){
        String[] carArr = carName.split(",");
        Set<String> set = new HashSet<>();
        for (String element : carArr) {
            if (!set.add(element)) {
                throw new IllegalArgumentException("중복된 차량이름입니다.");
            }
        }
    }

    public static void errorExcessLength(String carName){
        String[] carArr = carName.split(",");
        for(String name:carArr){
            if(name.length() > 5){
                throw new IllegalArgumentException("차량의 이름이 5글자를 초과했습니다.");
            }
        }
    }


}
