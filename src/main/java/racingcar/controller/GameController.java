package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.dto.PlayGameRequestDto;
import racingcar.dto.PlayGameResponseDto;
import racingcar.exception.UserCarNameInputException;
import racingcar.exception.UserTryNumberInputException;
import racingcar.service.ConsolePrintServiceImpl;
import racingcar.service.GameService;

public class GameController {
    private final GameService gameService;
    private final ConsolePrintServiceImpl printService;

    public GameController(GameService gameService, ConsolePrintServiceImpl printService) {
        this.gameService = gameService;
        this.printService = printService;
    }

    public void startGame(){
        PlayGameRequestDto playGameRequestDto = inputGameInfo();
        PlayGameResponseDto playGameResponseDto = gameService.playGame(playGameRequestDto);
        printService.printFinalGameResult(playGameResponseDto.getWinnerList());
    }

    private List<String> userInputCarNameList(){
        String carNames = readLine();
        List<String> carNameList = List.of(carNames.split(","));
        isUserCarNameInputCorrect(carNameList);
        return carNameList;
    }

    private Integer userInputTryNumber(){
        String userInput = readLine();
        isUserTryNumberInputCorrect(userInput);
        Integer tryNumber = Integer.valueOf(userInput);
        return tryNumber;
    }

    private PlayGameRequestDto inputGameInfo(){
        printService.printInputNameNotice();
        List<String> carNameList = userInputCarNameList();
        printService.printInputCountNotice();
        Integer tryNumber = userInputTryNumber();
        System.out.println();

        return new PlayGameRequestDto(carNameList, tryNumber);
    }

    private void isUserCarNameInputCorrect(List<String> inputList){
        for (String input : inputList) {
            if (input.length() > 5) {
                throw new UserCarNameInputException("자동차 이름이 5글자를 초과했습니다.\n"+"자동차 이름 : "+input);
            }
            if(input.length() == 0 ){
                throw new UserCarNameInputException("자동차 이름이 0글자입니다.\n"+"자동차 이름 : "+input);
            }
        }
    }
    private void isUserTryNumberInputCorrect(String input){
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new UserTryNumberInputException("숫자를 입력해야 합니다.");
        }
    }
}
