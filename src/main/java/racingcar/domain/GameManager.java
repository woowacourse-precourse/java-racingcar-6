package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameManager {
	public static final int ICLASS_NUM = 3;

	public GameManager() {
	}

	public void viewGmae(List<String> _InputList, List<Integer> _IntputCarStateList) {
		System.out.println();
		for (int i = 0; i < _InputList.size(); i++) {
			System.out.print(_InputList.get(i) + " : ");
			int iConut = 0;
			while (iConut < _IntputCarStateList.get(i)) {
				System.out.print("-");
				++iConut;
			}
			System.out.println("");
		}
	}

	public void viewGameResult(List<String> _InputList, List<Integer> _IntputCarStateList) {
		System.out.println("");
		System.out.print("최종 우승자 : ");
		int iMax = Collections.max(_IntputCarStateList);
		List<String> WinnerList = new ArrayList<String>();

		for (int i = 0; i < _InputList.size(); i++) {
			if (iMax == _IntputCarStateList.get(i)) {
				WinnerList.add(_InputList.get(i));
			}
		}
		System.out.print(String.join(",", WinnerList));

	}

}
