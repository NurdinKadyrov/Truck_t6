package com.company.service;

import com.company.dao.DriverDao;
import com.company.dao.TruckDao;
import com.company.enums.Situation;
import com.company.enums.State;
import com.company.model.Driver;
import com.company.model.Truck;
import com.company.service.impl.TruckServiceImpl;

import java.util.Scanner;

public class TruckService implements TruckServiceImpl {
    DriverDao driverDao = new DriverDao();
    TruckDao truckDao = new TruckDao();
    Scanner scannerI = new Scanner(System.in);

    public void creating() {
        truckDao.getTruckList().add(new Truck(1, "VOLVO      ", State.BASE, null));
        truckDao.getTruckList().add(new Truck(2, "DAF        ", State.BASE, null));
        truckDao.getTruckList().add(new Truck(3, "MAN        ", State.BASE, null));
        truckDao.getTruckList().add(new Truck(4, "SCANIA     ", State.BASE, null));
        truckDao.getTruckList().add(new Truck(5, "RENAULT    ", State.BASE, null));
        driverDao.getDriverList().add(new Driver(1, "John   ", Situation.FREE));
        driverDao.getDriverList().add(new Driver(2, "Max    ", Situation.FREE));
        driverDao.getDriverList().add(new Driver(3, "Brain  ", Situation.FREE));
        driverDao.getDriverList().add(new Driver(4, "Tom    ", Situation.FREE));
        driverDao.getDriverList().add(new Driver(5, "Hardi  ", Situation.FREE));
        driverDao.getDriverList().add(new Driver(6, "Jimi   ", Situation.FREE));
    }

    public void terminal() {
        System.out.println();
        System.out.println("# | Truck      | Driver  | State");
        System.out.println("——+————————————+—————————+—————————");
        for (Truck truck : truckDao.getTruckList()) {
            System.out.println(truck.getId() + " | " + truck.getName() + "| " + truck.getDriver() + " | " + truck.getState());
        }
        System.out.println();
        System.out.println("#   Driver    |  Situation ");
        System.out.println("—+————————————+————————————+");
        for (Driver driver : driverDao.getDriverList()) {
            System.out.println(driver.getId() + "| " + driver.getName() + " | " + driver.getSituation());
        }
    }

    @Override
    public void changeDriver() {
        try {
            System.out.println("Напишите ID  водителя ");
            int Id = scannerI.nextInt();
            tester(Id);
            for (Driver driver : driverDao.getDriverList()) {
                if (driver.getId() == Id) {
                    if (driver.getSituation().equals(Situation.FREE)) {
                        System.out.println("Напишите ID грузовика ");
                        int id = scannerI.nextInt();
                        test(id);
                        for (Truck truck : truckDao.getTruckList()) {
                            if (truck.getId() == id) {
                                if(truck.getState() == State.ROUTE){
                                    throw new NullPointerException("Грузовик уже в пути не можем поменять водитель!");
                                }
                                else if (truck.getDriver() != null) {
                                    for (Driver drive : driverDao.getDriverList()) {
                                        if (drive.getDriveName() == truck.getDriver()) {
                                            drive.setSituation(Situation.FREE);
                                            drive.setDriveName(null);
                                        }
                                    }
                                }
                                truck.setDriver(driver.getName());
                                driver.setDriveName(truck.getName());
                                driver.setSituation(Situation.BUSY);
                            }
                        }
                    }
                }
            }
            terminal();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void startDriving() {
        try {
            System.out.println("Напишите ID грузовика ");
            int id = scannerI.nextInt();
            test(id);
            for (Truck truck : truckDao.getTruckList()) {
                if (truck.getId() == id) {
                    if (truck.getState() == State.ROUTE) {
                        throw new NullPointerException("Грузовик уже в пути !");
                    }
                    else if (truck.getState() == State.REPAIR) {
                        throw new NullPointerException("Грузовик в ремонте !");
                    }
                    else if (truck.getDriver() != null) {
                        truck.setState(State.ROUTE);
                        System.out.println("ID: " + truck.getId() + ", name: " + truck.getName() + " отправился в пути ");
                    } else if (truck.getDriver() == null) {
                        throw new NullPointerException("Нет водитель грузовика!");
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void startRepair() {
        try {
            System.out.println("Напишите ID грузовика ");
            int ID = scannerI.nextInt();
            test(ID);
            for (Truck truck : truckDao.getTruckList()) {
                if (truck.getId() == ID) {
                    truck.setState(State.REPAIR);
                    System.out.println(" Грузовик пошел на ремонт.");
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private void tester(int num) throws NullPointerException {
        int count = 0;
        for (Driver driver : driverDao.getDriverList()) {
            if (driver.getId() == num) {
                count++;
            }
        }
        if (count == 0) {
            throw new NullPointerException("У на нету такое водитель!");
        }
    }

    private void test(int num) throws NullPointerException {
        int count = 0;
        for (Truck truck : truckDao.getTruckList()) {
            if (truck.getId() == num) {
                count++;
            }
        }
        if (count == 0) {
            throw new NullPointerException("У на нету такое грузовик!");
        }
    }
}
