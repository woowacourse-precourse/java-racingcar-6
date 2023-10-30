package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public boolean validateLength(String checkStr, int lengthLimit){
        // If String Length over Length Limit, Throw IllegalArgumentException
        if(checkStr.length() <= lengthLimit){
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean validateDuplicate(List<String> nameSet){
        // Try to Remove Duplicate Things
        Set<String> set = new HashSet<>(nameSet);

        // If There Are Duplicate Things, Throw IllegalArgumentException
        if(set.size() == nameSet.size()){
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void validateEmptySpace(String toCheckStr){
        toCheckStr = toCheckStr.replaceAll(" ","");
        if(toCheckStr.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    public int validateDataType(String toCheckStf){
        int returnVal;

        try{
            returnVal = Integer.parseInt(toCheckStf);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }

        return returnVal;
    }
}
