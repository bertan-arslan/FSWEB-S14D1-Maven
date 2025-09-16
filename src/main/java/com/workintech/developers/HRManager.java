package com.workintech.developers;

public class HRManager extends Employee {
    private JuniorDeveloper[] juniorDevelopers;
    private MidDeveloper[] midDevelopers;
    private SeniorDeveloper[] seniorDevelopers;


    public HRManager(int id, String name, double salary,
                     int juniorSize, int midSize, int seniorSize) {
        super(id, name, salary);
        this.juniorDevelopers = new JuniorDeveloper[juniorSize];
        this.midDevelopers = new MidDeveloper[midSize];
        this.seniorDevelopers = new SeniorDeveloper[seniorSize];
    }


    public HRManager(int id, String name, double salary) {
        this(id, name, salary, 5, 5, 5); // varsayılan olarak 5’erlik arrayler
    }

    @Override
    public void work() {
        System.out.println("HR Manager is managing developers...");
        setSalary(getSalary() + 1500);
    }

    // Junior ekleme
    public void addEmployee(JuniorDeveloper dev) {
        addEmployee(dev, juniorDevelopers);
    }
    public void addEmployee(JuniorDeveloper dev, int index) {
        addEmployee(dev, juniorDevelopers, index);
    }

    // Mid ekleme
    public void addEmployee(MidDeveloper dev) {
        addEmployee(dev, midDevelopers);
    }
    public void addEmployee(MidDeveloper dev, int index) {
        addEmployee(dev, midDevelopers, index);
    }

    // Senior ekleme
    public void addEmployee(SeniorDeveloper dev) {
        addEmployee(dev, seniorDevelopers);
    }
    public void addEmployee(SeniorDeveloper dev, int index) {
        addEmployee(dev, seniorDevelopers, index);
    }

    // Yardımcı generic metodlar
    private <T> void addEmployee(T dev, T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = dev;
                System.out.println(dev + " added to list at index " + i);
                return;
            }
        }
        System.out.println("No empty slot available to add " + dev);
    }

    private <T> void addEmployee(T dev, T[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Invalid index for " + dev);
            return;
        }
        if (arr[index] != null) {
            System.out.println("Index " + index + " is already filled!");
        } else {
            arr[index] = dev;
            System.out.println(dev + " added at index " + index);
        }
    }
}
