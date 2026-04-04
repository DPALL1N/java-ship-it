package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostTest {
    @Test
    public void testStandardParcelCost() {
        StandardParcel parcel = new StandardParcel("Тест", 3, "Адрес", 1);
        int cost = parcel.calculateDeliveryCost();
        assertEquals(15, cost);
    }

    @Test
    public void testStandardParcelZeroWeight() {
        StandardParcel parcel = new StandardParcel("Тест", 0, "Адрес", 1);
        int cost = parcel.calculateDeliveryCost();
        assertEquals(0, cost);
    }

    @Test
    public void testFragileParcelCost() {
        FragileParcel fragileParcel = new FragileParcel("Тест" , 4, "Адрес", 2);
        int cost = fragileParcel.calculateDeliveryCost();
        assertEquals(12, cost);
    }

    @Test
    public void testFragileParcelZeroWeight() {
        FragileParcel fragileParcel = new FragileParcel("Тест" , 0, "Адрес", 2);
        int cost = fragileParcel.calculateDeliveryCost();
        assertEquals(0, cost);
    }

    @Test
    public void testPerishableParcelCost() {
        PerishableParcel perishableParcel = new PerishableParcel("Тест", 2, "Адрес", 3, 2);
        int cost = perishableParcel.calculateDeliveryCost();
        assertEquals(8, cost);
    }

    @Test
    public void testPerishableParcelZeroWeight() {
        PerishableParcel perishableParcel = new PerishableParcel("Тест", 0, "Адрес", 3, 2);
        int cost = perishableParcel.calculateDeliveryCost();
        assertEquals(0, cost);
    }
}
