package exceptional;

public class ExceptionalTry {


    private ExceptionalTry(){
    }
    public static Error exception(){
        throw new IllegalArgumentException("숫자만 작성해주세요.");
    }

}
