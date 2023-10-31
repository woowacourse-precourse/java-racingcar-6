package racingcar.global.exception;

public class CarGameException extends IllegalArgumentException{
    private CarGameException(ErrorMessage errorMessage){
        super(errorMessage.getMessage());
    }

    public static CarGameException of(ErrorMessage errorMessage){
        return new CarGameException(errorMessage);
    }
}
