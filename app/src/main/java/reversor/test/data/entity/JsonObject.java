package reversor.test.data.entity;

public class JsonObject {
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public JsonObject(Company company) {

        this.company = company;
    }
}
