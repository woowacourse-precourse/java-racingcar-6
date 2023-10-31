package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.CarService;



public class View implements ViewInterface{

    private final CarService carService;


    public View(CarService carService) {
        this.carService = carService;

    }

    @Override
    public void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        System.out.println(inputCarNames);
        String[] carNames = inputCarNames.split(",");
        carService.createCar(carNames);

    }

    @Override
    public void MoveCar() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attemptsNumber = Integer.parseInt(Console.readLine());

        while(attemptsNumber == 0){
            attemptsNumber--;
            carService.movieCar();

        }

    }
}
