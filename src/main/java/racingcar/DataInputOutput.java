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

    protected List<Car> carList = new ArrayList<Car>();
    private int numTotalMoving;

    public void userInputCarsInfo() {
        // Validate Here
        StringTokenizer tokenizer = new StringTokenizer(Console.readLine(), ",");
        // Validate Here
        while (tokenizer.hasMoreTokens()) {
            Car newCar = new Car();
            newCar.makeCar(tokenizer.nextToken());
            this.carList.add(newCar);
        }
    }

    public void userInputMovingInfo() {
        String userInput = Console.readLine();
        //Validate Here
        this.numTotalMoving = Integer.parseInt(userInput);
    }

    public void printSystemMessage(String whichMsg) {
        switch (whichMsg) {
            case "START" -> System.out.println(INPUT_CAR_NAME_MSG);
            case "INPUT_MOVING" -> System.out.println(INPUT_MOVING_MSG);
            case "OUTPUT_START" -> System.out.println(OUTPUT_RESULT_START);
            case "OUTPUT_END" -> System.out.println(OUTPUT_RESULT_END);
        }
    }

    public void printMovingResult() {
        Car currentCar;

        for (Car car : this.carList) {
            currentCar = car;
            System.out.println(currentCar.getCarName() + " : " + currentCar.getCarPath());
        }
        System.out.println(" ");
    }

    public void printWinner(List<String> winnerList){
        System.out.print("최종 우승자 : " + winnerList.get(0));
        for(int i = 1; i < winnerList.size(); i++){
            System.out.print(", " + winnerList.get(i));
        }
    }

    public boolean makeRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4){
            return true;
        }
        return false;
    }

    public void setNumtotalMoving(int numberToChange){
        this.numTotalMoving = numberToChange;
    }

    public int getNumTotalMoving(){
        return this.numTotalMoving;
    }
}