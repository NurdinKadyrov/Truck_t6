package com.company;

import com.company.service.TruckService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TruckService service = new TruckService();
        service.creating();
        while (true) {
            service.terminal();
            System.out.println("""
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    Press 1 to changeDriver
                    Press 2 to startDriving
                    Press 3 to startRepair
                    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~""");
            int num = scanner.nextInt();
            switch (num) {
                case 1 -> service.changeDriver();
                case 2 -> service.startDriving();
                case 3 -> service.startRepair();
            }
        }

    }
}
