package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerishableParcelTest {

    @Test
    public void testIsExpired_NotExpired () {
        PerishableParcel perishableParcel = new PerishableParcel("Молоко", 1, "Адрес", 5, 3);
        assertFalse(perishableParcel.isExpired(7));
    }

    @Test
    public void testIsExpired_ExpiredOnDay () {
        PerishableParcel perishableParcel = new PerishableParcel("Молоко", 1, "Адрес", 5, 3);
        assertTrue(perishableParcel.isExpired(8));
    }

    @Test
    public void testIsExpired_ExpiredDay() {
        PerishableParcel perishableParcel = new PerishableParcel("Молоко", 1, "Адрес", 5, 3);
        assertTrue(perishableParcel.isExpired(9));
    }

    @Test
    public void testIsExpired_ExpiredBeforeSend() {
        PerishableParcel perishableParcel = new PerishableParcel("Молоко", 1, "Адрес", 5, 0);
        assertTrue(perishableParcel.isExpired(5));
    }

}