package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static List<String> toStringList(String inputString){
        String words = inputString;
        String[] wordArray = words.split(",\\s*");
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));

        return wordList;
    }
}
