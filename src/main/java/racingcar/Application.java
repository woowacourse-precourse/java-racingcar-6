package racingcar;

class car {
	String name;
	String GoCount = "";
	int RanNum;

	public void move() {
		if (RanNum >= 4) {
			GoCount += "-";
		}
	}
}

public class Application {
    public static void main(String[] args) {
    }
}
