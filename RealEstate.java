public class RealEstate extends Assets{
    
    private String city;
    private String realtor;
    private String state;
    private int squareFeet;
    private String bedrooms;
    private String bathrooms;
    private int yearBuilt;
    private String propertyType;
    
    public RealEstate (double cost, String name, String city, String state, String realtor, int squareFeet, String bedrooms, String bathrooms, int yearBuilt, String propertyType) {
        super(cost, name);
        this.city = city;
        this.state = state;
        this.squareFeet = squareFeet;
        this.realtor = realtor;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.yearBuilt = yearBuilt;
        this.propertyType = propertyType;

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

    public String getBathrooms() {
        return bathrooms;
    }

    public String getBedrooms() {
        return bedrooms;
    }
    
    public int getYearBuilt() {
        return yearBuilt;
    }

    public String getPropertyType() {
        return propertyType;
    }

    @Override
    public String toString () {
        String str = "";
        str += "=====================================";
        str += "\nBedrooms: " + bedrooms;
        str += "\nBathrooms: " + bathrooms;
        str += "\nYear Built: " + yearBuilt;
        str += "\nProperty Type: " + propertyType;
        str += "\nSquare Feet: " + squareFeet;
        str += "\nState: " + state;
        str += "\nRealtor: " + realtor;
        str += "\nCity: " + city;
        str += "\n=====================================";
        return str;
    }
}