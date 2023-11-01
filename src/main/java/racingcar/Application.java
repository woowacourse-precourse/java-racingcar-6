package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
		System.out.println("자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String Input_Name = Console.readLine();
		System.out.println("시도할 회수는 몇회인가요?");
		String Input_Trynum = Console.readLine();
		String[] arr_Name = Input_Name.split(",");
		try {
			int testNum = Integer.parseInt(Input_Trynum);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		int TryNum = Integer.parseInt(Input_Trynum);
		car[] members = new car[arr_Name.length];
		System.out.println("실행 결과");

		for (int i = 0; i < arr_Name.length; i++) {
			members[i] = new car();
			members[i].name = arr_Name[i];
			if (arr_Name[i].length() > 5 | arr_Name[i].length() == 0) {
				throw new IllegalArgumentException();
			}
		}

		for (int i = 0; i < TryNum; i++) {
			for (int j = 0; j < members.length; j++) {
				int randomNumber = Randoms.pickNumberInRange(1, 9);
				members[j].RanNum = randomNumber;
				members[j].move();
				System.out.printf("%s : %s \n", members[j].name, members[j].GoCount);
			}
			System.out.println(""); // 출력값에 공백(띄어쓰기) 만들기
		}

		ArrayList<Integer> GoCountLength = new ArrayList<Integer>();
		ArrayList<Integer> GoCountLength2 = new ArrayList<Integer>();

		for (int k = 0; k < members.length; k++) {
			GoCountLength.add(members[k].GoCount.length());
			GoCountLength2.add(members[k].GoCount.length());
		}
		// 전진 거리 최댓값 추출
		GoCountLength.sort(Comparator.reverseOrder());
		ArrayList<Integer> maxindex = new ArrayList<Integer>();

		for (int m = 0; m < GoCountLength.size(); m++) {
			if (GoCountLength2.get(m) == GoCountLength.get(0)) {
				maxindex.add(m);
			}
		}
		List<String> result = new ArrayList<String>();
		for (int n = 0; n < maxindex.size(); n++) {
			result.add(arr_Name[maxindex.get(n)]);
		}

		System.out.printf("최종 우승자 : ");
		// 쉼표를 이용해 우승자를 구분하여 출력
		for (int num = 0; num < result.size(); num++) {
			if (num > 0) {
				System.out.printf("," + result.get(num));
			} else {
				System.out.printf(result.get(num));
			}
		}
	}
}
