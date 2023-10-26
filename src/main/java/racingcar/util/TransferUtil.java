package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransferUtil {
    public List<String> transferStringToListString(String targetString){
        String[] targetStringList = targetString.split(",");
        return new ArrayList<>(Arrays.asList(targetStringList));
    }
}
