package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        StartGame();
    }

    private static void StartGame() {
        String carNameInput = UserEnterCarName();
        Car[] cars = MakeCarObject(carNameInput);
        for(int i=0; i<cars.length; i++){
            System.out.println(cars[i].name+" "+cars[i].meter);
        }
    }

    private static String UserEnterCarName() {
        return readLine();
    }

    private static Car[] MakeCarObject(String carNameInput) {
        String[] carNames = carNameInput.split(",");
        Car[] cars = new Car[carNames.length];
        for(int i=0; i<carNames.length; i++){
            cars[i] = new Car(carNames[i]);
        }

        return cars;
    }

    static class Car {
        String name;
        int meter;

        public Car(String name) {
            this.name = name;
            int meter = 0;
        }
    }

}


//    pickNumberInRange(1,9);
//    readLine();