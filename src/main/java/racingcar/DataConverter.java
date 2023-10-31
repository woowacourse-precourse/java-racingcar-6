package racingcar;

import java.util.ArrayList;
import java.util.List;

public class DataConverter {

     public static List<String> toListString(String str) {
        String[] arry = str.split(",");

        List<String> list = new ArrayList<>();
        for (String sample : arry) {
            list.add(sample);
        }

        return list;
    }

}
