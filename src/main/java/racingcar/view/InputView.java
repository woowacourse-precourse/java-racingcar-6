package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.security.PublicKey;

public class InputView {
  public String getCarName() {
    String input = readLine();
    //validation 검증. (NULL, 1글자 이상 - 5글자 이하, 문자만 입력)
    return input;
  }
  public int getCount() {
    int input = Integer.parseInt(readLine());
    //validation 검증. (숫자만 입력. 자연수만 가능)
    return input;
  }
}
