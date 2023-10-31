package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import racingcar.Constants;

public class Utils {
    public static ArrayList<String> toStringList(String inputString){
        String words = inputString;
        String[] wordArray = words.split(",\\s*");
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(wordArray));

        return wordList;
    }

    public static String createHyphenRepeat(int position) {
        if (position <= 0) {
            return "";
        }

        StringBuilder hyphenString = new StringBuilder();
        for (int i = 0; i < position; i++) {
            hyphenString.append(Constants.HYPHEN);
        }

        return hyphenString.toString();
    }

    public static int generateRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

}
