package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{
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
        return Parcel.baseSumFragileParcel;
    }


    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }

    @Override
    public String getIdentifier() {
        return description;
    }
}
