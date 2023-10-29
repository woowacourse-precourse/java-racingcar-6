package racingcar.validator;

import java.util.ArrayList;

public class Util {
    public static ArrayList<String> toArrayList(String carString){
        ArrayList<String> list = new ArrayList<>();
        String[] carArray = carString.split(",");
        for(int i=0;i<carArray.length;i++){
            list.add(carArray[i]);
        }
        return list;
    }
}
