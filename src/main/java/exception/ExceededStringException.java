package exception;

public class ExceededStringException extends IllegalArgumentException{
    public ExceededStringException(){
        super("자동차 이름은 5자 이하만 가능합니다.");
    }
}
