package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.Constants;

public class StringUtils {
    public static List<String> toStringList(String inputString){
        String words = inputString;
        String[] wordArray = words.split(",\\s*");
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));

        return wordList;
    }

    public static String createHyphenRepeat(int count) {
        if (count <= 0) {
            return "";
        }

        StringBuilder hyphenString = new StringBuilder();
        for (int i = 0; i < count; i++) {
            hyphenString.append(Constants.HYPHEN);
        }

        return hyphenString.toString();
    }

}
