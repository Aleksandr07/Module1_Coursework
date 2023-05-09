package coursework1;

import java.lang.module.FindException;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
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


        System.out.println("Задание 1. Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)).");
        employeesList(employees);
        printSeparator();
        System.out.println("Задание 2. Посчитать сумму затрат на зарплаты в месяц.");
        int expensesForSalary = calculateExpensesForSalary(employees);
        System.out.println("Затраты на зарплату в месяц = " + expensesForSalary);
        printSeparator();
        System.out.println("Задание 3. Найти сотрудника с минимальной зарплатой.");
        findEmployeeWithMinSalary(employees);
        printSeparator();
        System.out.println("Задание 4. Найти сотрудника с максимальной зарплатой.");
        findEmployeeWithMaxSalary(employees);
        printSeparator();
        System.out.println("Задание 5. Подсчитать среднее значение зарплат.");
        double meanExpensesForSalary = calculateMeanExpensesForSalary(employees);
        System.out.println("Среднее значение затрат на зарплаты в месяц = " + meanExpensesForSalary);
        printSeparator();
        System.out.println("Задание 6. Получить Ф. И. О. всех сотрудников (вывести в консоль).");
        getNameAllEmployees(employees);
        printSeparator();
        System.out.println("Задание 7. Проиндексировать зарплату.");
        increaseSalary(employees, 10);
        employeesList(employees);
        printSeparator();
        System.out.println("Задание 8. Получить в качестве параметра номер отдела (1–5) и найти сотрудника с минимальной зарплатой");
        findEmployeeWithMinSalaryInDepartment(employees, 2);
        printSeparator();
        System.out.println("Задание 9. Получить в качестве параметра номер отдела (1–5) и найти сотрудника с максимальной зарплатой");
        findEmployeeWithMaxSalaryInDepartment(employees, 4);
        printSeparator();
        System.out.println("Задание 10. Получить в качестве параметра номер отдела (1–5) и найти сумму затрат на зарплату по отделу");
        System.out.println("Затраты на зарплаты по отделу = " + calculateExpensesForSalaryInDepartment(employees, 3));
        printSeparator();
        System.out.println("Задание 11. Получить в качестве параметра номер отдела (1–5) и найти среднюю зарплату по отделу");
        System.out.println("Средняя зарлпата по отделу = " + calculateMeanSalaryInDepartment(employees, 1));
        printSeparator();
        System.out.println("Задание 12. Получить в качестве параметра номер отдела (1–5) и проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра");
        increaseSalaryInDepartment(employees, 2, 10);
        employeesList(employees);
        printSeparator();
        System.out.println("Задание 13. Получить в качестве параметра номер отдела (1–5) и напечатать всех сотрудников отдела (все данные, кроме отдела)");
        printEmployeesInDepartment(employees, 3);
        printSeparator();
        System.out.println("Задание 14. Получить в качестве параметра число и найти всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль)");
        findEmploeesWithSalaryLessThenNumber(employees, 100_000);
        printSeparator();
        System.out.println("Задание 14. Получить в качестве параметра число и найти всех сотрудников с зарплатой больше(или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль)");
        findEmploeesWithSalaryMoreThenNumber(employees, 100_000);
        printSeparator();
    }

    public static void printSeparator() {
        System.out.println("----------------");
    }

    public static void employeesList(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    public static int calculateExpensesForSalary(Employee[] employees) {
        int costForSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            costForSalary += employees[i].getSalary();
        }
        return costForSalary;
    }

    public static void findEmployeeWithMinSalary(Employee[] employees) {
        int minSalary = employees[0].getSalary();
        int minIndex = 0;
        for (int i = 1; i < employees.length; i++) {
            if (minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
                minIndex = i;
            }
        }
        System.out.println(employees[minIndex]);
    }

    public static void findEmployeeWithMaxSalary(Employee[] employees) {
        int maxSalary = employees[0].getSalary();
        int maxIndex = 1;
        for (int i = 0; i < employees.length; i++) {
            if (maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
                maxIndex = i;
            }
        }
        System.out.println(employees[maxIndex]);
    }

    public static double calculateMeanExpensesForSalary(Employee[] employees) {
        return (double) calculateExpensesForSalary(employees) / employees.length;
    }

    public static void getNameAllEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getName());
        }
    }

    public static void increaseSalary(Employee[] employees, int index) {
        for (int i = 0; i < employees.length; i++) {
            employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() * index / 100);
        }
    }

    public static void findEmployeeWithMinSalaryInDepartment(Employee[] employees, int department) {
        int minSalary = 200000;
        int minIndex = 0;
        for (int i = 0; i < employees.length; i++) {
            if (minSalary > employees[i].getSalary() && department == employees[i].getDepartment()) {
                minSalary = employees[i].getSalary();
                minIndex = i;
            }
        }
        System.out.println(employees[minIndex]);
    }

    public static void findEmployeeWithMaxSalaryInDepartment(Employee[] employees, int department) {
        int maxSalary = 0;
        int maxIndex = 0;
        for (int i = 0; i < employees.length; i++) {
            if (maxSalary < employees[i].getSalary() && department == employees[i].getDepartment()) {
                maxSalary = employees[i].getSalary();
                maxIndex = i;
            }
        }
        System.out.println(employees[maxIndex]);
    }

    public static int calculateExpensesForSalaryInDepartment(Employee[] employees, int department) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    public static double calculateMeanSalaryInDepartment(Employee[] employees, int department) {
        int count = 0;
        double mean = 0;
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                mean += (double) employees[i].getSalary();
                count++;
            }
        }
        mean = mean / count;
        return mean;
    }

    public static void increaseSalaryInDepartment(Employee[] employees, int department, int index) {
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                employees[i].setSalary(employees[i].getSalary() + employees[i].getSalary() * index / 100);
            }
        }
    }

    public static void printEmployeesInDepartment(Employee[] employees, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (department == employees[i].getDepartment()) {
                System.out.println("id = " + employees[i].getId() + ", ФИО = " + employees[i].getName() + ", зарплата = " + employees[i].getSalary());
            }
        }
    }

    public static void findEmploeesWithSalaryLessThenNumber(Employee[] employees, int salaryThreshold) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < salaryThreshold) {
                System.out.println("id = " + employees[i].getId() + ", ФИО = " + employees[i].getName() + ", зарплата = " + employees[i].getSalary());
            }
        }
    }

    public static void findEmploeesWithSalaryMoreThenNumber(Employee[] employees, int salaryThreshold) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= salaryThreshold) {
                System.out.println("id = " + employees[i].getId() + ", ФИО = " + employees[i].getName() + ", зарплата = " + employees[i].getSalary());
            }
        }
    }
}
