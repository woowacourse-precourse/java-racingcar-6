package racingcar.view;

import java.util.regex.Pattern;

public class InputException {

    public void inputSeparatorException(String carNames) throws IllegalArgumentException{
        if(!Pattern.matches("^[a-z|A-Z|ㄱ-ㅎ|가-힣|,]+$",carNames))
           throw new IllegalArgumentException("쉽표(,)를 통해 구분해 주세요.");
    }

    public void inputCarsSizeException(String[] carNames) throws IllegalArgumentException{
        if(carNames.length < 2){
            throw new IllegalArgumentException("자동차는 2대 이상이 경기에 참여해야 합니다.");
        }
    }

    public void inputCarNameOfLengthException(String[] carNames) throws IllegalArgumentException{
        for(String carName : carNames){
            if(carName.length()  > 5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void inputMovingNumberException(String str){
        if(!Pattern.matches("^[1-9]+$",str))
            throw new IllegalArgumentException("숫자외 다른 문자는 쓸 수 없습니다.");
    }
}
