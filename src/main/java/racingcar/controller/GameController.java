package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.dto.PlayGameRequestDto;
import racingcar.dto.PlayGameResponseDto;
import racingcar.service.ConsolePrintServiceImpl;
import racingcar.service.GameService;

public class GameController {
    private final GameService gameService;
    private final ConsolePrintServiceImpl printService;

    public GameController() {
        this.gameService = new GameService();
        this.printService = new ConsolePrintServiceImpl();
    }

    public void startGame(){
        PlayGameRequestDto playGameRequestDto = inputGameInfo();
        PlayGameResponseDto playGameResponseDto = gameService.playGame(playGameRequestDto);
        printService.printFinalGameResult(playGameResponseDto.getWinnerList());
    }

    private String userInputCarNames(){
        String carNames = readLine();
        //todo: 예외처리 - 이름은 5자 이하만 가능
        return carNames;
    }

    private Integer userInputTryNumber(){
        Integer tryNumber = Integer.valueOf(readLine());
        //todo: 예외처리 - 이름은 5자 이하만 가능
        return tryNumber;
    }

    private PlayGameRequestDto inputGameInfo(){
        printService.printInputNameNotice();
        String carNames = userInputCarNames();
        printService.printInputCountNotice();
        Integer tryNumber = userInputTryNumber();
        System.out.println();

        return new PlayGameRequestDto(carNames, tryNumber);
    }
}
