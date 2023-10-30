package racingcar.repository;

import racingcar.domain.Racer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryRacerRepository implements RacerRepository {
    private static Map<Long, Racer> racerMap = new HashMap<>();
    private static long seq=0L;

    public Racer save(Racer racer){
        racerMap.put(seq++,racer);
        return racer;
    }

    public Optional<Racer> findById(Long id){
        return Optional.ofNullable(racerMap.get(id));
    }

    public Optional<Racer> findByName(String name){
        return racerMap.values().stream()
                .filter(racer -> racer.getRacerName().equals(name))
                .findAny();
    }

    public int getMoving(String name){
        Racer currRacer = findByName(name).get();
        return currRacer.getCurrentMove();
    }
}
