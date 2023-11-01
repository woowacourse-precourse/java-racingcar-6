package model;

import constants.ErrorCodeConstant;
import constants.GameConstant;

public class Car {
    String name;
    int stepCount;

    public Car(){}
    public Car(String name){
        this.name = name;
    }

    /**
     * 사용자가 입력한 자동차 이름 유효성 검사
     * - 공백일 경우 예외 발생
     * - 5자 이하일 경우 예외 발생
     *
     * @param carName
     * @return 예외를 발생 시키지 않으면 true 리턴
     */
    public static boolean validateCarName(String carName){
        if(carName.isBlank()){
            throw new IllegalArgumentException(ErrorCodeConstant.STRING_BLANK_ERROR);
        } else if(GameConstant.MAX_NAME_LENGTH < carName.length()){
            throw new IllegalArgumentException(ErrorCodeConstant.NAME_LENGTH_ERROR);
        }
        return true;

    }

    //전진 가능한 랜덤 수 얻기()

    //전진 랜덤 수 판단하기()

}
