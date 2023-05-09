package coursework1;
public class EmployeeBook {
    private final int EMPLOYEE_BOOK_SIZE = 10;
    private Employee[] employees = new Employee[EMPLOYEE_BOOK_SIZE];

    private int count;
    private int sizeBook;


    public void addEmployee(String name, int department, int salary) {
        int index = findEmptyCell();
        if (index == -1) {
            System.out.println("Хранилище переполнено");
        } else {
            employees[index] = new Employee(name, department, salary);
        }
    }

    public void deleteEmployeeOnName(String name) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
            } else {
                if (employees[i].getName().equals(name)) {
                    employees[i] = null;
                }
            }
        }
    }
    public void deleteEmployeeOnId(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
            } else {
                if (employees[i].getId() == id) {
                    employees[i] = null;
                }
            }
        }
    }

    public void employeesList() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public int calculateExpensesForSalary() {
        int costForSalary = 0;
        for (Employee employee : employees) {
            if (employee == null) {
            } else {
                costForSalary += employee.getSalary();
            }
        }
        return costForSalary;
    }

    public void findEmployeeWithMinSalary() {
        int minSalary = employees[0].getSalary();
        int minIndex = 0;
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] == null) {
            } else {
                if (minSalary > employees[i].getSalary()) {
                    minSalary = employees[i].getSalary();
                    minIndex = i;
                }
            }
        }
        System.out.println(employees[minIndex]);
    }

    public void findEmployeeWithMaxSalary() {
        int maxSalary = employees[0].getSalary();
        int maxIndex = 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
            } else {
                if (maxSalary < employees[i].getSalary()) {
                    maxSalary = employees[i].getSalary();
                    maxIndex = i;
                }
            }
        }
        System.out.println(employees[maxIndex]);
    }

    public double calculateMeanExpensesForSalary() {
        return (double) calculateExpensesForSalary() / employees.length;
    }

    public void getNameAllEmployees() {
        for (Employee employee : employees) {
            if (employee == null) {
            } else {
                System.out.println(employee.getName());
            }
        }
    }

    public void increaseSalary(int index) {
        for (Employee employee : employees) {
            if (employee == null) {
            } else {
                employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
            }
        }
    }

    public void findEmployeeWithMinSalaryInDepartment(int department) {
        int minSalary = 200000;
        int minIndex = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
            } else {
                if (minSalary > employees[i].getSalary() && department == employees[i].getDepartment()) {
                    minSalary = employees[i].getSalary();
                    minIndex = i;
                }
            }
        }
        System.out.println(employees[minIndex]);
    }

    public void findEmployeeWithMaxSalaryInDepartment(int department) {
        int maxSalary = 0;
        int maxIndex = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
            } else {
                if (maxSalary < employees[i].getSalary() && department == employees[i].getDepartment()) {
                    maxSalary = employees[i].getSalary();
                    maxIndex = i;
                }
            }
        }
        System.out.println(employees[maxIndex]);
    }

    public int calculateExpensesForSalaryInDepartment(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee == null) {
            } else {
                if (employee.getDepartment() == department) {
                    sum += employee.getSalary();
                }
            }
        }
        return sum;
    }

    public double calculateMeanSalaryInDepartment(int department) {
        int count = 0;
        double mean = 0;
        for (Employee employee : employees) {
            if (employee == null) {
            } else {
                if (department == employee.getDepartment()) {
                    mean += (double) employee.getSalary();
                    count++;
                }
            }
        }
        mean = mean / count;
        return mean;
    }

    public void increaseSalaryInDepartment(int department, int index) {
        for (Employee employee : employees) {
            if (employee == null) {
            } else {
                if (department == employee.getDepartment()) {
                    employee.setSalary(employee.getSalary() + employee.getSalary() * index / 100);
                }
            }
        }
    }

    public void printEmployeesInDepartment(int department) {
        for (Employee employee : employees) {
            if (employee == null) {
            } else {
                if (department == employee.getDepartment()) {
                    System.out.println("id = " + employee.getId() + ", ФИО = " + employee.getName() + ", зарплата = " + employee.getSalary());
                }
            }
        }
    }

    public void findEmployeesWithSalaryLessThenNumber(int salaryThreshold) {
        for (Employee employee : employees) {
            if (employee == null) {
            } else {
                if (employee.getSalary() < salaryThreshold) {
                    System.out.println("id = " + employee.getId() + ", ФИО = " + employee.getName() + ", зарплата = " + employee.getSalary());
                }
            }
        }
    }

    public void findEmployeesWithSalaryMoreThenNumber(int salaryThreshold) {
        for (Employee employee : employees) {
            if (employee == null) {
            } else {
                if (employee.getSalary() >= salaryThreshold) {
                    System.out.println("id = " + employee.getId() + ", ФИО = " + employee.getName() + ", зарплата = " + employee.getSalary());
                }
            }
        }
    }

    public void changeEmployees(String name, int salaryOrDepartment, int changeParameter) {
        for (Employee employee : employees) {
            if (employee == null) {
            } else {
                if (employee.getName().equals(name)) {
                    if (salaryOrDepartment == 1) {
                        employee.setSalary(changeParameter);
                    } else if (salaryOrDepartment == 2) {
                        employee.setDepartment(changeParameter);
                    }
                }
            }
        }
    }

    public void getNameSortDepartment() {
        for (int departmentIndex = 1; departmentIndex <= 5; departmentIndex++) {
            System.out.println("Отдел " + departmentIndex);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                } else {
                    if (employees[i].getDepartment() == departmentIndex) {
                        System.out.println(employees[i].getName());
                    }
                }
            }
            System.out.println("----------");
        }
    }

    private int findEmptyCell() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }

        return -1;
    }
}
