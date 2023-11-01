package racingcar.domain;

public class Car {

  private final String name;
  private final int NAME_SIZE = 6;
  private int position = 0;

  public Car(String name) {
    validateNameSize(name);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public void forward() {
    this.position++;
  }

  private void validateNameSize(String name) {
    if (name.length() >= NAME_SIZE) {
      throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
    }
  }
}
