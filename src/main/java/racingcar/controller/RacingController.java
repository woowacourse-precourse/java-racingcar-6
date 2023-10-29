package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Driver;
import racingcar.domain.RandomDriver;
import racingcar.service.Racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingController {
    private Racing racing;
    private int reps;

    public RacingController(Racing racing) {
        this.racing = racing;
    }

    private static final String INPUT_CARNAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_REPS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String OUTPUT_PROGRESS_MESSAGE = "실행 결과";
    private static final String OUTPUT_WINNER_MESSAGE = "최종 우승자";
    public void inputCarNames(){
        System.out.println(INPUT_CARNAME_MESSAGE);
        String userInput = Console.readLine();
        String[] carNames = userInput.split(",");

        List<Car> carList = new ArrayList<>();
        Driver driver = new RandomDriver();
        for(String carName : carNames){
            Car car = new Car(carName, driver);
            carList.add(car);
        }

        racing.setRacingCars(carList);
    }

    public void inputReps(){
        System.out.println(INPUT_REPS_MESSAGE);
        this.reps = Integer.parseInt(Console.readLine());
    }

    private String getNameAndPositionString(Car car){
        String positionString = "";
        for(int i = 0; i < car.getPosition(); i++) {
            positionString += "-";
        }
        List<String> strings = Arrays.asList(car.getName(), positionString);
        return String.join(" : ", strings);
    }

    public void outputProgress(){
        System.out.println();
        System.out.println(OUTPUT_PROGRESS_MESSAGE);
        List<Car> cars = racing.getRacingCars();
        for(int i = 0; i < reps; i++){
            racing.race();
            for (Car car: cars){
                System.out.println(getNameAndPositionString(car));
            }
            System.out.println();
        }
    }

    public void outputWinner(){
        String winners = String.join(", ", racing.getWinner());
        List<String> outputStrings = Arrays.asList(OUTPUT_WINNER_MESSAGE, winners);
        String result = String.join(" : ", outputStrings);
        System.out.println(result);
    }

}
