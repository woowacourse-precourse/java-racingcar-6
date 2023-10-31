package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.security.PublicKey;
import java.util.List;
import racingcar.validation.Validator;

public class InputView {

  private static final String NAME_DELIMITER = ",";
  private Validator inputValidator;

  public InputView() {
    this.inputValidator = new Validator();
  }

  public List<String> getCarName() {
    String names = readLine();
    return validateCarName(names);
  }

  private List<String> validateCarName(String names) {
    inputValidator.validateNullValue(names);
    List<String> nameList = List.of(names.split(NAME_DELIMITER));
    inputValidator.validateNameLength(nameList);
    inputValidator.validateDuplicatedName(nameList);
    return nameList;
  }

  public int getCount() {
    String count = readLine();
    validateCount(count);
    return Integer.parseInt(count);
  }

  private void validateCount(String count) {
    inputValidator.validateNullValue(count);
    inputValidator.validateNum(count);
  }
}
