import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Comparable<Object> {

    private int empNo;
    private String dateOfBirth;
    private String firstName;
    private String lastName;
    private char gender;
    private String hireDate;

    // defualt constructor
    public Employee() {

    }

    // overloaded constructor
    public Employee(int empNo, String dateOfBirth, String firstName, String lastName, char gender, String hireDate)
            throws ParseException {
        this.empNo = empNo;
        this.setDateOfBirth(dateOfBirth);
        this.setFirstName(firstName);
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    // setter with specified business rules
    public void setDateOfBirth(String dateOfBirth) throws ParseException {
        // date format obj
        SimpleDateFormat sdfObj = new SimpleDateFormat("yyyy-MM-dd");

        // declaring the date objects
        Date lowerDate = sdfObj.parse("1950-01-01");
        Date upperDate = sdfObj.parse("2003-01-01");
        Date checking = sdfObj.parse(dateOfBirth);

        if (checking.compareTo(lowerDate) < 0 || checking.compareTo(upperDate) > 0) {
            throw new IllegalArgumentException("Employees between 1950-01-01 and 2003-01-01 are ONLY allowed.");
        } else {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    // setter with specified business rules
    public void setFirstName(String firstName) {
        if (firstName.equals("") || firstName.matches("[0-9]+")) {
            throw new IllegalArgumentException(
                    "Employee first_name cannot be empty. It cannot have only digits! Please correct this");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    // so the employee objects can be compared when sorting/searching
    // NOTE: this will only allow comparisons based on the firstName
    @Override
    public int compareTo(Object obj) {
        Employee emp = (Employee) obj;
        return firstName.compareTo(emp.getFirstName());
    }

    // return a String containing the employee details
    @Override
    public String toString() {
        return empNo + " " + dateOfBirth + " " + firstName + " " + lastName + " " + gender + " " + hireDate;
    }

}