package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{

    int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }


    @Override
    int getBaseSumParcel() {
        return Parcel.baseSumPerishableParcel;
    }

    public boolean isExpired(int currentDay) {
        if (sendDay + timeToLive <= currentDay)
            return true;
        else
            return false;
    }
}
