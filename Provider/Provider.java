package Provider;

//Done by Clark Potter

public class Provider {
    private String name;
    private String number;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
   

    // Constructor
    public Provider(String name, String number, String streetAddress, String city, String state, String zipCode) {
        this.name = name;
        this.number = number;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
       
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return String.format("%-25s%-9s%-25s%-14s%-2s%-5s", name, number, streetAddress, city, state, zipCode);
    }
}