package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.security.PublicKey;
import java.util.List;
import racingcar.validation.Validator;

public class InputView {
  Validator validator = new Validator();
  public List<String> getCarName() {
    String names = readLine();
    validator.validateNullValue(names);
    List<String> nameList = List.of(names.split(","));
    validator.validateNameLength(nameList);
    validator.validateDuplicatedName(nameList);
    return nameList;
  }
  public int getCount() {
    String count = readLine();
    validator.validateNullValue(count);
    validator.validateNum(count);
    return Integer.parseInt(count);
  }
}
