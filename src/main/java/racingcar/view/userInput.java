package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import java.util.Set;

public class userInput {

    public static List<String> getCarNames(){
        String carNames = readLine();
        List<String> nameList = Arrays.asList(carNames.split(","));

        validateNames(nameList);
        return nameList;
    }

    public static void validateNames(List<String> names){
        Set<String> setNames = new HashSet<>(names);

        if(setNames.size()!= names.size()){
            throw new IllegalArgumentException();
        }

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

    }
    public static int getTryNumber(){
        return Integer.parseInt(readLine());
    }
    private static String readLine(){
        return Console.readLine();
    }

}
