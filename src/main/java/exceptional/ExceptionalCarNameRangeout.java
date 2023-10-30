package exceptional;

public class ExceptionalCarNameRangeout {
    private ExceptionalCarNameRangeout(){
    }
    public static Error exception(){
        throw new IllegalArgumentException("5글자 초과");
    }
}
