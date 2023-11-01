package model;

import static model.number.MIN_NUMBER;
import static model.number.MAX_NUMBER;
import static model.number.MAX_NAME_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;

public class utilityModel {
    public static String[] splitByComma(String input){
        return input.split(",");
    }
    public static void isInValidName(String name){
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException();
        }
    }
    public static int stringToInt(String string){
        return Integer.parseInt(string);
    }
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
    int findMaxNumber(ArrayList<Integer> arrayList){
        return Collections.max(arrayList);
    }
}