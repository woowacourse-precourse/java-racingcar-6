package racingcar.controller;

import racingcar.domain.enums.ValidationMsg;
import racingcar.service.StringUtilService;
import racingcar.service.ValidatorService;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
	private final ValidatorService validatorService = ValidatorService.getInstance();

	private final InputView inputView = InputView.getInstance();
	private StringUtilService stringUtilService = StringUtilService.getInstance();

	public void setCarNameList(List<String> carNameList) {
		this.carNameList = carNameList;
	}

	public void setInputCarRaceTimes(Integer inputCarRaceTimes) {
		this.inputCarRaceTimes = inputCarRaceTimes;
	}

	private List<String> carNameList = new ArrayList<>();
	private Integer inputCarRaceTimes = 0;

	public void gameStart() {
		printMenu();
	}

	private void printMenu() {
		inputView.printGameRuleInfo();
		requestUserInput();
	}

	private void requestUserInput() {
		this.setCarNameList(this.validateCarNames(inputView.requestInputCarName()));
		this.setInputCarRaceTimes(this.validateCarRaceTimes(inputView.requestInputCarRaceTimes()));
	}

	private List<String> validateCarNames(String inputCarName) throws IllegalArgumentException {
		ValidationMsg validationMsg = validatorService.validationCarName(inputCarName);
		if (validationMsg != ValidationMsg.PROPER_TYPE) {
			throw new IllegalArgumentException(validationMsg.getValue());
		}

		return stringUtilService.splitByComma(inputCarName);
	}

	private Integer validateCarRaceTimes(String inputCarRaceTimes) throws IllegalArgumentException {
		ValidationMsg validationMsg = validatorService.validationCarRaceTimes(inputCarRaceTimes);
		if (validationMsg != ValidationMsg.PROPER_TYPE) {
			throw new IllegalArgumentException(validationMsg.getValue());
		}
		return Integer.valueOf(inputCarRaceTimes);
	}
}
