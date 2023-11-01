package model;

import static model.number.MIN_NUMBER;
import static model.number.MAX_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class utilityModel {
    public static String[] splitByComma(String input){
        return input.split(",");
    }
    public static boolean isValidName(int maxLength, String name){
        if(name.length() <= maxLength){
            return true;
        }
        throw new IllegalArgumentException();
    }
    public static int stringToInt(String string){
        return Integer.parseInt(string);
    }
    public static int getRandomNum() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}