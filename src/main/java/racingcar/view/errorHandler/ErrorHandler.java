package racingcar.view.errorHandler;

import static racingcar.constant.Limits.MAX_NAME_SIZE;

public class ErrorHandler {
    public void initialHandler(String[] car, String numString){
        nameHandler(car);
        trialHandler(numString);
    }

    public void nameHandler(String[] car) {
        for (String name : car) {
            if (name.length() > MAX_NAME_SIZE) {
                throw new IllegalArgumentException("사용 가능한 최대 글자수는 5 입니다.");
            }
            if(name.equals("")){
                throw new IllegalArgumentException("공백을 입력할 수 없습니다..");
            }
        }
    }

    public void trialHandler(String numString) {
        if (numString.equals("")) {
            throw new IllegalArgumentException("플레이 횟수를 기입하지 않았습니다.");
        }
        if(numString.matches("[^0-9]")){
            throw new IllegalArgumentException("플레이 횟수는 정수만 가능합니다.");
        }
    }
}
