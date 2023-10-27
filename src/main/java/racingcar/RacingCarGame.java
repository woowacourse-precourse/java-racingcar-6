package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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
        generateRacingCar(carNames);
    }

    private void checkInputValid(String carNames,String inputNum){
        //TODO: carNames 5자리 이하인지 확인

        //TODO: inputNum이 숫자로 변환할수 있는지 확인
    }

    private void generateRacingCar(String carNames){
        //TODO: StringToListOfString() - carNames 문자열에서 List<String>으로 변환

        //TODO: List<String>에서 1개씩 꺼내며 RacingCar 객체 생성 후 List<RacingCar>에 넣기
    }
    private void setNumOfPlaying(int numOfPlaying) {
        this.numOfPlaying = numOfPlaying;
    }
}
