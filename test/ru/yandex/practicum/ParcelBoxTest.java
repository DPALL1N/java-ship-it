package ru.yandex.practicum;
import ru.yandex.practicum.delivery.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelBoxTest {

    @Test
    public void testAddParcel_Success() {
        ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(10);
        StandardParcel standardParcel = new StandardParcel("тест", 5, "адрес",
                1);

        standardParcelBox.addParcel(standardParcel);

        assertEquals(1, standardParcelBox.getListParcelsCountInBox());
        assertEquals(5, standardParcelBox.getBoxWeight());
    }

    @Test
    public void testAddParcel_NotAdd() {
        ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(10);
        FragileParcel fragileParcel = new FragileParcel("тест", 11, "адрес",
                1);

        fragileParcelBox.addParcel(fragileParcel);
        assertEquals(0, fragileParcelBox.getListParcelsCountInBox());
        assertEquals(0, fragileParcelBox.getBoxWeight());

    }

    @Test
    public void testAddParcel_Limit() {
        ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(10);
        PerishableParcel perishableParcel = new PerishableParcel("тест", 10, "адрес",
                1, 3);

        perishableParcelBox.addParcel(perishableParcel);
        assertEquals(1, perishableParcelBox.getListParcelsCountInBox());
        assertEquals(10, perishableParcelBox.getBoxWeight());

    }

}