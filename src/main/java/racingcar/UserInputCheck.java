package racingcar;

/**
 * 사용자 입력 유효성 확인 및 Exception 처리
 */
public class UserInputCheck {
    /**
     * 이름 길이 유효성 확인
     */
    public boolean checkNameLength(String input){
        String[] names = input.split(",");

        for (String name : names){
            if (name.length()>Constant.LIMIT_NAME_LENGTH)
                throw new IllegalArgumentException(Constant.NOT_LENGTH_ERROR_MESSAGE);
        }
        return true;
    }

    /**
     *  숫자 입력 유효성 확인
     */
    public boolean checkNumber(String input){
        try {
            int moveCount = Integer.parseInt(input);
            if (moveCount<1){
                throw new IllegalArgumentException(Constant.NOT_VALID_NUMBER_ERROR_MESSAGE);
            }
            return true;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(Constant.NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
