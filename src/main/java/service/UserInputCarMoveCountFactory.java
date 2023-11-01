package service;

import com.sun.jdi.InvalidTypeException;
import dto.UserInputCarMoveCountDto;
import ui.Input;

public class UserInputCarMoveCountFactory {

    public UserInputCarMoveCountDto createUserInputCarMoveCountDto() throws InvalidTypeException {

        long moveCount;

        //숫자 이외 입력 예외 && 너무 큰 숫자 입력 시 예외
        try{
            moveCount = Long.parseLong(Input.input);
            if(moveCount>Integer.MAX_VALUE) throw new IllegalArgumentException("너무 큰 숫자는 입력할 수 없습니다");
        }catch(NumberFormatException e){
            throw new InvalidTypeException("숫자만 입력해주세요");
        }

        return new UserInputCarMoveCountDto(moveCount);
    }
}
