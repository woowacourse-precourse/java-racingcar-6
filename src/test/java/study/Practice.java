package study;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
    public static void main(String[] args) throws IOException {
        String carNames = Console.readLine();

        List<String> carNameList = Arrays.asList(carNames.split(","));

        int movement = Integer.parseInt(Console.readLine());

        List<RacingCar> cars = new ArrayList<>();

        for (String name : carNameList) {
            cars.add(new RacingCar(name));
        }

        for (int i = 0; i < movement ; i++) {
            for (RacingCar car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getMoveHyphen());
            }
            System.out.println();
        }
    }
}

class RacingCar {
    private String name;
    private int position;
   // private Random random;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
        //this.random = new Random();
    }

    public void move() {
        int random = Randoms.pickNumberInRange(0,9);
        if (random >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public String getMoveHyphen() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position ; i++){
            sb.append("-");
        }
        return sb.toString();
    }

}

