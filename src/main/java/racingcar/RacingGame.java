package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static racingcar.InputTryNumberError.isNumeric;
import static racingcar.RandomNumber.pickRandomNumber;
import static racingcar.MoveConditionCar.MovingofNumber;
public class RacingGame {
    public static void main(String[] args) {
        // Assuming you have some way of getting the input from the user
        String[] carNamesArray = new InputCarName().carname.split(",");
        int tryNumber = new InputTryNumber().trynumber;

        Race race = new Race(carNamesArray, tryNumber);
        race.startRace();
    }
}

class InputCarName{
    public String carname;
    public void CarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.carname = Console.readLine(); // readline은 문자열만 받아 올 수있다
        String[] CarNameArray = this.carname.split(",");

        for(String Name : CarNameArray){
            CarNameError.validate(this.carname);
        }
    }
}

class CarNameError {
    public static void validate(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
        }
    }
}

class InputTryNumber{
    public int trynumber;
    private void TryNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        String InputNumber = Console.readLine();
        if(!isNumeric(InputNumber)){
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        this.trynumber=Integer.parseInt(InputNumber);
        if (this.trynumber == 0) {
            throw new IllegalArgumentException("게임이 종료됩니다.");
        }
    }
}

class InputTryNumberError{
    public static boolean isNumeric(String str) {
        String pattern = "^[0-9]*$";
        return Pattern.matches(pattern, str);
    }
}

//class RandomNumber{
//    public static int randomnumber;
//    private void pickRandomNumber(){
//        this.randomnumber = Randoms.pickNumberInRange(0,9);
//    }
//}

class MoveConditionCar{
    public static boolean MovingofNumber(int number){
        return number >=4;
    }
}

class MovingofCar{
    public int moveCnt;
    private void moveCar(){
    if(MovingofNumber(pickRandomNumber())) {
        this.moveCnt++;
    }
    }
}

class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (MoveConditionCar.MovingofNumber(RandomNumber.pickRandomNumber())) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void displayCurrentPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

class Race {
    private List<Car> cars;
    private int rounds;

    public Race(String[] carNames, int rounds) {
        this.rounds = rounds;
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            moveCars();
            displayRoundResult();
            System.out.println();
        }
        displayWinners();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void displayRoundResult() {
        for (Car car : cars) {
            car.displayCurrentPosition();
        }
    }

    private void displayWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.print("최종 우승자 :");
        System.out.print(String.join(", ", winners));
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

// Update the RandomNumber class
class RandomNumber {
    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}