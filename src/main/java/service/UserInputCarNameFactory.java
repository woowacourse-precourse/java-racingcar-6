package service;

import ui.Input;

import java.util.Arrays;

public class UserInputCarNameFactory {

    //Input 데이터 가공
    private String[] processCarNameInput() {
        return Arrays.stream(Input.input.split(","))
                .map(String::trim)
                .peek(carName -> {
                    if (!isValid(carName)) {
                        throw new IllegalArgumentException("5글자를 초과했습니다.");
                    }
                })
                .toArray(String[]::new);
    }

    private boolean isValid(String carName){
        return carName.length()<=5;
    }
}
