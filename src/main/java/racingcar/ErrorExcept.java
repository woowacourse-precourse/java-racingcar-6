package racingcar;

import java.util.HashSet;
import java.util.Set;

public class ErrorExcept {
    //
    public static void errorRedundant(String carName){
        String[] carArr = carName.split(Common.seperator);
        Set<String> set = new HashSet<>();
        for (String element : carArr) {
            if (!set.add(element)) {
                throw new IllegalArgumentException(Common.strErrorRedundant);
            }
        }
    }

    public static void errorExcessLength(String carName){
        String[] carArr = carName.split(",");
        for(String name:carArr){
            if(name.length() > 5){
                throw new IllegalArgumentException(Common.strErrorExcessLength);
            }
        }
    }

    public static void errorLessParameter(String carName){
        String[] carArr = carName.split(",");
        if(carArr.length <= 1){
            throw new IllegalArgumentException(Common.strErrorExcessLength);
        }
    }

    public static void errorInputCarName(String carName){
        errorLessParameter(carName);
        errorExcessLength(carName);
        errorRedundant(carName);
    }

    public static int errorNaN(String strNum){
        int num;
        try{
            num = Integer.parseInt(strNum);
        }catch (NumberFormatException ex){
            throw new IllegalArgumentException(Common.strErrorExcessLength);
        }
        return num;
    }


}
