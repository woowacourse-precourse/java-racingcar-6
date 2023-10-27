package racingcar;

public class Validate {
    public boolean validateLength(String checkStr, int length){
        if(checkStr.length() <= length){
            return true;
        }
        return false;
    }
    public void validateDuplicate(){}
    public void validateEmptySpace(){}
    public void validateDataType(){}
    public void validateDomain(){}
}
