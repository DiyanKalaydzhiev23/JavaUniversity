import VideoPlatform.Video;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Video video1 = new Video("Hi my name is", BigDecimal.valueOf(2.1), 0, 1000, LocalDate.now());
        Video video2 = new Video("Hi my name is", BigDecimal.valueOf(2.3), 0, 2334, LocalDate.now());

        BigDecimal sum = video2.getDuration().add(video1.getDuration());
        System.out.println(sum);

        if (video2.isLonger(video1)) {
            System.out.println("Longer");
        }

        video2.increaseDuration(BigDecimal.valueOf(12));
    }
}
