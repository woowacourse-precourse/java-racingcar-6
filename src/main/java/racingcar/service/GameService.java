package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.config.Config;
import racingcar.model.Car;
import racingcar.utils.Validation;


public class GameService {

    private Config config;
    public List<Car> carList;
    public List<Car> winnerList;
    public int tryNum;



    public GameService(Config config) {
        this.config = config;
        winnerList = new ArrayList<Car>();
        carList = new ArrayList<Car>();
    }


    // 입력값을 받는다.
    public void getInputCar() {
        String input = Console.readLine();
        splitInputName(input);
    }

    // 입력받은 이름을 나눈다.
    public void splitInputName(String input) {

        String[] splited = input.split(",");
        int carNum = splited.length;

        for (int i = 0; i < carNum; i++) {
            Validation.isBlank(splited[i]);
            Validation.isLengthError(splited[i]);
            Validation.isDuplicated(splited[i], carList);

            carList.add(new Car(splited[i]));
        }
    }

    public void getInputTryNum() {
        tryNum = Validation.isNumber(Console.readLine());
    }


    public void findWinner() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < carList.size(); i++) {
            Car selectCar = carList.get(i);
            if (selectCar.getForward() > max) {
                max = selectCar.getForward();
                winnerList.clear();
                winnerList.add(selectCar);
            } else if (selectCar.getForward() == max) {
                winnerList.add(selectCar);
            }
        }
    }


}
