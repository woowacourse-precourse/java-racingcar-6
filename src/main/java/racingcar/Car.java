package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
  private final String name;
  private int position = 0;
  
  public Car(String name) {
    validateName(name);
    this.name = name;
  }
  private void validateName(String name) {
    if(name == null || name.length() > 5) {
      throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
  }
  public void move() {
    int randomNumber = Randoms.pickNumberInRange(0, 9);
    if(randomNumber >= 4) {
      position++;
    }
  }
  
  public int getPosition() {
    return position;
  }
  
  public String getName() {
    return name;
  }
  
  public void printStatus() {
    System.out.println(getName() + " : " + "-".repeat(getPosition()));
  }
}