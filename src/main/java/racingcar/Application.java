package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int tries;
        int highestScore;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = readLine();
        String[] carNames = validateCarName(carInput);

        List<Car> cars = createCarsFromNames(carNames);

        System.out.println("시도할 횟수는 몇회인가요?");
        String tryInput = readLine();
        tries = validateAndParseTry(tryInput);

        runRace(cars, tries);

        highestScore = setHighestScore(cars);

        printWinner(cars,highestScore);
    }

    /**
     * 유저의 차 이름 입력을 받아 유효성을 검사하고 쉼표를 기준으로 나눠 String[]로 리턴
     * @return String[] carNames
     */
    public static String[] validateCarName(String carInput){
        if (carInput == null || carInput.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] carNames = carInput.split(",", -1);

        if (carNames.length == 0) {
            throw new IllegalArgumentException();
        }

        for (String name : carNames){
            if (name.trim().isEmpty()){
                throw new IllegalArgumentException();
            }
            if (name.length() > 5){
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    /**
     * String[]에 들어가 있는 차 이름들을 Car라는 클라스로 생성하면서 List에 담음
     * @param carNames
     * @return List<Car> cars
     */
    public static List<Car> createCarsFromNames(String[] carNames){
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    /**
     * 유저의 게임을 시도할 횟수를 입력 받아 유효성을 검사하고 int로 바꿔 리턴
     * @return int tires
     */
    public static int validateAndParseTry(String tryInput){
        int tries;
        if (tryInput == null || tryInput.isEmpty() || !tryInput.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
        tries = parseInt(tryInput) ;
        return tries;
    }

    /**
     * Car 클라스를 가지고 있는 list를 for each로 나누고
     * Car 클래스 안에 있는 메소드 사용
     * @param cars
     * @param tries
     */
    public static void runRace(List<Car> cars, int tries){
        for (int i = 0; i < tries; i++) {
            System.out.println("실행 결과 : " + (i+1));
            for (Car car : cars){
                int number = Randoms.pickNumberInRange(0,9);
                boolean canMove = car.canMove(number);
                car.move(canMove);
                System.out.println(car.display());
            }
            System.out.println();
        }
    }

    /**
     * Car클라스 안에 있는 getScore()메소드를 활용하여 최고점 점수 리턴
     * @param cars
     * @return int highestScore
     */
    public static int setHighestScore(List<Car> cars){
        int highestScore = 0;
        for (Car car : cars) {
            if (car.getScore() > highestScore) {
                highestScore = car.getScore();
            }
        }
        return highestScore;
    }

    /**
     * List<Car> cars 안에 highestScore 점수와 같은 점수가 있다면 출력
     * @param cars
     * @param highestScore
     */
    public static void printWinner(List<Car> cars, int highestScore){
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getScore() == highestScore) {
                winners.add(car.name);
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
