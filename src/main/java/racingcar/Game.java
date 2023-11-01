package racingcar;


/*
   [] (5) "실행 결과 \n" 을 출력하는 메서드 printExecuteText()
   [] (6) 프로그램을 실행하면 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
   를 출력하는 기능 -> printStartGameText()
   [] (7) 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. -> isCarNameLengthFive()
   [ ] (8) 자동차 이름을 입력하는 기능 -> inputCarName()
   [ ] (9) 시도할 회수는 몇회인가요? 를 출력하는 기능 -> printHowManyCounts()
   [ ] (10) 플레이어가 회수를 입력하는 기능 -> inputCounts()
   [ ] (11) 입력받은 회수가 올바른지 검증하는 기능 -> isCountsValid()
/* 프로그램 흐름 -> 기능 7 실행, 기능 8 실행 후 String carNames에 저장,
   기능 9 실행, 기능 10 실행 후 int counts에 저장.
   carNames를 split해서 넣을때, 해당 carName들이 올바른 입력인지 확인하는 메서드 필요
   -> isCarNameLengthFive(), true이면 giveNameOfCar(carNames.split(","))
    false이면 throw Exception.
   모든 입력이 올바르다면 기능 8, 기능 11을 실행하고
   결과가 true라면
   입력 횟수만큼 List<Car> Cars에 대해서 carMoveOrStop(),
   printMovingCarWithCarName() 실행
   이후 Winner 클래스의 기능 (12), (13) 사용
 */
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
public class Game {
    private int counts;
    private String carNames;
    // 기능 5 작성: printExecuteText()
    public String printExecuteText() {
        return "실행 결과 \n";
    }
    // (6) 프로그램을 실행하면 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    //   를 출력하는 기능 -> printStartGameText()
    public String printStartGameText() {
        return "";
    }
    public boolean isCarNameLengthFive(String carName) {
        return carName.length() <= 5;
    }
    public void inputCarName() {
        carNames = Console.readLine();
    }
    public String printHowManyCounts() {
        return "";
    }
    public void inputCounts() {
        counts = Integer.parseInt(Console.readLine());
    }
    public boolean isCountsValid() {
       return false;
    }



}
