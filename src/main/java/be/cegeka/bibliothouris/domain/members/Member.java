package be.cegeka.bibliothouris.domain.members;

public class Member {

    private String insz;
    private String firstName;
    private String lastName;
    private String street;
    private int houseNumber;
    private int postalCode;
    private String City;

    public Member(String insz, String firstName, String lastName, String street, int houseNumber, int postalCode, String city) {
        this.insz = insz;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        City = city;
    }

    public String getInsz() {
        return insz;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return City;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        return insz != null ? insz.equals(member.insz) : member.insz == null;
    }

    @Override
    public int hashCode() {
        return insz != null ? insz.hashCode() : 0;
    }

}
