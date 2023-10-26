package racingcar.controller;

import racingcar.domain.MoveNumber;
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
        MoveNumber moveNumber = new MoveNumber(requestAttemptNumberCovertStringToInteger());

    }

    private void repeatMoveRacingCar(List<RacingCar> racingCarList, MoveNumber moveNumber){
      while(moveNumber.getNumber()>=0){



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
