package racingcar.utill;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Utill {

    /**
     * 문자열 입력을 한다.
     */
    public static String inputString() {
        String inputStr = readLine();

        ValidException.isValidIncludeNum(inputStr); // 숫자을 포함하는가 검사
        ValidException.isValidBlankCheck(inputStr); // 공백입력 검사
        ValidException.isValidIncludeBlank(inputStr); // 공백포함 검사
        ValidException.isValidIncludeSpecialString(inputStr); // 특수기호 포함 검사.

        return inputStr;
    }

    /**
     * 숫자입력
     *
     * @return
     */
    public static Integer inputNum() {
        String inputStr = readLine();

        ValidException.isValidBlankCheck(inputStr); // 공백 입력 검사
        ValidException.isValidIncludeBlank(inputStr); // 공백 포함 검사
        ValidException.isValidIncludeString(inputStr); // 문자열 포함 검사
        ValidException.isValidIncludeSpecialString(inputStr); // 특수문자 포함 검사
        ValidException.isValidZeroCheck(inputStr); // 0 입력 검사
        ValidException.isValidPositiveCheck(inputStr); // 양수 입력 검사

        Integer inputNum = parseInteger(inputStr);
        return inputNum;
    }

    /**
     * 숫자 변환
     *
     * @param str
     * @return
     */
    public static Integer parseInteger(String str) {
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

    /**
     * print new Line
     */
    public static void printNewLine() {
        System.out.println();
    }

    /**
     * print 메서드
     *
     * @param str
     */
    public static void print(String str) {
        System.out.println(str);
    }

    /**
     * 배열을 리스트로 만들어준다.
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> List<T> makeListFromArr(T[] arr) {
        return List.of(arr);
    }

    /**
     * num_1 과 num_2의 숫자가 같으면 true
     *
     * @param num_1
     * @param num_2
     * @return
     */
    public static boolean isSameNum(int num_1, int num_2) {
        return Integer.compare(num_1, num_2) == 0;
    }

    /**
     * 값이 1이상인지 확인한다.
     *
     * @param sizeOfWinnerList
     * @return
     */
    public static boolean valueGreaterThanEqualOne(int sizeOfWinnerList) {
        return sizeOfWinnerList >= 1;
    }
}
