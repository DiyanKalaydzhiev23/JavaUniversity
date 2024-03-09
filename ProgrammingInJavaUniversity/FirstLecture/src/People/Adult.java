package People;

import java.time.LocalDate;

public class Adult {
    private final String id;
    private String name;
    private LocalDate dateOfBirth;

    final static int topID = 99_999;
    final static int bottomID = 10_000;

    public Adult(String name, LocalDate dateOfBirth) {
        this.id = name + dateOfBirth + (Math.random() * (topID - bottomID) + bottomID);
    }
}
