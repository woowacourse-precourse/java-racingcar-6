package racingcar.racingCar;

import racingcar.controller.checkWinner.CheckWinner;
import racingcar.controller.distinguish.Distinguish;
import racingcar.controller.random.RandomMove;
import racingcar.model.Car;
import racingcar.repositoryCar.CarRepository;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarGame {
    Output output;
    Input input;
    Distinguish distinguish;
    CarRepository carRepository;

    public RacingCarGame(Distinguish distinguish, CarRepository carRepository) {
        this.distinguish = distinguish;
        this.carRepository = carRepository;
        input = new Input();
        output = new Output();
    }

    public void playGame(){
        output.startGame();
        String numberOfRepetitions = input.getNumberOfRepetitions();

        output.inputRepetitions();
        String inputName = input.getPlayerName();

        String[] playersName = distinguish.distinguishName(inputName);
        int repetitions = distinguish.distinguishNum(numberOfRepetitions);

        save(playersName);
        play(repetitions);
        output.makeResult(carRepository.getWinnerName());
    }

    private void save(String [] playersName){
        for(String name : playersName){
            carRepository.save(new Car(name));
        }
    }

    private void play(int repetitions){
        for(int i = 0; i<repetitions; i++){
            carRepository.updatePosition();
            output.showCurrentSituation(carRepository.getCarList());
        }
    }
}
