package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> parcelBoxStandart = new ParcelBox<>(10);
    private static ParcelBox<FragileParcel> parcelBoxFragile = new ParcelBox<>(5);
    private static ParcelBox<PerishableParcel> parcelBoxPerishable = new ParcelBox<>(3);


    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    getAllParcelsInBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Отправить статус для всех посылок, поддерживающих трекинг");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберите тип посылки: 1 - Стандартная посылка. 2 - Хрупка посылка." +
                " 3 - Скоропортящаяся посылка.");
        int choiceType = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите описание посылки: ");
        String description = scanner.nextLine();
        System.out.println("Введите вес посылки: ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите адрес доставки: ");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Введите день месяца отправления: ");
        int sendDay = Integer.parseInt(scanner.nextLine());
        switch (choiceType) {
            case 1: {
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                parcelBoxStandart.addParcel(standardParcel);
                break;
            }
            case 2: {
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                parcelBoxFragile.addParcel(fragileParcel);
                if (fragileParcel instanceof Trackable) {
                    trackableParcels.add((Trackable) fragileParcel);
                }
                break;
            }
            case 3: {
                System.out.println("Введите количество дней за которые посылка не испортится: ");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay,
                        timeToLive);
                allParcels.add(perishableParcel);
                parcelBoxPerishable.addParcel(perishableParcel);
                break;
            }
        }


    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int cost = 0;
        for (Parcel parcel : allParcels) {
            cost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок: " + cost);
    }

    private static void reportStatus() {
        for (Trackable trackable : trackableParcels) {
            System.out.println("Введите новое местоположение для \"" + trackable.getIdentifier() + "\": ");
            String newStatus = scanner.nextLine();
            trackable.reportStatus(newStatus);
        }
    }

    private static void getAllParcelsInBox() {
        System.out.println(("Выберите коробку с определенным типом посылок: 1 - Стандартные посылки. " +
                "2 - Хрупкие посылки. 3 - Скоропортящиеся посылки."));
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1: {
                ArrayList<StandardParcel> parcels = parcelBoxStandart.getAllParcels();
                if (parcels.isEmpty()) {
                    System.out.println("Коробка пустая");
                } else {
                    for (Parcel parcel : parcels){
                        System.out.println(parcel.toString());
                    }
                }
                break;
            }
            case 2: {
                ArrayList<FragileParcel> parcels = parcelBoxFragile.getAllParcels();
                if (parcels.isEmpty()) {
                    System.out.println("Коробка пустая");
                } else {
                    for (Parcel parcel : parcels){
                        System.out.println(parcel.toString());
                    }
                }
                break;
            }
            case 3: {
                ArrayList<PerishableParcel> parcels = parcelBoxPerishable.getAllParcels();
                if (parcels.isEmpty()) {
                    System.out.println("Коробка пустая");
                } else {
                    for (Parcel parcel : parcels){
                        System.out.println(parcel.toString());
                    }
                }
                break;
            }
            default:{
                System.out.println("Неверный выбор!");
            }
        }
    }

}
