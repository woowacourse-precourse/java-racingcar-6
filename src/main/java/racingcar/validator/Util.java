package racingcar.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class Util {
    public static ArrayList<String> toArrayList(String carString){
        ArrayList<String> list = new ArrayList<>();
        String[] carArray = carString.split(",");
        for(int i=0;i<carArray.length;i++){
            list.add(carArray[i]);
        }
        return list;
    }
    public static String getDashString(String dash,int repeat){
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, repeat).forEach(i -> sb.append(dash));
        return sb.toString();
    }
    public static int getMax(ArrayList<Integer> integers) {
        return Collections.max(integers);
    }
}
