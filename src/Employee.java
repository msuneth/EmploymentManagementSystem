import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Employee {
    int empIndex;
    int empNo;
    String name;
    LocalDate DateOfBirth;
    LocalDate JoinedDate;
    long phoneNo;
    String email;
    String status;
    String division;

    /*public Employee(String empIndex,String empNo, String name, String dateOfBirth, String phoneNo, String email, String status, String division,String joinedDate) {
        this.empIndex=Integer.parseInt(empIndex);
        this.empNo = Integer.parseInt(empNo);
        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        this.DateOfBirth = LocalDate.parse(dateOfBirth, formatter);
        this.JoinedDate = LocalDate.parse(joinedDate, formatter);
        this.phoneNo = Long.parseLong(phoneNo);
        this.email = email;
        this.status = status;
        this.division = division;
    } */


    public Employee(String[] empInfo) {
        this.empIndex=Integer.parseInt(empInfo[0]);
        this.empNo = Integer.parseInt(empInfo[1]);
        this.name = empInfo[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.DateOfBirth = LocalDate.parse(empInfo[3], formatter);
        this.JoinedDate = LocalDate.parse(empInfo[8], formatter);
        this.phoneNo = Long.parseLong(empInfo[4]);
        this.email = empInfo[5];
        this.status = empInfo[6];
        this.division = empInfo[7];
    }
}
