package racingcar;

public class Exception {

    public void exceptionOfNameLength(String[] split) {
        for (String s : split) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

}
