package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

class Car {
  private final String name;
  private int position = 0;

  public Car(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("Car name must be under 5 characters.");
    }
    this.name = name;
  }

  public void move() {
    if (Randoms.pickNumberInRange(0, 9) >= 4) {
      position++;
    }
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  @Override
  public String toString() {
    StringBuilder display = new StringBuilder(name + " : ");
    for (int i = 0; i < position; i++) {
      display.append("-");
    }
    return display.toString();
  }
}

class Race {
  private final List<Car> cars;
  private final int rounds;

  public Race(List<String> carNames, int rounds) {
    this.cars = new ArrayList<>();
    for (String name : carNames) {
      cars.add(new Car(name));
    }
    this.rounds = rounds;
  }

  public void run() {
    for (int i = 0; i < rounds; i++) {
      moveCars();
      printRaceStatus();
    }
    printWinners();
  }

  private void moveCars() {
    for (Car car : cars) {
      car.move();
    }
  }

  private void printRaceStatus() {
    for (Car car : cars) {
      System.out.println(car);
    }
    System.out.println();
  }

  private void printWinners() {
    int maxPosition = getMaxPosition();
    List<String> winners = new ArrayList<>();

    for (Car car : cars) {
      if (car.getPosition() == maxPosition) {
        winners.add(car.getName());
      }
    }

    System.out.print("최종 우승자 : ");
    System.out.println(String.join(", ", winners));
  }

  private int getMaxPosition() {
    int max = -1;
    for (Car car : cars) {
      if (car.getPosition() > max) {
        max = car.getPosition();
      }
    }
    return max;
  }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
      System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
      String[] carNames = Console.readLine().split(",");
      System.out.println("시도할 회수는 몇회인가요?");
      int rounds = Integer.parseInt(Console.readLine());

      Race race = new Race(List.of(carNames), rounds);
      race.run();
    }
}
