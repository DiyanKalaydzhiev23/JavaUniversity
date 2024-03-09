package VideoPlatform;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Video {
    // default encapsulation is visible in the package
    private static final BigDecimal maxDuration = BigDecimal.valueOf(10.00);
    private final String name;
    private BigDecimal duration;
    private final long id;
    private final int likes;
    private final LocalDate dateUploaded;

    public Video(long id) {
        this.id = id;
        this.name = "";
        this.duration = BigDecimal.valueOf(0.0);
        this.likes = 0;
        this.dateUploaded = LocalDate.now();
    }

    public Video(String name, BigDecimal duration, int likes, long id, LocalDate time) {
        this.name = name;
        this.duration = duration;
        this.likes = likes;
        this.id = id;
        this.dateUploaded = time;
    }

    public void increaseDuration(BigDecimal bonusDuration) {
        BigDecimal newDuration = this.getDuration().add(bonusDuration);

        if (newDuration.compareTo(maxDuration) < 0) {
            this.setDuration(newDuration);
            System.out.println("Changed duration");
        } else {
            System.out.println("Cannot change duration");
        }
    }

    public String getName() {
        return name;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public int getLikes() {
        return likes;
    }

    public long getId() {
        return id;
    }

    public boolean isLonger(Video video2) {
        return this.getDuration().compareTo(video2.getDuration()) > 0;
    }

    public Video getVideoWithMoreLikes(Video otherVideo) {
        if (this.getLikes() > otherVideo.getLikes()) {
            return this;
        } else {
            return otherVideo;
        }
    }

    @Override
    public String toString() {
        return "Video [name=" + name + ", duration=" + duration + ", likes]";
    }
}
