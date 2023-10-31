package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();

        String[] carNames = inputManager.getCarNames();
        int attempts = inputManager.getAttempts();

        Race race = new Race(Arrays.asList(carNames), attempts);
        race.startRace();
        race.printWinners();
    }
}

class Car {
    private String name;
    private int position=0;

    public Car(String name){
        this.name=name;
    }

    public void move(){
        if(RandomGenerator.pickNumberInRange(0,9)>=4){
            position++;
        }
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }
}

class Race {
    private List<Car> carList;
    private  int attempts;

    public Race(List<String> carNames, int attempts){
        this.carList= createCarsFromNames(carNames);
        this.attempts=attempts;
    }

    private List<Car> createCarsFromNames(List<String> carNames){
        return carNames.stream().map(Car::new).toList();
    }

    public void startRace(){
        for(int i=0; i<attempts; i++){
            raceOnce();
            System.out.println();
        }
    }

    private void raceOnce(){
        carList.forEach(this::moveCarAndDisplayPosition);
    }

    private void moveCarAndDisplayPosition(Car car){
        car.move();
        printCarPosition(car);
    }

    private void printCarPosition(Car car){
        System.out.println(car.getName()+" : "+"-".repeat(car.getPosition()));
    }

    public void printWinners(){
        int maxPosition = carList.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = carList.stream().filter(car->car.getPosition()==maxPosition)
                .map(Car::getName).toList();

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

class RandomGenerator{
    public static int pickNumberInRange(int start, int end){
        return Randoms.pickNumberInRange(start,end);
    }
}

class InputValidator{
    private static final int MAX_CAR_NAME_LENGTH=5;

    public static void checkCarNames(String[] carNames){
        for(String name : carNames){
            if(name.length()>MAX_CAR_NAME_LENGTH){
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
            }
        }
    }

    public static void checkAttempts(int attempts){
        if(attempts<=0){
            throw new IllegalArgumentException("시도 횟수는 1이상이어야 합니다.");
        }
    }
}

class InputManager {

    public String[] getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        for(int i=0; i<carNames.length; i++){
            carNames[i] = carNames[i].strip();
        }
        InputValidator.checkCarNames(carNames);
        return carNames;
    }

    public int getAttempts(){

        System.out.println("시도할 횟수는 몇회인가요?");
        int attempts;

        try{
            attempts = Integer.parseInt(Console.readLine());
            InputValidator.checkAttempts(attempts);
        }catch (IllegalArgumentException e){
            System.out.println("유효한 숫자를 입력하세요.");
            return getAttempts();
        }

        return attempts;
    }

}
