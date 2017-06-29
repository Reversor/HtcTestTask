package reversor.test.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employee {
    private String name;

    @SerializedName("phone_number")
    private String phoneNumber;

    private List<String> skills;

    public Employee (String name, String phoneNumber, List<String> skills) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
