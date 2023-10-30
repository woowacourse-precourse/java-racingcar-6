package racingcar.dto.request;

public class TryNumberReq {
	String tryNumber;

	public String getTryNumber() {
		return tryNumber;
	}

	public void setTryNumber(String tryNumber) {
		this.tryNumber = tryNumber;
	}

	public void clear() {
		this.tryNumber = "";
	}
}
