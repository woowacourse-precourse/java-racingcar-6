package setting;

import java.util.Random;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Information {
	String str = "";
	String[] result;

	// 자동차 이름 설정하기
	public String[] inputname() {
		str = Console.readLine();
		result = str.split(",");

		for (int i = 0; i < result.length; i++) {
			if (result[i].length() <= 5) {
				System.out.println(result[i]);
			} else {
				throw new IllegalArgumentException("각 이름은 5글자 이내입니다.");
			}
		}

		return result;
	}

}
