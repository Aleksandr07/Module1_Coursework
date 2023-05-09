package coursework1;

import java.util.Objects;

public class Employee {
    private String name; // ФИО сотрудника
    private int department; // Отдел, в котором работает сотрудник (Заполняется цифрами 1-5)
    private int salary; // Заработная плата сотрудника
    private int id;
    public static int idCount; // Переменная-счетчик, отвечающая за id сотрудника

    public Employee(String name, int department, int salary) {
        this.id = ++idCount;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Номер отдела должен быть назван от 1 до 5");
        }
        this.department = department;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id = " + id + ", ФИО = " + name + ", отдел = " + department + ", зарплата = " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
