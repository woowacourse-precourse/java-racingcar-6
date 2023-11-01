package racingcar;

import java.util.List;

// 자동차 이름 배열을 List형으로 변환하는 메소드
public class CarList {
	public List<String> keepCarList(List<String> carList, String[] arr) {
		for(int i=0;i<arr.length;i++)
			carList.add(arr[i]);
		return carList;
	}
}
