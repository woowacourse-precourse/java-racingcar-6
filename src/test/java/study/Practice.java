package study;

<<<<<<< HEAD
=======
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

>>>>>>> origin/MyStraw
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carNames = br.readLine();
        // String[] carName = carNames.split(",");
        List<String> carNameList = Arrays.asList(carNames.split(","));
        // int n = carName.length;
        int movement = Integer.parseInt(br.readLine());

        List<ownCar> cars = new ArrayList<>();

        for (String name : carNameList) {
            cars.add(new ownCar(name));
        }

        for (int i = 0; i < movement ; i++) {
            for (ownCar car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getPosition());
            }
            System.out.println();
        }
    }
}

class ownCar {
    private String name;
    private int position;
    private Random random;

    public ownCar(String name) {
        this.name = name;
        this.position = 0;
        this.random = new Random();
    }

    public void move() {
        if (random.nextInt(10) >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}

