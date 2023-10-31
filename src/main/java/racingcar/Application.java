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
        int RepeatNumber = UserEnterRepeatNumber();
        System.out.println(RepeatNumber);

    }

    private static int UserEnterRepeatNumber() throws IllegalArgumentException{
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(readLine());
    }

    private static String UserEnterCarName() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
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