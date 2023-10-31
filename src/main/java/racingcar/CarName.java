package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class CarName {

  private List<String> carNames;


  public CarName() {
    carNames = new ArrayList<>();
  }

  public List<String> getCarNames() {
    return carNames;
  }

  public void setCarNames(List<String> names) {
    carNames = names;
  }

  public void addCarName(String name) {
    carNames.add(name);
  }

  public void inputCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분합니다)");
    String input = Console.readLine();
    List<String> names = splitAndTrimNames(input);
    exception_Length(names);
    carNames = names;
  }

  private List<String> splitAndTrimNames(String input) {
    String[] nameArray = input.split(",");
    List<String> names = new ArrayList<>();
    for (String name : nameArray) {
      name = name.trim(); // 앞뒤 공백 제거
      name = name.replace(" ", ""); // 중간 공백 제거
      names.add(name);
    }
    return names;
  }

  private void exception_Length(List<String> names) {
    Set<String> uniqeNames = new HashSet<>();

    for (String name : names) {
      if (name.length() > 5 | name.length() < 1) {
        throw new IllegalArgumentException("1자 이상 5자 이하로 입력하세요." + name);
      }
      if (!uniqeNames.add(name)) {
        throw new IllegalArgumentException("동일한 이름은 입력할 수 없습니다." + name);
      }
    }
  }

}
