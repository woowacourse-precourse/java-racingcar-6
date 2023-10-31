package util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

/**
 * packageName    : util
 * fileName       : RandomGenerator
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class RandomGenerator {

    public static int generateNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
