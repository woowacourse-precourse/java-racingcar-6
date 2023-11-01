package racingcar.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racingcar.domain.Racing;

public class RacingRepository {
    private Long id = 0L;
    private final Map<Long, Racing> racings = new HashMap<>();

    public Long save(Racing racing) {
        Long returnId = id;
        racings.put(id, racing);
        id += 1;
        return returnId;
    }

    public Boolean is_END(Racing racing) {
        return racing.Check_trial_equals_trialNumbers();
    }

    public Racing findById(Long id) {
        return racings.get(id);
    }

    public List<Racing> findAll() {
        return new ArrayList<>(racings.values());
    }
}
