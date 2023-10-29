package racingcar.controller;

public class NameValidator {

    public void isValidName(String name){
        isValidLength(name);
        isAlphabetString(name);
    }

    public void isValidLength(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("이름은 5자 이하만 가능하다.");
        }
    }

    public void isAlphabetString(String name){
        for(char c : name.toCharArray()){
            isAlphabetChar(c);
        }
    }

    public void isAlphabetChar(char ch){
        if(!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))){
            throw new IllegalArgumentException("알파벳이 아닙니다.");
        }
    }
}
