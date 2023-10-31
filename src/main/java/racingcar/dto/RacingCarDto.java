package racingcar.dto;

public class RacingCarDto {
	private String carName;
	private Integer carPosition;

	private RacingCarDto() {
	}

	public RacingCarDto(String carName) {
		this.carName = carName;
	}

	// start: Builder 패턴
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private RacingCarDto dto = new RacingCarDto();

		public Builder carName(String carName) {
			dto.carName = carName;
			return this;
		}

		public Builder carPosition(Integer carPosition) {
			dto.carPosition = carPosition;
			return this;
		}

		public RacingCarDto build() {
			return dto;
		}
	}
	// end: Builder 패턴

	public String getCarName() {
		return carName;
	}
}
