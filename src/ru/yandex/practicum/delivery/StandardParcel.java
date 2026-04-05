package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{

    int baseSumStandardParcel = 5;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    int getBaseSumParcel() {
        return baseSumStandardParcel;
    }

}
