package racingcar.repository;

import racingcar.domain.Racer;

import java.util.*;

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

    public int getMoveByName(String name){
        Racer currRacer = findByName(name).get();
        return currRacer.getCurrentMove();
    }

    public void setMoveByName(String name){
        Racer currentRacer = findByName(name).get();
        currentRacer.setCurrentMove();
    }

    public List<Racer> findAll(){
        return new ArrayList<>(racerMap.values());
    }

    public void clearStore(){
        racerMap.clear();
    }
}
