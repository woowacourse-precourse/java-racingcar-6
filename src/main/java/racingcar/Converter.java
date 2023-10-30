package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converter {
    static final String SEPARATOR = ",";

    public static List<String> separateCarNames(String carNames) {
        String[] separatedCarNames = carNames.split(SEPARATOR);
        return new ArrayList<>(Arrays.asList(separatedCarNames));
    }

    public static int convertAttempts(String attempts){
        return Integer.parseInt(attempts);
    }

    public static String convertDistance(List<String> distance){
        StringBuilder convertedDistance = new StringBuilder();
        for(int i = 0; i <distance.size(); i++){
            convertedDistance.append(distance.get(i));
        }
        return convertedDistance.toString();
    }
}
