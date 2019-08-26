package com.sano.tin;

import com.sano.worker.*;

import java.util.HashSet;
import java.util.Set;

public class TinsCompany {

    private Set<Worker> workers;
    private int totalProfit = 0;
    private int beginnerToolPrice = 50000;
    private int mediumWorkerToolPrice = 35000;
    private int proWorkerToolPrice = 25000;


    private TinsCompany() {
        this.workers = new HashSet<>();
    }

    private void simulateThreeMonths() {
        for (int i = 0; i < 3; i++) {
            simulateOneMonth();
        }
    }

    private void simulateOneMonth() {
        for (int i = 1; i < 31; i++) {
            setSecretary();
            if (i < 6) {
                System.out.println(i);
                for (Worker worker : workers) {
                    totalProfit += worker.working();
                }
            } else if (i == 6) {
                System.out.println(i);
                for (Worker worker : workers) {
                    if (worker instanceof Electrician || worker instanceof GasFitter) {
                        ((Holiday) worker).setHoliday(true);
                        totalProfit += worker.working();
                    } else {
                        totalProfit += worker.working();
                    }
                }

            } else if (i <= 12) {
                System.out.println(i);
                for (Worker worker : workers) {
                    if (worker instanceof Electrician || worker instanceof GasFitter) {
                        ((Holiday) worker).Holiday();
                    } else {
                        totalProfit += worker.working();
                    }
                }
            } else if (i == 13) {
                System.out.println((i));
                for (Worker worker : workers) {
                    if (worker instanceof Electrician || worker instanceof GasFitter) {
                        ((Holiday) worker).setHoliday(false);
                        ((Holiday) worker).Holiday();
                    } else {
                        totalProfit += worker.working();
                    }
                }
            } else if (i < 30) {
                System.out.println(i);
                for (Worker worker : workers) {
                    totalProfit += worker.working();
                }
            } else {
                System.out.println(i);
                for (Worker worker : workers) {
                    totalProfit += worker.working();
                    buyTools(worker);
                }
            }
        }

    }

    private void buyTools(Worker worker) {
        switch (worker.getSkillLevel()) {
            case PRO:
                totalProfit -= this.proWorkerToolPrice;
                break;
            case MEDIUM_LEVEL:
                totalProfit -= this.mediumWorkerToolPrice;
                break;
            case BEGINNER:
                totalProfit -= this.beginnerToolPrice;
        }
    }

    private void setSecretary() {
        for (Worker worker : workers) {
            if (worker instanceof Electrician || worker instanceof GasFitter) {
                if (!((Holiday) worker).isOnHoliday()) {
                    worker.setSecretaryOfTheday(worker);
                    System.out.println("The secretary is today: " + worker.getName());
                    for (Worker worker1 : workers) {
                        worker1.setSecretaryOfTheday(worker);
                    }
                    break;
                } else {
                    System.out.println(worker.getName() + " say: I won't be secretary because I am in my mandatory holiday");
                }
            } else {
                for (Worker worker1 : workers) {
                    if (!(worker1 instanceof Electrician || worker1 instanceof GasFitter)) {
                        worker1.setSecretaryOfTheday(worker1);
                        for (Worker worker2 : workers) {
                            worker2.setSecretaryOfTheday(worker1);
                        }
                        System.out.println("I am the secretary is today: " + worker1.getName());
                        break;
                    }
                }
                break;
            }
        }
    }

    private void printSalaries() {
        for (Worker worker : workers) {
            System.out.println(worker.getName() + " ---saéary:  " + worker.getTotalRecivedSalary());
        }
    }


    public static void main(String[] args) {
        TinsCompany company = new TinsCompany();
        company.workers.add(new Electrician("Mátyás"));
        company.workers.add(new Plumber("Géza"));
        company.workers.add(new GasFitter("András"));
        company.workers.add(new Electrician("Carol"));
        company.workers.add(new Plumber("Hemp"));
        company.workers.add(new GasFitter("Andrew"));
        company.simulateThreeMonths();
        System.out.println(company.totalProfit);
        company.printSalaries();

    }


}
