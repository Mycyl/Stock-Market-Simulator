public class RealEstate extends Assets{
    private String city;
    private String realtor;
    private String state;
    private int squareFeet;
    
    public RealEstate (double cost, String name, String city, String state, String realtor, int squareFeet) {
        super(cost, name);
        this.city = city;
        this.state = state;
        this.squareFeet = squareFeet;
        this.realtor = realtor;
    }

    public String getCity() {
        return city;
    }

    public String getRealtor() {
        return realtor;
    }

    public String getState() {
        return state;
    }
    
    public int getSquareFeet() {
        return squareFeet;
    }
}