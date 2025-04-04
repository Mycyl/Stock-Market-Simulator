public class Stock extends Assets{

    private double change;
    private double percentChange;
    private double highPrice;
    private double lowPrice;
    private double openPrice;
    private double previousClosePrice;

    public Stock (
    String stockName,
    double c,
    double d,
    double dp,
    double h,
    double l,
    double o,
    double pc) {
        super(c, stockName);
        change = d;
        percentChange = dp;
        highPrice = h;
        lowPrice = l;
        openPrice = o;
        previousClosePrice = pc;
    }

    public double getChange () {
        return change;
    }

    public double getPercentChange () {
        return percentChange;
    }

    public double getHighPrice () {
        return highPrice;
    }

    public double getLowPrice () {
        return lowPrice;
    }

    public double getOpenPrice () {
        return openPrice;
    }

    public double getPreviousClosePrice () {
        return previousClosePrice;
    }

    @Override
    public String toString () {
        String str = "";
        str += "Change: $" + change;
        str += "\nPercent Change: $" + percentChange;
        str += "\nHigh Price: $" + highPrice;
        str += "\nLow Price: $" + lowPrice;
        str += "\nOpen Price of the day: $" + openPrice;
        str += "\nPrevious close price: $" + previousClosePrice;
        return str;
    }


}
