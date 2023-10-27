package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataInputOutput {
    static final String INPUT_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    static final String INPUT_MOVING_MSG = "시도할 회수는 몇회인가요?";
    static final String OUTPUT_RESULT_START = "실행 결과";
    static final String OUTPUT_RESULT_END = "최종 우승자";

    private static List<Car> carList = new ArrayList<Car>();
    private static int numTotalMoving;

    public void userInputCarsInfo(){
        // Validate Here
        StringTokenizer tokenizer = new StringTokenizer(Console.readLine(), ",");
        // Validate Here
        while(tokenizer.hasMoreTokens()){
            Car newCar = new Car();
            newCar.makeCar(tokenizer.nextToken());
            carList.add(newCar);
        }
    }
    public void userInputMovingInfo(){
        String userInput = Console.readLine();
        //Validate Here
        numTotalMoving = Integer.parseInt(userInput);
    }
    public void printSystemMessage(String whichMsg){
        switch (whichMsg) {
            case "START" -> System.out.println(INPUT_CAR_NAME_MSG);
            case "INPUT_MOVING" -> System.out.println(INPUT_MOVING_MSG);
            case "OUTPUT_START" -> System.out.println(OUTPUT_RESULT_START);
            case "OUTPUT_END" -> System.out.println(OUTPUT_RESULT_END);
        }
    }
    public void printMovingResult(){}
    public void makeRandomNumber(){}
}
