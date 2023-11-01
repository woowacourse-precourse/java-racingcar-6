package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car {
	private Long index = 0L;
	private final Map<Long, Cars> cars = new HashMap<>();

	public Long save(Cars car) {
		cars.put(index, car);
		index += 1;
		return index;
	}

	public Cars findById(Long id) {
		return cars.get(id);
	}

	public List<Cars> findAll() {
		return new ArrayList<>(cars.values());
	}
}
