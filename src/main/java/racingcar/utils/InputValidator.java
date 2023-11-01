package racingcar.utils;

import java.util.*;

public class InputValidator {

    public static String[] checkName(String[] nameList){
        checkNameLength(nameList);
        checkSameName(nameList);
        return nameList;
    }
    public static int checkRoundNum(String inputRound){
        checkIsNumber(inputRound);
        checkNumRange(inputRound);
        return Integer.parseInt(inputRound);
    }

    public static void checkNameLength(String[] nameList){
        for(String tempName : nameList){
            if(tempName.length() < 1 || tempName.length() > 5) throw new IllegalArgumentException();
        }
    }

    public static void checkSameName(String[] nameList){
        List<String> tempList = new ArrayList<>();

        for(String tempName : nameList){
            tempList.add(tempName.trim());
        }

        Set<String> tempSet = new HashSet<>(tempList);

        if(tempList.size() != tempSet.size()) throw new IllegalArgumentException();
    }


    public static void checkIsNumber(String inputRound){
        if(!inputRound.matches("[0-9]+")) throw new IllegalArgumentException();
    }

    public static void checkNumRange(String inputRound){
        int round = Integer.parseInt(inputRound);
        if(round < 1) throw new IllegalArgumentException();
    }
}
