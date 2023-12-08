package racingcar.controller;

import racingcar.model.Racer;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
//        String cars = inputView.readRaceCarNames();
//        String resultCars = cars.replaceAll(" ", "");
//        List<String> names = List.of(resultCars.split(","));
        Racer racer = new Racer(inputView.readCars());
//        int round = Integer.parseInt(inputView.readRaceRound());
//        Round round = new Round(inputView.readRound());
        Round round = Round.of(inputView.readRound());
        // 각각의 racer 초기화
//        Map<String, Integer> position = new LinkedHashMap<>();
//        for(String name: names){
//            position.put(name, 0);
//        }

        outputView.printExecutionResult();
        // 라운드 별 각각의 레이서 결과 출력
        while(round.hasRound()){
            play(racer);
//            racer.play();
//            outputView.printResult(racer.toString());
            round.turn();
        }
//        for (int i=0 ; i < round ; i++){
//            racer.play();
//            outputView.printResult(racer);
//            play(position);
//            outputView.printResult(position);
//            System.out.println();
//        }

        outputView.printFinalWinner(racer.winnerToString());
    }

    private void play(Racer racer){
        racer.play();
        outputView.printResult(racer.toString());
    }

//    private void play(Map<String, Integer> position) {
//        for (String name : position.keySet()){
//            if (ShiftGear.moveForward()) {
//                playMoveForward(position, name);
//            }
//        }
//    }

//    private void playMoveForward(Map<String, Integer> position, String name){
//        position.put(name, position.get(name) + 1);
//    }
}
