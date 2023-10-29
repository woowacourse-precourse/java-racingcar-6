package util;

import java.util.Arrays;
import java.util.List;

public class Validator {
    private final static int CHARACTERS_LIMIT = 5;
    private final static int MAX_TRIAL = 1000;

    public static List<String> validateCarNames(String names){
        List<String> nameList = Arrays.stream(names.split(",")).toList();
        if(exceedsFiveLength(nameList) || haveDuplicateName(nameList)){
            throw new IllegalArgumentException(
                    String.format(String.valueOf(Messages.ERROR_NAME_LENGTH), CHARACTERS_LIMIT));
        }
        return nameList;
    }
    public static int validateTrial(String beforeParsedTrial){
        int trial;
        try{
            trial = Integer.parseInt(beforeParsedTrial);
            if(isMinus(trial)){
                throw new IllegalArgumentException(String.format(String.valueOf(Messages.ERROR_TRIAL_NUMBER), trial));
            }
            if(exceedsMaxTrial(trial)){
                throw new IllegalArgumentException(String.valueOf(Messages.ERROR_EXCEED_MAX_RANGE));
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(String.valueOf(Messages.ERROR_NOT_NUMBER));
        }
        return trial;
    }

    private static boolean exceedsFiveLength(List<String> names){
        return names.stream().anyMatch(name->name.length() > CHARACTERS_LIMIT);
    }
    private static boolean haveDuplicateName(List<String> names){
        return names.stream().distinct().count() != names.size();
    }
    private static boolean isMinus(int trial){
        return trial < 0;
    }
    private static boolean exceedsMaxTrial(int trial){
        return trial > MAX_TRIAL;
    }

}
