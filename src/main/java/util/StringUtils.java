package util;

import java.util.stream.IntStream;

/**
 * packageName    : util
 * fileName       : StringUtils
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class StringUtils {
    public static String[] splitByDelimiter(String string, String delimiter) {
        return string.split(delimiter);
    }

    public static String[] stripStringArray(String[] array) {
        int length = array.length;
        String[] copyArr = new String[length];
        IntStream.range(0, length).forEach(i -> copyArr[i] = array[i].strip());
        return copyArr;
    }
}
