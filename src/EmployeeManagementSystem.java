import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    public EmployeeManagementSystem() {
        System.out.println("Welcome to Employee Management System");
        while(true){
            displayOperations();
            int userInput = getUserInput();
            selectOperation(userInput);
        }
    }

    public void displayOperations(){
        //System.out.println("==============================");
        System.out.println();
        System.out.println("1-View All Employees");
        System.out.println("2-Search Employee");
        System.out.println("3-Add Employee");
        System.out.println("4-Edit Employee");
        System.out.println("5-Delete Employee");
        System.out.println("9-Exit");
        System.out.print("Please select the operation:");
    }

    public int getUserInput(){
        try {
            Scanner userInput = new Scanner(System.in);
            return userInput.nextInt();
        }catch (Exception e){
            System.out.println("Invalid Character. Please try again");
            return 6;
        }
    }

    public void selectOperation(int userOperation){
        switch (userOperation){
            case 1:
                viewAllEmployees();
                break;
            case 2:
                searchEmployee();
                break;
            case 3:
                addEmployee();
                break;
            case 4:
                editEmployee();
                break;
            case 5:
                deleteEmployee();
                break;
            case 6:
                break;
            case 9:
                System.exit(0);
            default:
                System.out.println("Invalid Operation.Please try again");
                break;
        }
    }

    public void viewAllEmployees(){
        ArrayList<Employee> empList= readDataFile();
        for (Employee emp: empList
             ) {
           System.out.println(emp.name+","+emp.empNo+","+emp.DateOfBirth+","+emp.email+","+emp.phoneNo+","+emp.division+","+emp.JoinedDate+","+emp.status);
        }
    }

    public ArrayList<Employee> readDataFile(){
        try{
            ArrayList<Employee> employees = new ArrayList<Employee>();
            File dataFile= new File("src\\datafile.txt");
            Scanner fileReader = new Scanner(dataFile);
            while (fileReader.hasNextLine()){
                String[] lineData = fileReader.nextLine().split(",");
                Employee temp = new Employee(lineData);
                employees.add(temp);
            }
            return employees;
        }catch (FileNotFoundException e){
            ArrayList<Employee> employeesNull = new ArrayList<Employee>();
            return employeesNull;
        }
    }


    public void searchEmployee(){
        System.out.print("Enter Employee Name to search:");
        Scanner searchPrefix = new Scanner(System.in);
        String searchName = searchPrefix.nextLine();
        ArrayList<Employee> empList= readDataFile();
        for (Employee emp: empList
        ) if(emp.name.contains(searchName) ){
            System.out.println(emp.name+","+emp.empNo+","+emp.DateOfBirth+","+emp.email+","+emp.phoneNo+","+emp.division+","+emp.JoinedDate+","+emp.status);
        }
    }

    public void addEmployee(){
        ArrayList<Employee> currentEmpList= readDataFile();
        int empCount= currentEmpList.size();
        String[] newUser = getNewEmployeeInfo();
        newUser[0]= String.valueOf((empCount+1));
        //Employee newEmp= new Employee(newUser);
        //currentEmpList.add(newEmp);
        writeToDataFile(newUser);

    }

    public String[]  getNewEmployeeInfo(){
        Scanner getEmpInfo = new Scanner(System.in);
        String[] empInfo = new String[9];
        System.out.print("Enter Employee No:");
        empInfo[1]=getEmpInfo.nextLine();
        System.out.print("\nEnter Name:");
        empInfo[2]=getEmpInfo.nextLine();
        System.out.print("\nEnter Date of Birth(yyyy-mm-dd):");
        empInfo[3]=getEmpInfo.nextLine();
        System.out.print("\nEnter Phone No:");
        empInfo[4]=getEmpInfo.nextLine();
        System.out.print("\nEnter Email:");
        empInfo[5]=getEmpInfo.nextLine();
        empInfo[6]="active";
        System.out.print("\nEnter Division:");
        empInfo[7]=getEmpInfo.nextLine();
        System.out.print("\nEnter Joined Date(yyyy-mm-dd):");
        empInfo[8]=getEmpInfo.nextLine();
        return empInfo;
    }

    public void writeToDataFile(String[] userInfo){
        try {
            FileWriter fw = new FileWriter("src\\datafile.txt",true);
            String userInfoStr= String.join(",",userInfo);
            fw.append("\n"+userInfoStr);
            //fw.write(userInfoStr);
            fw.close();
            System.out.println("Employee added successfully");
        }catch (IOException e){
            System.out.println("Unable to add employee information");
        }
    }
    public void editEmployee(){

    }

    public void deleteEmployee(){

    }













}
