package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;
public class Game {

    private Cars cars;
    private TryCount tryCount;
    public Game(){
        gameController();
    }

    private void gameController(){
        initializationCarName();
        initializationTryCount();
        executionResult();
        finalWinner();
    }
    // 사용자로부터 자동차 이름을 받아오고 이를 통해 Cars를 초기화.
    private void initializationCarName() {
        Output.printCarName();
        String carNameString = Input.user();
        String[] carNameList = carNameString.split(",");
        cars = new Cars(carNameList);

    }

    // 사용자로부터 시도 횟수 받아오고 tryCount 초기화
    private void initializationTryCount(){
        Output.printTryCount();
        this.tryCount = new TryCount(Input.user());

    }

    // 각 시도 횟수마다 자동차의 상태를 나타냄
    private void executionResult(){
        Output.printExecutionResult();
        for(int i = 0; i < this.
                tryCount.getTryCount(); i++){

            carDistance();
            Output.printMessage("");
        }
    }

    // 각 시도 횟수마다 각 자동차의 이동 거리를 나타냄
    private void carDistance(){
        for(int i = 0; i < cars.getCarsSize(); i++){
            Car car = cars.getCars()
                    .get(i);

            if (randomNumberGenerator() >= 4){
                car.addDistance("-");
            }

            Output.printCarDistance(car.getName(), car.getDistance());
        }

    }

    // 난수 생성
    private Integer randomNumberGenerator(){
        return Randoms.pickNumberInRange(0, 9);
    }

    // 최종 우승자 결정하고 이를 화면에 출력력.
    private void finalWinner(){
        List<String> winnerName = new ArrayList<>();
        Integer maxDistance = cars.maximumDistance();
        finalWinnerNameList(winnerName, maxDistance);
        String winnerString = String.join(", ", winnerName);
        Output.printFinalWinner(winnerString);

    }

    private void finalWinnerNameList(List<String> winnerName, Integer maxDistance){
        for(int i = 0; i < cars.getCarsSize(); i++){
            Car car = cars.getCars()
                    .get(i);

            String carDistance = car.getDistance();

            if(carDistance.length() == maxDistance) {
                winnerName.add(car
                        .getName());
            }

        }
    }

}


