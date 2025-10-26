package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final MoveStrategy strategy;

    public RacingGame(Cars cars, MoveStrategy strategy) {
        this.cars = cars;
        this.strategy = strategy;
    }

    public List<Car> round() {
        cars.raceOnce(strategy);
        return new ArrayList<>(cars.asList());
    }

    public List<String> winners() {
        return cars.winners();
    }
}
