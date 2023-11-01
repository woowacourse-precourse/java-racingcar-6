package service;

public class Validation {

    public void carNameValidation(final String[] inputArray){
        for(String str: inputArray){
            if (str.length() > 5 || str.length() <= 0){
                throw new IllegalArgumentException("이름을 5자 이하, 1자 이상으로 입력하세요.");
            }
            if(str.contains(" ")){
                throw new IllegalArgumentException("이름에 공백을 포함하지 마시오.");
            }
        }
    }
}
