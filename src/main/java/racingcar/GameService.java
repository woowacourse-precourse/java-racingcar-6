package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String COUNT_QUERY_MESSAGE = "시도할 회수는 몇회인가요?";
    IOService ioService;
    List<Car> carList;
    public void start(){
        int count;

        System.out.println(START_MESSAGE);
        List<String> carNames = ioService.scanCarNames();
        setCarList(carNames);

    }

    private void setCarList(List<String> carNames){
        carList = new ArrayList<Car>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }
}
