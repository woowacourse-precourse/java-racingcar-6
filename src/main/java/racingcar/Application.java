package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. 자동차 이름 입력
        List<Car> carList = checkCarName();

        // 2. 시도 회수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNum = Console.readLine();
        int num = Integer.parseInt(inputNum);

        // 3. 차수별 실행 결과 출력
        System.out.println("실행 결과");
        for (int i = 0; i < num; i++) {
            //System.out.println("시도 회수 : " + (i + 1));
            moveCar(carList);
            System.out.println();
        }

        // 4. 최종 우승자 출력
        System.out.println("최종 우승자 : " + getWinners(carList));
    }

    public static List<Car> checkCarName() {
        List<Car> carList = new ArrayList<>();

        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputCarName = Console.readLine();
            String[] carNames = inputCarName.split(",");

            boolean fiveLetters = true;

            for (String name : carNames) {
                if (name.length() <= 5) {
                    carList.add(new Car(name));
                } else {
//                    System.out.println("자동차 이름은 5자 이하로 입력하세요.");
//                    fiveLetters = false;
//                    carList.clear();
//                    break;
                    throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력하세요.");
                }
            }
            if (fiveLetters) {
                break;
            }
        }
        return carList;
    }

    public static void moveCar(List<Car> carList) {
        for (Car car : carList) {
            car.move();
        }
        showCarCount(carList);
    }

    public static void showCarCount(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getCountResult());
        }
    }

    public static String getWinners(List<Car> carList) {
        int maxCount = 0;
        for (Car car : carList) {
            maxCount = Math.max(maxCount, car.getCount());  //현재까지 가장 큰 이동거리 저장
            //System.out.println(maxCount);
        }

        StringBuilder winners = new StringBuilder();    //최종 우승자 이름 저장
        for (Car car : carList) {
            if (car.getCount() == maxCount) {   //현재 이동한 거리가 maxCount와 같다면 winners 문자열에 추가
                winners.append(car.getName()).append(", ");
            }
        }
        return winners.substring(0, winners.length() - 2);  //마지막 ',' 표시 제거
    }
}

class Car {
    private final String name;
    private int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            count++;
        }
    }
    public String getCountResult() {
        StringBuilder resultLine = new StringBuilder();
        for (int i = 0; i < count; i++) {
            resultLine.append("-");
        }
        return resultLine.toString();
    }
}