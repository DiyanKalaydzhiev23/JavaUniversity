package People;

import java.time.LocalDate;

public class Child {
    private String name;
    private LocalDate birthDate;
    private Adult parent;

    public Child(String name, LocalDate birthDate, Adult parent) {
        this.name = name;
        this.birthDate = birthDate;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public Adult getParent() {
        return parent;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
