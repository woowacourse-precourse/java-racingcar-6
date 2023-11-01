package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    private ArrayList<Car> cars = new ArrayList<>();

    public void race() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readLine();

        init(input);

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum = Integer.parseInt(readLine());

        System.out.println("\n실행 결과");
        for (int i = 0; i < tryNum; i++) {
            play();
            print();
        }

        whos_the_winner();
    }

    public void init(String input) {
        String[] names = input.split(",");

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            Car car = new Car(name);
            cars.add(car);
        }
    }

    public void play() {
        for (int i = 0; i < cars.size(); i++) {
            Car thisCar = cars.get(i);
            int randNum = Randoms.pickNumberInRange(0, 9);

            if (randNum >= 4) {
                thisCar.setSteps(thisCar.getSteps() + "-");
            }
        }
    }

    public void print() {
        for (int i = 0; i < cars.size(); i++) {
            Car thisCar = cars.get(i);
            System.out.println(thisCar.getName() + " : " + thisCar.getSteps());
        }
        System.out.println();
    }

    public void whos_the_winner() {
        int i, maxVal;
        List<String> winners = new ArrayList<>();

        // find maximum value
        maxVal = cars.get(0).getSteps().length();
        for (i = 1; i < cars.size(); i++) {
            int len = cars.get(i).getSteps().length();
            maxVal = Math.max(len, maxVal);
        }

        // find winner(s)
        for (i = 0; i < cars.size(); i++) {
            Car thisCar = cars.get(i);

            if (thisCar.getSteps().length() == maxVal) {
                winners.add(thisCar.getName());
            }
        }
        String result = String.join(", ", winners);

        System.out.println("최종 우승자 : " + result);
    }
}
