package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class ApplicationTest extends NsTest {
	private static final int MOVING_FORWARD = 4;
	private static final int STOP = 3;

	@Test
	void 전진_정지() {
		assertRandomNumberInRangeTest(
			() -> {
				run("pobi,woni", "1");
				assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
			},
			MOVING_FORWARD, STOP
		);
	}

	@Test
	void 이름에_대한_예외_처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("", "1"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}

	@Test
	void 문자열_길이에_대한_예외_처리() {
		String input = "exceedString";
		Validator validator = new Validator();

		assertThatThrownBy(() -> validator.validateNameLength(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 빈_문자열에_대한_예외_처리() {
		StringTokenizer testTokenizer = new StringTokenizer(",", ",");
		Validator validator = new Validator();

		assertThatThrownBy(() -> validator.validateEmptyString(testTokenizer.hasMoreTokens()))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 공백_문자열에_대한_예외_처리() {
		String input = "       ";
		Validator validator = new Validator();

		assertThatThrownBy(() -> validator.validateSpace(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 숫자가_아닌_문자에_대한_예외_처리() {
		String input = ".";
		Validator validator = new Validator();

		assertThatThrownBy(() -> validator.validateMoveCount(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 음수에_대한_예외_처리() {
		String input = "-1";
		Validator validator = new Validator();

		assertThatThrownBy(() -> validator.validateMoveCount(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void _0에_대한_예외_처리() {
		String input = "0";
		Validator validator = new Validator();

		assertThatThrownBy(() -> validator.validateMoveCount(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 자동차_이동여부_판단() {
		GameProcess game = new GameProcess();
		int input = 4;

		assertThat(game.judgeMoveOrNot(input)).isEqualTo(true);
	}

	@Test
	void 자동차_이동() {
		GameProcess game = new GameProcess();
		InformationOfCar car = new InformationOfCar("sanni", "");

		assertRandomNumberInRangeTest(
			() -> {
				game.moveOrNot(car);
				assertThat(output()).contains("sanni : -");
			},
			MOVING_FORWARD
		);
	}

	@Test
	void 최대_거리_계산() {
		GameProcess game = new GameProcess();
		List<InformationOfCar> carList = new ArrayList<>();
		carList.add(new InformationOfCar("aaa", "---"));
		carList.add(new InformationOfCar("bbb", "--"));
		carList.add(new InformationOfCar("ccc", "---"));

		assertThat(game.calculateMaxDistance(carList)).isEqualTo(3);
	}

	@Test
	void 최종_출력() {
		GameProcess game = new GameProcess();
		List<InformationOfCar> carList = new ArrayList<>();
		carList.add(new InformationOfCar("aaa", "---"));
		carList.add(new InformationOfCar("bbb", "---"));
		carList.add(new InformationOfCar("ccc", "--"));
		int maxDistance = 3;

		game.printFinalString(maxDistance, carList);
		assertThat(output()).isEqualTo("최종 우승자 : aaa, bbb");
	}
}
