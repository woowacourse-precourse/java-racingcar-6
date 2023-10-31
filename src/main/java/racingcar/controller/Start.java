package racingcar.controller;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.service.CarCreator;
import racingcar.service.CarName;
import racingcar.service.Move;
import racingcar.service.RandomNumber;
import racingcar.view.OutputView;

public class Start {

    private Move move;
    private CarName carName;
    private RandomNumber randomNumber;
    private CarCreator carCreator;
    private OutputView outputView;


    public Start(Move move, CarName carName, RandomNumber randomNumber, CarCreator carCreator,
            OutputView outputView) {
        this.move = move;
        this.carName = carName;
        this.randomNumber = randomNumber;
        this.carCreator = carCreator;
        this.outputView = outputView;
    }


    public void Game() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carName.split();
        carName.range();

        List<Car> cars = carCreator.createCars(carName.rangeCarList, 0);
        Move move = new Move(cars);
        move.AllCars();
        System.out.println("시도할 횟수는 몇회인가요?");

        String input = Console.readLine();
        int num = Integer.parseInt(input);

        System.out.println();
        System.out.println("실행 결과");
        for(int i=0; i<num; i++){
            move.AllCars();
            OutputView.printCars(cars);
        }
        OutputView.printWinners(cars);

    }



}
