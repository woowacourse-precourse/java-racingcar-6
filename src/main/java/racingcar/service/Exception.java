package racingcar.service;

public class Exception {

    //자동차이름 5글자 이하 아닐 때
    public void carNameLength(String carName){
        if (carName.length()>5){
            throw new IllegalArgumentException("자동차 이름의 길이는 5글자 이하만 가능합니다.");
        }
    }

    //자동차이름 숫자일때
    public void carNameIsDigit(String carName){
        if (carName.matches("\\d+")) {
            throw new IllegalArgumentException("자동차 이름은 숫자로 구성될 수 없습니다.");
        }}

    //tryNumber가 숫자 아닐 때
    public void tryNumber (String tryNumber){
        //if (tryNumber.)
    }
}
