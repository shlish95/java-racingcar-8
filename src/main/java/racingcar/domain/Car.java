package racingcar.domain;

public class Car {

    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public void move(MoveStrategy strategy) {
        if (strategy.movable()) {
            position += 1;
        }
    }

    public String name() {
        return name.value();
    }

    public int position() {
        return position;
    }
}
