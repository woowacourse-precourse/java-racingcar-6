package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCar;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private static final String COMMA =",";
    public void run(){start();}

    public void start(){
        racingCarGameStart();
    }

    private void racingCarGameStart() {
        List<RacingCar> racingCar = requestRacingCarNameList();
        RacingCarGame racingCarGame = new RacingCarGame(requestAttemptNumberCovertStringToInteger(),true,racingCar);
        repeatMoveRacingCar(racingCarGame);
    }

    private void repeatMoveRacingCar(RacingCarGame racingCarGame){
        while(racingCarGame.isTimeOver()){
            racingCarGame.repeatMovingRacingCar();
            racingCarGame.getRacingCarList().forEach(v -> OutputView.printMoveRacingCar(v.getName(), v.getMove()));
            System.out.println("");

        }
    }


    private List<RacingCar> requestRacingCarNameList(){
        List<RacingCar> racingCarList = racingCarNameConvertStringToArray(racingCarNameInput());
        RacingCarValidator.racingCarNameLengthValidator(racingCarList);
        return racingCarList;
    }

    public List<RacingCar> racingCarNameConvertStringToArray(String racingCar){
       List<RacingCar> racingCarList = Arrays.stream(racingCar.split(COMMA))
               .map(car -> new RacingCar(car,0))
                .collect(Collectors.toList());
       return racingCarList;
    }

    private String racingCarNameInput(){
        return InputView.racingCarNameInput();
    }

    private Integer requestAttemptNumberCovertStringToInteger(){
        String number = InputView.attemptNumberInput();
        RacingCarValidator.attemptInputOnlyNumberValidator(number);
        return Integer.parseInt(number);
    }

}
