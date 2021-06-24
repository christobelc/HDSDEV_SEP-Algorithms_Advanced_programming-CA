# HDSDEV_SEP-Algorithms_Advanced_programming-CA
Project Background:
Protect is a hypothetical global research company established in 2020 to protect all health service
employees across the globe from Covid-19 pandemic. Among other tasks, the company collects
details of health service personnel including demographic, medical and other relevant data. So far,
the company managed to collect demographic data of up to 10,000 personnel's (available for
download). This demographic data includes the emp_no (Integer), birth_date (YYYY-MM-DD),
first_name (String), last_name (String), gender (String, M, F) and hire_date (YYYY-MM-DD). The
employee data is already sorted using emp_no. The company’s IT department decided to utilise its
resources to build a light-weight Java application to manage all the records of the employees.
You, as part of the IT team, are assigned to build the software system in Java programming language.
Your responsibility includes analysing and writing program fragments that will efficiently store,
retrieve and manage the employee data. To assist you in completing the task, the IT department
further provides you the following specifications to be completed before 16-04-2021 @18:00.

Part 1: Sorting and Searching: Algorithm Analysis
1. Write a sorting algorithm (algorithm A) that sorts the employee data using the first_name
field. You may choose any efficient sorting algorithm we covered in this module

Input: 10,000 unsorted employee record,
Output: 10,000 employee record sorted in ascending order by first_name

2. Experimentally analyse the time complexity of your sorting algorithm you write for q1
above. Show your results by taking the average elapsed time for 10, 100, 1000, 5000 and
10000 records.

3. Write a searching algorithm that accept the first_name of an employee and searches the
employee record from the dataset. There could be multiple employees with the same
first_name. If no employee is found, display “Not an employee!” message.

Input: 10,000 sorted employee record,
Output: list of employee details with the same first_name as entered by the user

4. Analyse and determine the time complexity of the searching algorithm you write in q3. 


Part 2: Defensive Programming and Exception Handling

1. Write a Java program that accept new employee record (with all the six fields) and add it at
the end of the record with a new consecutive emp_no (after the last employee).
Example Input: (id_number, birth_date, first_name, last_name, gender, hire_date)

2. Write a Java method that checks the correct values of the birth_date . The birth_date should
not be less than 01-01-1950. Also, the company should not higher employees younger than
18 years (current year –18).

Example Invalid input: Birth_date = 1945-04-02 (above retirement age)
Example Invalid input: Birth_date = 2006-10-03 (below the employment age)

3. Write a Java Exception that handles special cases and communicate to users to correct the
cases. A typical special case is that the first_name field cannot be empty or cannot contain
digits only. The exception should generate “Employee first_name cannot be empty. It
cannot have only digits! Please correct this” message.

Example Invalid input: first_name = 2343322
Example Invalid input: first_name =”” 




