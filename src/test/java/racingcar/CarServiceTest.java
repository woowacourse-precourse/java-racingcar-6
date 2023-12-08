package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarServiceTest {
	CarService service;
	String name;
	List<Car> carList;
	List<Car> testCarList;
	@BeforeEach
	void setUp(){
		service = new CarService();
		name = "포비,우니,준";

		carList = new ArrayList<>();
		carList.add(new Car("포비"));
		carList.add(new Car("우니"));
		carList.add(new Car("준"));

		testCarList = service.makeCarList(name);
	}
	@Test
	void testMakeCarListWhatCarListSize(){
		int actualSize = carList.size();
		int testSize = testCarList.size();

		assertEquals(actualSize, testSize);
	}
	@Test
	void testMakeCarListWhatCarListName(){
		String actualFirstName = carList.get(0).name;
		String actualSecondName = carList.get(1).name;
		String actualThirdName = carList.get(2).name;

		String testFirstName = testCarList.get(0).name;
		String testSecondName = testCarList.get(1).name;
		String testThirdName = testCarList.get(2).name;

		assertEquals(actualFirstName, testFirstName);
		assertEquals(actualSecondName, testSecondName);
		assertEquals(actualThirdName, testThirdName);
	}
}
