package view;

import constants.ErrorCodeConstant;
import constants.GameConstant;

/**
 * 사용자 입력에 대한 유효성 검증을 처리한 후 Controller 에 전달하는 클래스
 *
 * @author Ellie
 */
public class InputView {

    /**
     * 사용자가 입력한 자동차 이름 유효성 검사
     * - 자동차가 1 개 이상인지
     * - 공백이 있는지
     * - 5자 이하 인지
     *
     * @param carNames
     * @return 예외를 발생 시키지 않으면 true 리턴
     */
    public boolean validateCarNames(String carNames){
        //TODO. 숫자만 있으면 안되는건가?
        String[] carNameArray = carNames.split(",");
        if(carNameArray.length < GameConstant.CAR_MIN_LENGTH){
            throw new IllegalArgumentException(ErrorCodeConstant.CAR_MIN_LENGTH_ERROR);
        }

        for(String car : carNameArray){
            if(car.isBlank()){
                throw new IllegalArgumentException(ErrorCodeConstant.STRING_BLANK_ERROR);
            } else if(GameConstant.NAME_MAX_LENGTH < car.length()){
                throw new IllegalArgumentException(ErrorCodeConstant.NAME_LENGTH_ERROR);
            }
        }
        return true;
    }


    /**
     * 시도 횟수 유효성 검사
     * - 숫자 외의 문자가 있을 경우 예외 발생
     * - int 정수 최대 범위를 초과할 경우 예외 발생
     *
     * @param tryCount
     * @return 예외를 발생 시키지 않으면 true 리턴
     */
    public boolean validateTryCount(String tryCount){
        final String REGEX = "[0-9]+";

        if(!tryCount.matches(REGEX)) {
            throw new IllegalArgumentException(ErrorCodeConstant.NUMBER_VALIDATION_ERROR);
        } else if(Integer.parseInt(tryCount) > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorCodeConstant.MAX_NUMBER_ERROR);
        }

        return true;
    }

}
