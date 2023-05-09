package coursework1;
import java.util.Scanner;
import java.lang.module.FindException;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        /*Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов Иван Иванович", 1, (int) (Math.random() * 200_000));
        employees[1] = new Employee("Сидоров Дмитрий Владимирович", 2, (int) (Math.random() * 200_000));
        employees[2] = new Employee("Петрова Евгения Николаевна", 3, (int) (Math.random() * 200_000));
        employees[3] = new Employee("Артамонова Полина Давидовна", 4, (int) (Math.random() * 200_000));
        employees[4] = new Employee("Давыдов Арсений Ильич", 5, (int) (Math.random() * 200_000));
        employees[5] = new Employee("Попова Юлия Константиновна", 1, (int) (Math.random() * 200_000));
        employees[6] = new Employee("Новиков Мирон Вячеславович", 2, (int) (Math.random() * 200_000));
        employees[7] = new Employee("Жданов Михаил Владиславович", 3, (int) (Math.random() * 200_000));
        employees[8] = new Employee("Панфилов Роман Тимофеевич", 4, (int) (Math.random() * 200_000));
        employees[9] = new Employee("Сергеева Мария Романовна", 5, (int) (Math.random() * 200_000));
*/
        System.out.println("Функции программы:");
        System.out.println("Введите 1 - ввод сотрудника");
        System.out.println("Введите 2 - удаление сотрудника (по ФИО)");
        System.out.println("Введите 3 - удаление сотрудника (по id)");
        System.out.println("Введите 4 - получить список всех сотрудников со всеми имеющимися по ним данными");
        System.out.println("Введите 5 - посчитать сумму затрат на зарплаты в месяц");
        System.out.println("Введите 6 - найти сотрудника с минимальной зарплатой");
        System.out.println("Введите 7 - найти сотрудника с максимальной зарплатой");
        System.out.println("Введите 8 - подсчитать среднее значение зарплат");
        System.out.println("Введите 9 - получить Ф. И. О. всех сотрудников");
        System.out.println("Введите 10 - проиндексировать зарплату");
        System.out.println("Введите 11 - получить в качестве параметра номер отдела (1–5) и найти сотрудника с минимальной зарплатой");
        System.out.println("Введите 12 - получить в качестве параметра номер отдела (1–5) и найти сотрудника с максимальной зарплатой");
        System.out.println("Введите 13 - получить в качестве параметра номер отдела (1–5) и найти сумму затрат на зарплату по отделу");
        System.out.println("Введите 14 - получить в качестве параметра номер отдела (1–5) и найти среднюю зарплату по отделу");
        System.out.println("Введите 15 - получить в качестве параметра номер отдела (1–5) и проиндексировать зарплату всех сотрудников отдела");
        System.out.println("Введите 16 - получить в качестве параметра номер отдела (1–5) и напечатать всех сотрудников отдела");
        System.out.println("Введите 17 - получить в качестве параметра число и найти всех сотрудников с зарплатой меньше числа");
        System.out.println("Введите 18 - получить в качестве параметра число и найти всех сотрудников с зарплатой больше(или равно) числа");
        System.out.println("Введите 19 - изменить сотрудника");
        System.out.println("Введите 20 - получить Ф. И. О. всех сотрудников по отделам ");
        System.out.println("Введите 99 - выход из программы");

        EmployeeBook employeeBook = new EmployeeBook();
        boolean isEscape = true;
        int command = 0;
        String name = null;
        int department = 0;
        int salary = 0;
        int index = 0;
        int id = 0;
        int threshold = 0;
        int salaryOrDepartment = 0;
        int changeParameter = 0;
        while (isEscape) {
            System.out.println("Введите команду");
            command = console.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Введите Ф. И. О.");
                    console.nextLine();
                    name = console.nextLine();
                    System.out.println("Введите отдел (число от 1 до 5)");
                    department = console.nextInt();
                    System.out.println("Введите зарплату");
                    salary = console.nextInt();
                    employeeBook.addEmployee(name, department, salary);
                    printSeparator();
                    break;
                case 2:
                    System.out.println("Введите Ф. И. О.");
                    console.nextLine();
                    name = console.nextLine();
                    employeeBook.deleteEmployeeOnName(name);
                    printSeparator();
                    break;
                case 3:
                    System.out.println("Введите id");
                    id = console.nextInt();
                    employeeBook.deleteEmployeeOnId(id);
                    printSeparator();
                    break;
                case 4:
                    employeeBook.employeesList();
                    printSeparator();
                    break;
                case 5:
                    System.out.println(employeeBook.calculateExpensesForSalary());
                    printSeparator();
                    break;
                case 6:
                    employeeBook.findEmployeeWithMinSalary();
                    printSeparator();
                    break;
                case 7:
                    employeeBook.findEmployeeWithMaxSalary();
                    printSeparator();
                    break;
                case 8:
                    System.out.println(employeeBook.calculateMeanExpensesForSalary());
                    printSeparator();
                    break;
                case 9:
                    employeeBook.getNameAllEmployees();
                    printSeparator();
                    break;
                case 10:
                    System.out.println("Введите число в процентах, на которое необходимо проиндексировать зарплату");
                    index = console.nextInt();
                    employeeBook.increaseSalary(index);
                    printSeparator();
                    break;
                case 11:
                    System.out.println("Введите номер отдела");
                    department = console.nextInt();
                    employeeBook.findEmployeeWithMinSalaryInDepartment(department);
                    printSeparator();
                    break;
                case 12:
                    System.out.println("Введите номер отдела");
                    department = console.nextInt();
                    employeeBook.findEmployeeWithMaxSalaryInDepartment(department);
                    printSeparator();
                    break;
                case 13:
                    System.out.println("Введите номер отдела");
                    department = console.nextInt();
                    System.out.println(employeeBook.calculateExpensesForSalaryInDepartment(department));
                    printSeparator();
                    break;
                case 14:
                    System.out.println("Введите номер отдела");
                    department = console.nextInt();
                    System.out.println(employeeBook.calculateMeanSalaryInDepartment(department));
                    printSeparator();
                    break;
                case 15:
                    System.out.println("Введите номер отдела");
                    department = console.nextInt();
                    System.out.println("Введите число в процентах, на которое необходимо проиндексировать зарплату");
                    index = console.nextInt();
                    employeeBook.increaseSalaryInDepartment(department, index);
                    printSeparator();
                    break;
                case 16:
                    System.out.println("Введите номер отдела");
                    department = console.nextInt();
                    employeeBook.printEmployeesInDepartment(department);
                    printSeparator();
                    break;
                case 17:
                    System.out.println("Введите порог зарплаты");
                    threshold = console.nextInt();
                    employeeBook.findEmployeesWithSalaryLessThenNumber(threshold);
                    printSeparator();
                    break;
                case 18:
                    System.out.println("Введите порог зарплаты");
                    threshold = console.nextInt();
                    employeeBook.findEmployeesWithSalaryMoreThenNumber(threshold);
                    printSeparator();
                    break;
                case 19:
                    System.out.println("Введите Ф. И. О.");
                    console.nextLine();
                    name = console.nextLine();
                    System.out.println("Введите параметр, который хотите изменить");
                    System.out.println("1 - зарплата");
                    System.out.println("2 - отдел");
                    salaryOrDepartment = console.nextInt();
                    System.out.println("Введите значение, на которое хотите изменить");
                    changeParameter = console.nextInt();
                    employeeBook.changeEmployees(name, salaryOrDepartment, changeParameter);
                    printSeparator();
                    break;
                case 20:
                    employeeBook.getNameSortDepartment();
                    printSeparator();
                    break;
                case 99:
                    System.out.println("До свидания!");
                    printSeparator();
                    isEscape = false;
                    break;
            }
        }
    }

    public static void printSeparator() {
        System.out.println("----------------");
    }

}
