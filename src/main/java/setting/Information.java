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
				result[i] += " : ";
			} else {
				throw new IllegalArgumentException("각 이름은 5글자 이내입니다.");
			}
		}

		return result;
	}

	// 시도할 횟수 입력 및 랜덤 숫자를 통해 4이상인 경우 한 칸 앞으로 전진하기
	public int inputNum() {
		String strNum = Console.readLine();
		int Num = Integer.parseInt(strNum);

		for (int i = 0; i < Num; i++) {
			for (int j = 0; j < result.length; j++) {
				int check = Randoms.pickNumberInRange(0, 9);

				if (check >= 4) {
					result[j] += "-";
				}

				System.out.println(result[j]);
			}
			System.out.println();
		}

		return Num;
	}



	// '-' (전진)갯수
	public int countChar(String name, char ch) {
		int cnt = 0;

		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == '-') {
				cnt++;
			}
		}

		return cnt;
	}

}
