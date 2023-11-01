package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    private List<Car> cars = new ArrayList<>();
    private int tryNumber;

    public static void main(String[] args) {
        Application game = new Application();
        game.getName();
    }

    public void getName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        StringTokenizer tokenizer = new StringTokenizer(carNamesInput, ",");

        while (tokenizer.hasMoreTokens()) {
            String carName = tokenizer.nextToken().trim();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(carName));
        }
    }

    class Car {
        private String name;
        private int position;

        public Car(String name) {
            this.name = name;
            this.position = 0;
        }

    }
}