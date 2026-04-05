package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{

    int baseSumFragileParcel = 3;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    int getBaseSumParcel() {
        return baseSumFragileParcel;
    }


    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }

}
