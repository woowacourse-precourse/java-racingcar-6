package racingcar.Util;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public List<String> StringToList(String string){
        List<String> stringList = new ArrayList<>();
        String[] array = string.split(",");
        for(int i =0; i<array.length; i++){
            stringList.add(array[i]);
        }
        return stringList;
    }
}
