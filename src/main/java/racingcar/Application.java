package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.CarFactory;
import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;
import racingcar.view.GameViewer;


import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        List<Car> cars = carFactory.createCars();


        // MemoryCarRepository 인스턴스 생성
        CarRepository carRepository = new MemoryCarRepository();

        // 모든 Car 객체를 저장
        for (Car car : cars) {
            carRepository.save(car);
        }

        List<Car> savedCars = carRepository.findAll();


        GameController gameController = new GameController(carRepository);
        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(Console.readLine());
        gameController.setGameCount(count);

        GameViewer gameViewer = new GameViewer(savedCars);

        System.out.println("\n실행 결과");
        for (int i = 0; i < gameController.getGameCount(); i++) {
            gameController.executeGameStep();
            gameViewer.displayGameResult();
        }


        // 승자 결정
        String winner = gameController.getCarWithMaxPosition();
        gameViewer.displayGameWinner(winner);
    }
}
