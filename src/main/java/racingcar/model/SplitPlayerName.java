package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class SplitPlayerName {

    public static List<String> splitPlayerName(String input){
        List<String> tmpList = new ArrayList<>();

        String[] delimeter = input.split(",");
        for(String name : delimeter){
            tmpList.add(name.trim());
        }

        return tmpList;
    }


}
