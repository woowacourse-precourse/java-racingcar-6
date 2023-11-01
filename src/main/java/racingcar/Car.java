package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position =0;


    public Car(String name) {
        validateNull(name);
        validateLengthZero(name);
        validateLengthUnderFive(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }

    public int pickRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
    public void move() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            position++;
        }
    }
    public void validateNull(String str){
        if(str == null) {
            throw new IllegalArgumentException("null을 입력하지 마세요.");
        }
    }
    public void validateLengthZero(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("길이를 0보다 크게 입력하셔야 합니다.");
        }
    }
    public void validateLengthUnderFive(String str){
        if(str.length() > 5) {
            throw new IllegalArgumentException("길이를 5이하로 입력해주세요.");
        }
    }
}