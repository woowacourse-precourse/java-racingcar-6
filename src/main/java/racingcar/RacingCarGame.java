package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RacingCarGame {
    private static RacingCarGame racingCarGame;

    private RacingCarGame() {
    }

    public static RacingCarGame getInstance() {
        if (racingCarGame == null) {
            racingCarGame = new RacingCarGame();
        }
        return racingCarGame;
    }

    public String getCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsName = Console.readLine();
        return carsName;
    }

    public String[] extractCarName(String carsName) {
        String[] carName = carsName.split(",");
        return carName;
    }

    public CustomArrayList<Car> generateCars(String[] carName) {
        CustomArrayList<Car> carList = new CustomArrayList<>();
        int repeatNumber = carName.length;
        int nameOrder = 0;
        while (repeatNumber != 0) {
            carList.add(new Car(carName[nameOrder]));
            repeatNumber--;
            nameOrder++;
        }
        return carList;
    }

    public int getNumberOfRace() {
        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfRace = Integer.parseInt(Console.readLine());
        return numberOfRace;
    }

    public void repeatCarRace(List<Car> carList, int numberOfRace) {
        System.out.println("\n실행 결과");
        while (numberOfRace != 0) {
            carRace(carList);
            System.out.println(carList);
            numberOfRace--;
        }
    }

    private void carRace(List<Car> carList) {
        for (Car car : carList) {
            car.race();
        }
    }

    public List<Car> decideWinner(List<Car> carList) {
        List<Car> winner = new ArrayList<>();
        winner.add(carList.get(0));
        repeatCompareDistance(carList, winner);
        return winner;
    }

    private void repeatCompareDistance(List<Car> carList, List<Car> winner) {
        int countRepeat = 0;
        while (countRepeat < carList.size() - 1) {
            countRepeat = compareDistance(carList, winner, countRepeat);
        }
    }

    private int compareDistance(List<Car> carList, List<Car> winner, int i) {
        if (winner.get(0).getDistance().length() < carList.get(i + 1).getDistance().length()) {
            winner.clear();
            winner.add(carList.get(i + 1));
        } else if (winner.get(0).getDistance().length() == carList.get(i + 1).getDistance().length()) {
            winner.add(carList.get(i + 1));
        }
        i++;
        return i;
    }

    public void printOutWinner(List<Car> winner) {
        StringBuilder sb = new StringBuilder();
        Iterator<Car> it = winner.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getName());
            hasNext(sb, it);
        }
        System.out.print("최종 우승자 : " + sb);
    }

    private void hasNext(StringBuilder sb, Iterator<Car> it) {
        if (it.hasNext()) {
            sb.append(", ");
        }
    }
}
