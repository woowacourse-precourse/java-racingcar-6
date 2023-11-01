package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {

    private List<RacingCar> racingCars;
    private RandomNumGenerator randomNumGenerator;
    private int numOfPlaying;

    public RacingCarGame(){
        this.racingCars = new ArrayList<>();
        this.randomNumGenerator = new RandomNumGenerator();
        this.numOfPlaying = 0;
    }

    private void init(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNum = Console.readLine();

        checkInputValid(carNames,inputNum);

        setNumOfPlaying(Integer.parseInt(inputNum));
        generateListOfRacingCars(carNames);
    }

    private void checkInputValid(String carNames,String inputNum){
        //TODO: carNames 5자리 이하인지 확인

        //TODO: inputNum이 숫자로 변환할수 있는지 확인
    }

    private void generateListOfRacingCars(String carNames){

        List<String> listOfCarNames = stringToListOfString(carNames);

        for(String carName:listOfCarNames){
            RacingCar racingCar = generateRacingCar(carName);
            racingCars.add(racingCar);
        }
    }
    private List<String> stringToListOfString(String carNames){
        return Arrays.asList(carNames.split(","));
    }
    private RacingCar generateRacingCar(String carName){
        return new RacingCar(carName);
    }
    private void setNumOfPlaying(int numOfPlaying) {
        this.numOfPlaying = numOfPlaying;
    }
}
