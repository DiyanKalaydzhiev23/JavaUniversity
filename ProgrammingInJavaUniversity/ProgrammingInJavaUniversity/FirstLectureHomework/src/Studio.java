import java.math.BigDecimal;

public class Studio {
    private static BigDecimal minPriceForOneHour;
    private static BigDecimal euroRate;

    private final long id;
    private BigDecimal priceForOneHour;
    private int maxWorkingHours;
    private int rentedDayHours;


    Studio(long id, int maxWorkingHours) {
        this.id = id;
        setMaxWorkingHours(maxWorkingHours);
    }

    public long getId() {
        return this.id;
    }

    public BigDecimal getPriceForOneHour() {
        return this.priceForOneHour;
    }

    public int getMaxWorkingHours() {
        return this.maxWorkingHours;
    }

    public int getRentedDayHours() {
        return this.rentedDayHours;
    }

    public BigDecimal getEuroRate() {
        return Studio.euroRate;
    }

    public BigDecimal getMinPriceForOneHour() {
        return Studio.minPriceForOneHour;
    }

    public void setMaxWorkingHours(int maxWorkingHours) {
        if (maxWorkingHours < 0 || maxWorkingHours > 24) {
            this.maxWorkingHours = 24;
        }
        else {
            this.maxWorkingHours = maxWorkingHours;
        }
    }

    public static void setMinPriceForOneHour(BigDecimal minPriceForOneHour) {
        Studio.minPriceForOneHour = minPriceForOneHour;
    }

    public void setPriceForOneHour(BigDecimal priceForOneHour) {
        this.priceForOneHour = priceForOneHour.max(Studio.minPriceForOneHour);
    }

    public void setRentedDayHours(int rentedDayHours) {
        this.rentedDayHours = Math.min(rentedDayHours, this.maxWorkingHours);
    }

    public void setEuroRate(BigDecimal rate) {
        Studio.euroRate = rate;
    }

    public BigDecimal getRevenueForADayInLeva() {
        BigDecimal rentedHours = BigDecimal.valueOf(this.rentedDayHours);
        return this.priceForOneHour.multiply(rentedHours);
    }

    public BigDecimal getRevenueForADayInEuro() {
        BigDecimal revenueForADay = this.priceForOneHour.multiply(BigDecimal.valueOf(this.rentedDayHours));
        return revenueForADay.multiply(Studio.euroRate);
    }

    public Studio compareByPriceForOneHour(Studio other) {
        return (this.priceForOneHour.compareTo(other.priceForOneHour) > 0 ? this : other);
    }

    public boolean compareByRevenue(Studio other) {
        return this.getRevenueForADayInLeva().compareTo(other.getRevenueForADayInLeva()) > 0;
    }
}
