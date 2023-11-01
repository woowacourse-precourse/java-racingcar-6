package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

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
    
    if(name.length()>5 || name.isEmpty()){
      throw new IllegalArgumentException("name의 양식에 어긋납니다");
    }
   
  }

  public boolean isProgress() {
    int pickedNumber = Randoms.pickNumberInRange(0, 9);

    return pickedNumber >= 4;
  }
}
