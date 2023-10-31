package racingcar;

public class Car {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getProgress() {
    return progress;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

  private int progress;
  public Car(String name) {
    this.name = name;
    this.progress = 0;
  }
}
