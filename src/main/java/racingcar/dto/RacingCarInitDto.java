package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class RacingCarInitDto {
	private List<String> carNameList = new ArrayList<>();
	private Integer inputCarRaceTimes = 0;

	private RacingCarInitDto() {
	}

	// start: Builder 패턴
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private RacingCarInitDto racingCarInitDto = new RacingCarInitDto();

		public Builder carNameList(List<String> carNameList) {
			racingCarInitDto.carNameList = carNameList;
			return this;
		}

		public Builder inputCarRaceTimes(Integer inputCarRaceTimes) {
			racingCarInitDto.inputCarRaceTimes = inputCarRaceTimes;
			return this;
		}

		public RacingCarInitDto build() {
			return racingCarInitDto;
		}
	}
	// end: Builder 패턴

	public List<String> getCarNameList() {
		return carNameList;
	}

	public Integer getInputCarRaceTimes() {
		return inputCarRaceTimes;
	}
}
