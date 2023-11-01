package view;

import constants.ErrorCodeConstant;

/**
 * 사용자 입력에 대한 유효성 검증을 처리한 후 Controller 에 전달하는 클래스
 *
 * @author Ellie
 */
public class InputView {

    /**
     * 사용자가 입력한 값 유무검사
     * - 공백일 경우 예외 발생
     *
     * @param data
     * @return 예외를 발생 시키지 않으면 true 리턴
     */
    public boolean isBlank(String data){
        if(data.isBlank()){
            throw new IllegalArgumentException(ErrorCodeConstant.STRING_BLANK_ERROR);
        }

        return true;
    }

}
