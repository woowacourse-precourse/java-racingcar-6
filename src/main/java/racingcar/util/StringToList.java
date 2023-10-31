package racingcar.util;

public class StringToList {

    public static String[] stringToList(String input){
        String[] names = input.split(",");
        return names;
    }
}
