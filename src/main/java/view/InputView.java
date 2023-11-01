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
     * 사용자가 입력한 자동차 이름들 값 유무검사
     * - 공백일 경우 예외 발생
     *
     * @param carNames
     * @return 예외를 발생 시키지 않으면 true 리턴
     */
    public boolean isCarNames(String carNames){
        if(carNames.isBlank()){
            throw new IllegalArgumentException(ErrorCodeConstant.STRING_BLANK_ERROR);
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
        }

        int tryCountNumber = Integer.parseInt(tryCount);
        if(tryCountNumber > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorCodeConstant.MAX_NUMBER_ERROR);
        } else if (tryCountNumber == GameConstant.TRY_MIN_COUNT) {
            throw new IllegalArgumentException(ErrorCodeConstant.MAX_NUMBER_ERROR);
        }

        return true;
    }

}
