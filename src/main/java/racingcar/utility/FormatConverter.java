package racingcar.utility;

public class FormatConverter {

    public static String convertNumberToDash(int number) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

}
