package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {

    int maxBoxWeight;
    int boxWeight;
    ArrayList<T> listParcelsInBox;

    public ParcelBox(int maxWeight) {
        this.maxBoxWeight = maxWeight;
        this.boxWeight = 0;
        listParcelsInBox = new ArrayList<>();
    }

    public void addParcel(T parcel) {
        if (parcel.weight + boxWeight <= maxBoxWeight) {
            listParcelsInBox.add(parcel);
            boxWeight += parcel.weight;
        } else {
            System.out.println("Максимально допустимый вес коробки превышен");
        }
    }

    ArrayList<T> getAllParcels() {
        return listParcelsInBox;
    }

    public int getBoxWeight() {
        return boxWeight;
    }

    public int getListParcelsCountInBox() {
        return listParcelsInBox.size();
    }
}
