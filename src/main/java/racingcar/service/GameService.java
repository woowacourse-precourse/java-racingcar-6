package racingcar.service;

import racingcar.exception.InvalidCountException;
import racingcar.exception.InvalidNameException;

import java.util.List;

public class GameService {
    public void validateNames(List<String> carList){
        for(String name : carList) {
            if(name.isEmpty() || name.length() > 5){
                throw new InvalidNameException("이름은 공백일 수 없으며, 5자를 초과할 수 없습니다.");
            }
        }
    }

    public void validateCount(String count){
        try{
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new InvalidCountException("입력한 값이 숫자가 아닙니다.");
        }
    }
}
