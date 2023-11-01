package model;

import static model.Number.MAX_NAME_LENGTH;
import static model.Number.MAX_NUMBER;
import static model.Number.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;

public class UtilityModel {
    public static String[] splitByComma(String input) {
        return input.split(",");
    }

    public static void isInValidName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static int stringToInt(String string) {
        return Integer.parseInt(string);
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    int findMaxNumber(ArrayList<Integer> arrayList) {
        return Collections.max(arrayList);
    }
}