package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 1;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name.length() > 5){
            throw new IllegalArgumentException("5글자 이하로 입력하세요.");
        }
    }

    public static Integer moving(){

    }



}
