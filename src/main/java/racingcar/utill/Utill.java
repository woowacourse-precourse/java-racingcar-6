package racingcar.utill;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Utill {

    public static String inputString() {
        String inputStr = readLine();

        ValidException.includeNum(inputStr);
        ValidException.blankCheck(inputStr);
        ValidException.includeBlank(inputStr);
        ValidException.includeSpecialString(inputStr);

        return inputStr;
    }

    public static Integer inputNum() {
        String inputStr = readLine();

        ValidException.blankCheck(inputStr);
        ValidException.includeBlank(inputStr);
        ValidException.includeString(inputStr);
        ValidException.includeSpecialString(inputStr);
        ValidException.zeroNum(inputStr);
        ValidException.negative(inputStr);

        Integer inputNum = parseInt(inputStr);
        return inputNum;
    }

    public static Integer parseInt(String str) {
        return Integer.valueOf(str);
    }

    /**
     * string을 regex의 기준으로 구분을 하여 배열로 반환
     *
     * @param string arr으로 만들고 싶은 string
     * @param regex  string을 배열로 만드는 기준
     * @return
     */
    public static String[] makeArrFromString(String string, String regex) {
        return string.split(regex);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static <T> List<T> makeListFromArr(T[] arr) {
        return List.of(arr);
    }

    public static boolean isSameNum(int num_1, int num_2) {
        return Integer.compare(num_1, num_2) == 0;
    }

    /**
     * 값이 1이상 확인.
     *
     * @param num
     * @return
     */
    public static boolean isGreaterThanAndEqualOne(int num) {
        return num >= 1;
    }
}
