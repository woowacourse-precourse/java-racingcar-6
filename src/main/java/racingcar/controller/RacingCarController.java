package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RacingCar;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;

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
        List<RacingCar> racingCarList = requestRacingCarNameList();
        RacingCarGame racingCarGame = new RacingCarGame(requestAttemptNumberCovertStringToInteger(),true);
        repeatMoveRacingCar(racingCarList, racingCarGame);
    }

    private void repeatMoveRacingCar(List<RacingCar> racingCarList, RacingCarGame racingCarGame){
        /** while문이 종료되면 입력된 이동만큼 반복한 것 **/
        while(racingCarGame.isGameState()){
            racingCarList.forEach(RacingCar::moveRacingCar);
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
        RacingCarValidator.attemptOnlyInputNumber(number);
        return Integer.parseInt(number);
    }

}
