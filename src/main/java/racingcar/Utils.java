package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static boolean nameIsValid(String name) throws IllegalArgumentException{
        if(name.length()>5){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean nameIsDuplicate(List<String> names){
        if (names.stream().distinct().count() != names.size()) return true;
        return false;
    }

    public static String userInput(){ return Console.readLine(); }

    public static int inputTryCount() throws IllegalArgumentException{
        int tryCount = 0;
        try{
            tryCount = Integer.parseInt(userInput());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

        return tryCount;
    }

    public static String[] inputNameSplit(String sep, String target){
        return target.split(sep);
    }
    public static List<String> inputStrAryToNameList(String[] input){ return Arrays.asList(input); }

    public static List<Player> nameListToPlayerList(List<String> names){
        return names.stream()
                .map(name -> new Player(name))
                .collect(Collectors.toList());
    }
}
