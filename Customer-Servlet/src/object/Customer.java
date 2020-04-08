package object;

public class Customer {
    String name;
    String bod;
    String address;
    String picture;

    public Customer() {
    }

    public Customer(String name, String bod, String address, String picture) {
        this.name = name;
        this.bod = bod;
        this.address = address;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBod() {
        return bod;
    }

    public void setBod(String bod) {
        this.bod = bod;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
