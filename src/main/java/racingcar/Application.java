package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        int tries;
        int highestScore;
        String[] carNames = validateCarName();
        List<Car> cars = new ArrayList<>();

        // String[]로 되어 있는 차 이름들을
        // Car클래스 안에 메소드들을 구현하고 사용하기 위해 List<Car>로 변환
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        tries = validateAndParseTry();

        runRace(cars, tries);

        highestScore = setHighestScore(cars);

        printWinner(cars,highestScore);
    }

    /**
     * 유저의 차 이름 입력을 받아 유효성을 검사하고 쉼표를 기준으로 나눠 String[]로 리턴
     * @return String[] carNames
     */
    public static String[] validateCarName(){
        String carInput = readLine();
        if (carInput == null || carInput.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] carNames = carInput.split(",", -1);

        if (carNames.length == 0) {
            throw new IllegalArgumentException();
        } else if (carNames.length >= 5) {
            throw new IllegalArgumentException();
        }

        for (String name : carNames){
            if (name.trim().isEmpty()){
                throw new IllegalArgumentException();
            }
            if (name.length() > 5){
                throw new IllegalArgumentException();
            }
            if (name.matches("\\d+")){
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    /**
     * 유저의 게임을 시도할 횟수를 입력 받아 유효성을 검사하고 int로 바꿔 리턴
     * @return int tires
     */
    public static int validateAndParseTry(){
        String tryInput = readLine();
        int tries;
        if (tryInput == null || tryInput.isEmpty()) {
            throw new IllegalArgumentException();
        }

        try {
            tries = parseInt(tryInput);
        } catch (Exception e){
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
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
            System.out.println("실행 결과 : " + i);
            for (Car car : cars){
                boolean canMove = car.canMove();
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
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
