package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public boolean validateLength(String checkStr, int length){
        if(checkStr.length() <= length){
            return true;
        }
        // if string length over standard lenth, return false
        return false;
    }
    public boolean validateDuplicate(List<String> nameSet){
        Set<String> set = new HashSet<>(nameSet);

        if(set.size() == nameSet.size()){
            return true;
        }
        // if there are duplicate things, return false
        return false;
    }
    public void validateEmptySpace(){}
    public void validateDataType(){}
    public void validateDomain(){}
}
