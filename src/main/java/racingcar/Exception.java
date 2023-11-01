package racingcar;

import java.util.HashSet;
import java.util.List;

public class Exception {
  static void checkDuplicated(List<String> cars){
    HashSet<String> uniqueStrings = new HashSet<>(cars);
    if(uniqueStrings.size() !=cars.size()){
      throw new IllegalArgumentException("중복된 이름이 존재합니다");

    }
  }
}
