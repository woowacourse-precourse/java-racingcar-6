package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.GameConstantValue;
import racingcar.constant.GameViewMessage;
import racingcar.entity.Car;
import racingcar.service.CarService;
import racingcar.view.View;

import java.util.List;

public class GameController {

    private final View view;
    private final CarService carService;

    public GameController(View view, CarService carService) {
        this.view = view;
        this.carService = carService;
        init();
    }

    public void init() {
        // 게임 데이터 입력
        List<String> names = view.inputNames();
        for (String name : names) {
            carService.createCar(name);
        }
        int count = view.inputCountNumber();

        // 게임 시작
        gameStart(count);
    }

    public void gameStart(int count) {
        view.printResultStart();
        while (count-- > 0) {
            progress();
            makeResult();
        }
        gameEnd();
    }

    /**
     * 앞으로 전진하는 로직 호출 메소드
     */
    public void progress() {
        List<Car> cars = carService.getListOfCar();
        for (Car car : cars) {
            forward(car);
        }
    }

    /**
     * @param car 랜덤 숫자를 판별 후 앞으로 전진
     */
    public void forward(Car car) {
        int randomValue = Randoms.pickNumberInRange(GameConstantValue.MIN_VALUE, GameConstantValue.MAX_VALUE);
        if (carService.isValidValue(randomValue)) {
            carService.moveForward(car.getId());
        }
    }

    /**
     * 매 횟수마다 변경된 전진거리를 출력
     */
    public void makeResult() {
        StringBuilder sb = new StringBuilder();
        List<Car> cars = carService.getListOfCar();
        for (Car car : cars) {
            sb.append(car.getName()).append(GameViewMessage.MESSAGE_SPLIT_CHAR).append(makeDistanceString(car.getDistance())).append('\n');
        }
        view.printProgressResult(sb.toString());
    }

    public String makeDistanceString(int distance) {
        String distanceString = "";
        for (int i = 0; i < distance; i++) {
            distanceString += GameViewMessage.MESSAGE_PROGRESS_DISTANCE_CHAR;
        }
        return distanceString;
    }

    public void gameEnd() {
        StringBuilder sb = new StringBuilder();
        sb.append(GameViewMessage.MESSAGE_RESULT_CHAMPION).append(GameViewMessage.MESSAGE_SPLIT_CHAR);

        List<Car> champions = carService.getChampions();

        for (int i = 0; i < champions.size(); i++) {
            sb.append(champions.get(i).getName());
            if (i != champions.size() - 1) {
                sb.append(", ");
            }
        }

        view.printChampions(sb.toString());
    }
}
