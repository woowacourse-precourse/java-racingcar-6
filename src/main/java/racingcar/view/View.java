package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.service.CarService;

import java.util.List;


public class View implements ViewInterface{

    private final CarService carService;


    public View(CarService carService) {
        this.carService = carService;

    }

    @Override
    public void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        String[] carNames = inputCarNames.split(",");
        carService.createCar(carNames);

    }

    @Override
    public void moveCar() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attemptsNumber = Integer.parseInt(Console.readLine());
        System.out.println();

        System.out.println("실행 결과");
        while(attemptsNumber != 0){
            attemptsNumber--;
            carService.movieCar();

            List<Car> cars = carService.getCars();
            numberOfResult(cars);
            System.out.println();
        }

    }

    @Override
    public void finalResult() {



    }

    private void numberOfResult(List<Car> cars){
        for(Car car : cars){
            String str = "-";
            System.out.print(car.getName() + " : " +str.repeat(car.getDistance()));
            System.out.println();
        }
    }





}
