package racingcar;

public class OutputManager {
  public void displayCarPositions(Car[] cars) {
    for (Car car : cars) {
      System.out.print(car.getName() + ": ");
      for (int i = 0; i < car.getPosition(); i++) {
        System.out.print("-");
      }
      System.out.println();
    }
    System.out.println();
  }

  public void announceWinners(Car[] cars) {
    int maxPosition = 0;
    for (Car car : cars) {
      if (car.getPosition() > maxPosition) {
        maxPosition = car.getPosition();
      }
    }

    System.out.print("최종 우승자: ");
    boolean isFirstWinner = true;
    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        if (!isFirstWinner) {
          System.out.print(", ");
        }
        System.out.print(car.getName());
        isFirstWinner = false;
      }
    }
  }
}
