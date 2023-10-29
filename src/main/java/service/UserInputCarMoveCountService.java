package service;

import com.sun.jdi.InvalidTypeException;
import dto.UserInputCarMoveCountDto;
import ui.Input;

public class UserInputCarMoveCountService {

    public UserInputCarMoveCountDto createUserInputCarMoveCountDto() throws InvalidTypeException {

        int moveCount;

        //숫자 이외 입력 예외
        try{
            moveCount = Integer.parseInt(Input.input);
        }catch(NumberFormatException e){
            throw new InvalidTypeException("숫자만 입력해주세요");
        }

        //TODO 너무 큰 숫자 입력 예외
        return new UserInputCarMoveCountDto(moveCount);
    }
}
