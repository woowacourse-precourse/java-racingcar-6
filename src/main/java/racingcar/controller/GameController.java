package racingcar.controller;

import racingcar.domain.enums.ValidationMsg;
import racingcar.dto.RacingCarInitDto;
import racingcar.service.RacingCarService.RacingCarService;
import racingcar.service.StringUtilService;
import racingcar.service.ValidatorService;
import racingcar.view.InputView;
import racingcar.view.OutputGameStateView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
	private final ValidatorService validatorService = ValidatorService.getInstance();

	private final InputView inputView = InputView.getInstance();
	private StringUtilService stringUtilService = StringUtilService.getInstance();

	private RacingCarService racingCarService = RacingCarService.getInstance();

	public void setCarNameList(List<String> carNameList) {
		this.carNameList = carNameList;
	}

	public void setInputCarRaceTimes(Integer inputCarRaceTimes) {
		this.inputCarRaceTimes = inputCarRaceTimes;
	}

	public List<String> getCarNameList() {
		return carNameList;
	}

	public Integer getInputCarRaceTimes() {
		return inputCarRaceTimes;
	}

	private List<String> carNameList = new ArrayList<>();
	private Integer inputCarRaceTimes = 0;

	public void gameStart() {
		printGameRuleInfo();
		requestUserInput();
		this.saveRacingCar();
		OutputGameStateView.getInstance().printCarRacing(racingCarService.playCarRacing());
		OutputGameStateView.getInstance().printCarRacing(racingCarService.printCarRacingResult());
	}

	private void printGameRuleInfo() {
		inputView.printGameRuleInfo();
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

	private void saveRacingCar() {
		RacingCarInitDto racingCarInitDto = RacingCarInitDto.builder()
				.carNameList(this.getCarNameList())
				.inputCarRaceTimes(this.getInputCarRaceTimes())
				.build();
		racingCarService.saveRacingCar(racingCarInitDto);
	}

	private void initSaveRacingCar() {
		RacingCarInitDto racingCarInitDto = RacingCarInitDto.builder()
				.carNameList(this.getCarNameList())
				.inputCarRaceTimes(this.getInputCarRaceTimes())
				.build();
		racingCarService.initSaveRacingCar(racingCarInitDto);
	}
}
