package Validator;

import Config.GameConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String TOO_LONG_NAME = "너무 긴 이름을 입력하였습니다.";
    private static final String NOTHING = "1글자 이상의 이름을 입력하여야 합니다.";
    private static final String NOT_NUMBER = "숫자를 입력하여야 합니다.";
    private static final String LESS_THEN_ZERO = "0 이상의 숫자를 입력하여야 합니다.";
    private static final String DUPLICATED_NAME = "중복된 이름을 입력하였습니다.";

    public static void nameValidator(List<String> nameList){
        for (String name : nameList){
            if (name.length() == 0){
                throw new IllegalArgumentException(NOTHING);
            }
            else if(name.length() > GameConfig.nameLimit){
                throw new IllegalArgumentException(TOO_LONG_NAME);
            }
        }
        Set<String> nameSet = new HashSet<>(nameList);
        if (!GameConfig.nameDuplication && nameSet.size() != nameList.size()){
            throw new IllegalArgumentException(DUPLICATED_NAME);
        }
    }

    public static void trialValidator(String Trial){
        try{
            int trial = Integer.parseInt(Trial);
            if (trial < 0){
                throw new IllegalArgumentException(LESS_THEN_ZERO);
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }
}
