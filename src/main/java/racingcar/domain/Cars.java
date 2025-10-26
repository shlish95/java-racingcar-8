package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> values;

    public Cars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다.");
        }

        this.values = List.copyOf(cars);
    }

    public void raceOnce(MoveStrategy strategy) {
        for (Car car : values) {
            car.move(strategy);
        }
    }

    public List<Car> asList() {
        return new ArrayList<>(values);
    }

    public List<String> winners() {
        int max = values.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(0);

        return values.stream()
                .filter(c -> c.position() == max)
                .map(Car::name)
                .collect(Collectors.toList());
    }
}
