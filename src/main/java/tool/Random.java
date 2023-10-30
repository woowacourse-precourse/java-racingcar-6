package tool;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {

  // 지정 범위 내에서 생성된 랜덤 숫자가 value 값을 넘으면 true 리턴
  public static boolean isRandOverValueInRange(final int begin, final int end, final int value) {
    int rand = Randoms.pickNumberInRange(begin, end);
    return rand >= value;
  }
}
