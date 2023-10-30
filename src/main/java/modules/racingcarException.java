package modules;

public class racingcarException {
    public static void exception_len_5(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
    public static void exception_not_int(String num) {
        try{
            Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
