package racingcar.dto.request;

public class TryNumberReq {
	int tryNumber;

	public int getTryNumber() {
		return tryNumber;
	}

	public void setTryNumber(int tryNumber) {
		this.tryNumber = tryNumber;
	}

	public void clear() {
		this.tryNumber = 0;
	}
}
