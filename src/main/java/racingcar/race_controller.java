package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class race_controller {
    private int leadCarNumber;
    private Cars cars;
    private int[] storage;
    private Cars_preparation carGoCountMap;
    private RoundNumber roundNumber;
    public race_controller() {
        InputRacingInformation inputRacingInformation = new InputRacingInformation();
        List<String> carNames = inputRacingInformation.InputCarNames();
        cars = createCars(carNames);
        roundNumber = createroundNumber(inputRacingInformation.round_number());
        storage = new int[cars.size()];
        carGoCountMap = Car_Go_Count_Map(cars, storage);
    }

    public void game() {
        OutputView.printResultMessage();
        int round = 0;
        while(isEnd(round)){
            runGame();
            round++;
        }
        who_win(carGoCountMap);
    }

    public Cars createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return new Cars(cars);
    }

    public RoundNumber createroundNumber(int round_Num){
        return new RoundNumber(round_Num);
    }

    public void runGame() {
        for (Entry<Car, Integer> carGoCountEntry : carGoCountMap.entrySet()) {
            int newPosition = process(carGoCountEntry.getValue());
            carGoCountEntry.setValue(newPosition);
            OutputView.printCarPosition(carGoCountEntry.getKey(), carGoCountEntry.getValue());
        }
        System.out.println();
    }

    public Cars_preparation Car_Go_Count_Map(Cars cars, int[] storage) {
        Map<Car, Integer> cars_go_count_map = new LinkedHashMap<>();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            cars_go_count_map.put(car, storage[i]);
        }
        return new Cars_preparation(cars_go_count_map);
    }

    public int process(int position){
        if(isGo()){
            position++;
        }
        return position;
    }

    public boolean isGo() {
        int go_number = Randoms.pickNumberInRange(Constant.MIN_RANDOM_NUM, Constant.MAX_RANDOM_NUM);
        if (go_number >= Constant.GO_RANDOM_NUM) {
            return true;
        }
        return false;
    }

    public boolean isEnd(int round){
        if(roundNumber.getRound_Num() == round){
            return false;
        }
        return true;
    }

    public void leadPosition(Cars_preparation carGoCountMap){
        for(Entry<Car, Integer> entry : carGoCountMap.entrySet()){
            if(this.leadCarNumber < entry.getValue()){
                this.leadCarNumber = entry.getValue();
            }
        }
    }

    public void who_win(Cars_preparation carGoCountMap){
        leadPosition(carGoCountMap);
        OutputView.printWinners(carGoCountMap.getWinners(leadCarNumber));
    }
}
