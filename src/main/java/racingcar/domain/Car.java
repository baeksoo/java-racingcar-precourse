package racingcar.domain;

public class Car {
    private final String name;

    private Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Car of(String name) {
        validateLength(name);
        return new Car(name);
    }

    private static void validateLength(String name) {
        if (!(name.length() >= 1 && name.length() <= 5)) {
            throw new IllegalArgumentException("[ERROR] 차량명은 1글자 이상, 5글자 이하가 되어야합니다");
        }
    }
}
