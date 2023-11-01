package service;

import java.util.HashSet;

public class Validation {
    private final HashSet<String> SET = new HashSet<>();
    private final String PATTERN = "^[0-9]*$";

    public void carNameValidation(final String[] inputArray){
        for(String str: inputArray){
            if (!SET.add(str)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }
            if (str.length() > 5 || str.length() <= 0){
                throw new IllegalArgumentException("이름을 5자 이하, 1자 이상으로 입력하세요.");
            }
            if(str.contains(" ")){
                throw new IllegalArgumentException("이름에 공백을 포함하지 마시오.");
            }
        }
    }
    public String roundInputValidation(final String roundInput){
        if(!roundInput.matches(PATTERN)){
            throw new IllegalArgumentException("횟수 입력은 숫자로만 하세요.");
        }
        if(Integer.parseInt(roundInput) <= 0){
            throw new IllegalArgumentException("횟수는 1 이상 입력하세요.");
        }
        return roundInput;
    }
}
