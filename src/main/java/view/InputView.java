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
     * @return true or false
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

    //TODO. 시도 횟수 유효성 검사()

}
