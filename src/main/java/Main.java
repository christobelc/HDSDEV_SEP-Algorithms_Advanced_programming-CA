import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        List<String[]> list = new LinkedList<String[]>();
        try {
            // copy unparsed data from the csv file
            list = readFromCsvFile(",", "employees_data.csv");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        // remove the headings in the csv file from the list.
        list.remove(0);

        /*
         * ***************** Part 1 - Q1 sort 10,000 records by first name
         * **************
         */
        MergeSort<Employee> sorter = new MergeSort<>();
        ArrayList<Employee> employees = parseArrayList(list, 10000);
        sorter.mergeSort(employees);

        // print sorted arraylist to commandline
        // for (Employee employee : employees) {
        // System.out.println(employee);
        // }

        System.out.println();
        System.out.println("*********** Merge sort Test Cases **************");
        /*
         * *********************** Part 1 - Q2 Merge Sort Test Cases *******************
         */
        // ---------------- Merge Sort Test Case 1------------------------------------
        employees = parseArrayList(list, 10);

        long startTime = System.nanoTime();
        sorter.mergeSort(employees);
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);

        System.out.println("For input=10 The time taken in nanoseconds is: " + elapsedTime);

        // ---------------- Merge Sort Test Case 2------------------------------------
        employees = parseArrayList(list, 100);

        startTime = System.nanoTime();
        sorter.mergeSort(employees);
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime);

        System.out.println("For input=100 The time taken in nanoseconds is: " + elapsedTime);

        // ---------------- Merge Sort Test Case 3------------------------------------
        employees = parseArrayList(list, 1000);

        startTime = System.nanoTime();
        sorter.mergeSort(employees);
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime);

        System.out.println("For input=1000 The time taken in nanoseconds is: " + elapsedTime);

        // ---------------- Merge Sort Test Case 4------------------------------------
        employees = parseArrayList(list, 5000);

        startTime = System.nanoTime();
        sorter.mergeSort(employees);
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime);

        System.out.println("For input=5000 The time taken in nanoseconds is: " + elapsedTime);

        // ---------------- Merge Sort Test Case 5------------------------------------
        employees = parseArrayList(list, 10000);

        startTime = System.nanoTime();
        sorter.mergeSort(employees);
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime);

        System.out.println("For input=10000 The time taken in nanoseconds is: " + elapsedTime);

        // ---------------------------------------------------------------------------

        System.out.println();
        System.out.println("*********** Search an employee from the record **************");
        /*
         * *********************** Part 1 - Q3 Search and Return Names
         * *******************
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a name to search: ");
        String name = scanner.next();
        // Checks case
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();

        BinarySearch searcher1 = new BinarySearch();
        int indexfound = searcher1.binarySearch(employees, name);
        int[] upperLowerBound;

        // // check if employee exisits
        if (indexfound != -1) {
            upperLowerBound = searcher1.upperLowerBound(employees, indexfound, name);
            System.out.println((upperLowerBound[1] - upperLowerBound[0] + 1) + " Employee/Employees found!");
            for (int i = upperLowerBound[0]; i <= upperLowerBound[1]; i++) {
                System.out.println(employees.get(i));
            }
        } else {
            System.out.println("Is " + name + " an employee?");
            System.out.println("Not an employee!");
        }

        System.out.println();
        System.out.println("*********** Binary Search Test Cases **************");
        // ********************* Part 1 - Q4 Binary Search Test Cases *****************
        // */

        // --------- Binary Search Test Case 1------------------------------------
        name = "Duangkaew";
        employees = parseArrayList(list, 10);
        sorter.mergeSort(employees);

        startTime = System.nanoTime();
        indexfound = searcher1.binarySearch(employees, name);
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime);
        System.out.println("For Input = 10 the time taken to search one instance(index) of the name " + name + " took "
                + elapsedTime + " nanoseconds.");

        System.out.println("");
        // -------- Binary Search Test Case 2------------------------------------

        name = "Georgy";
        employees = parseArrayList(list, 100);
        sorter.mergeSort(employees);

        startTime = System.nanoTime();
        indexfound = searcher1.binarySearch(employees, name);
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime);
        System.out.println("For Input = 100 the time taken to search one instance(index) of the name " + name + " took "
                + elapsedTime + " nanoseconds.");

        System.out.println("");

        // -------- Binary Search Test Case 3------------------------------------

        name = "Theirry";
        employees = parseArrayList(list, 1000);
        sorter.mergeSort(employees);

        startTime = System.nanoTime();
        indexfound = searcher1.binarySearch(employees, name);
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime);
        System.out.println("For Input = 1000 the time taken to search one instance(index) of the name " + name
                + " took " + elapsedTime + " nanoseconds.");

        System.out.println("");

        // --------- Binary Search Test Case 4------------------------------------

        name = "Tadahiko";// 8 enteries
        employees = parseArrayList(list, 5000);
        sorter.mergeSort(employees);

        startTime = System.nanoTime();
        indexfound = searcher1.binarySearch(employees, name);
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime);
        System.out.println("For Input = 5000 the time taken to search one instance(index) of the name " + name
                + " took " + elapsedTime + " nanoseconds.");

        System.out.println("");

        // --------- Binary Search Test Case 5------------------------------------

        name = "Wayne";
        employees = parseArrayList(list, 10000);
        sorter.mergeSort(employees);

        startTime = System.nanoTime();
        indexfound = searcher1.binarySearch(employees, name);
        endTime = System.nanoTime();
        elapsedTime = (endTime - startTime);
        System.out.println("For Input = 10000 the time taken to search one instance(index) of the name " + name
                + " took " + elapsedTime + " nanoseconds.");

        System.out.println("");

        System.out.println("*********** Add an Employeee and print out all employee records **************");
        // ********************* Part 2 - Q1 Add User ***************** */

        // ---------------- Add User ------------------------------------

        // Q2 Add an employee record to the end of the array

        // Calls a static method adding employee from user input - line 261
        Employee newEmployee = newEmployee();
        List<Employee> newlist = new ArrayList<>();

        // lets parse the original list for 10000 employee records - line 245
        newlist = parseArrayList(list, 10000);

        // add employee too the oringial list - line 331
        addEmployee(newlist, newEmployee);

        // print all the employees
        for (Employee employee : newlist) {
            System.out.println(employee);
        }
    }
    // ************** end of main method***************** */

    // Reads in file from csv
    public static List<String[]> readFromCsvFile(String separator, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<String[]> list = new ArrayList<>();
            String line = "";
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\"", "");
                String[] array = line.split(separator);
                list.add(array);
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // make an employee array of inputted length
    public static ArrayList<Employee> parseArrayList(List<String[]> list, int noOfRecords) {
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            // parse data to Arraylist object
            for (int i = 0; i < noOfRecords; i++) {
                employees.add(i, new Employee(Integer.parseInt(list.get(i)[0]), list.get(i)[1], list.get(i)[2],
                        list.get(i)[3], list.get(i)[4].charAt(0), list.get(i)[5]));
            }
        } catch (Exception e) {
            throw new ArrayIndexOutOfBoundsException(
                    "the inputted number is greater than the amounts of enteries in the list");
        }
        return employees;
    }

    // User Input a new employee from the command line
    public static Employee newEmployee() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        String stringInput = "";
        char charInput;
        Employee addNewEmployee = new Employee();

        // ********************* Part 2 - Q3 Validate Name ***************** */
        while (!flag) {
            System.out.println("Enter First Name: ");
            stringInput = scanner.nextLine();
            try {
                if (!validateFirstName(stringInput)) {
                    throw new IllegalArgumentException();
                } else {
                    addNewEmployee.setFirstName(stringInput);
                    flag = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(
                        "Employee first_name cannot be empty. It cannot have only digits! Please correct this");
            }
        }

        flag = false;
        while (!flag) {
            System.out.println("Enter Surname Name: ");
            stringInput = scanner.next();
            if (!stringInput.matches("[0-9]+") && !stringInput.equals("")) {
                addNewEmployee.setLastName(stringInput);
                flag = true;
            }
        }

        // ********************* Part 2 - Q2 Validate Birthday ***************** */
        flag = false;
        while (!flag) {
            System.out.println("Enter Date of Birth (YYYY-MM-DD): ");
            System.out.println("Employees between 1950-01-01 and 2003-01-01 are ONLY allowed.");

            stringInput = scanner.next();
            // input format for RegEx -> dddd-dd-dd (d = digit)
            if (stringInput.matches("(\\d{4})-(\\d{2})-(\\d{2})")) {
                try {
                    if (validateDateOfBirth(stringInput)) {
                        addNewEmployee.setDateOfBirth(stringInput);
                        flag = true;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        flag = false;
        while (!flag) {
            System.out.println("Enter Date of Hire (YYYY-MM-DD): ");

            stringInput = scanner.next();
            if (stringInput.matches("(\\d{4})-(\\d{2})-(\\d{2})")) {
                addNewEmployee.setHireDate(stringInput);
                flag = true;
            }
        }

        flag = false;
        while (!flag) {
            System.out.println("Enter gender (M/F): ");
            // takes the first char
            charInput = scanner.next().charAt(0);
            stringInput = Character.toString(charInput);
            // checks the single char for input
            if (stringInput.matches("M|m|F|f")) {
                addNewEmployee.setGender(Character.toUpperCase(charInput));
                flag = true;
            }
        }

        scanner.close();
        return addNewEmployee;
    }

    // add employee with consecutive employee number
    public static void addEmployee(List<Employee> employees, Employee employee) {
        Employee temp = employees.get(employees.size() - 1);
        employee.setEmpNo(temp.getEmpNo() + 1);
        employees.add(employee);
    }

    // validate date of birth
    public static boolean validateDateOfBirth(String dateOfBirth) throws ParseException {
        // date format obj
        SimpleDateFormat sdfObj = new SimpleDateFormat("yyyy-MM-dd");

        // declaring the date objects
        Date lowerDate = sdfObj.parse("1950-01-01");
        Date upperDate = sdfObj.parse("2003-01-01");
        Date checking = sdfObj.parse(dateOfBirth);

        if (checking.compareTo(lowerDate) < 0 || checking.compareTo(upperDate) > 0) {
            return false;
        } else {
            return true;
        }
    }

    // defines the business rule name cant be empty string or contain only digits
    public static boolean validateFirstName(String firstName) {
        if (firstName.equals("") || firstName.matches("[0-9]+")) {
            return false;
        }
        return true;
    }
}