package hw4;

public class Employee {
    private Integer personNo;
    private String phoneNo;
    private String name;
    private Integer experience;

    public Integer getPersonNo() {
        return personNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getName() {
        return name;
    }

    public Integer getExperience() {
        return experience;
    }

    public Employee(Integer personNo, String phoneNo, String name, Integer experience) {
        this.personNo = personNo;
        this.phoneNo = phoneNo;
        this.name = name;
        this.experience = experience;
    }
}
