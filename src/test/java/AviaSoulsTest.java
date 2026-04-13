
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.AviaSouls;
import ru.netology.Ticket;
import ru.netology.TicketTimeComparator;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Тамбов", "Липецк", 1_000, 11, 12);
    Ticket ticket2 = new Ticket("Тамбов", "Воронеж", 2_000, 9, 11);
    Ticket ticket3 = new Ticket("Тамбов", "Рязань", 5_000, 12, 16);
    Ticket ticket4 = new Ticket("Тамбов", "Пенза", 4_000, 13, 16);
    Ticket ticket5 = new Ticket("Тамбов", "Воронеж", 5_000, 9, 13);

    @Test
    public void compareToLongFlight() {
        int expected = 1;
        int actual = ticket5.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToShortFlight() {
        int expected = -1;
        int actual = ticket4.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToTestSameDuration() {
        int expected = 0;
        int actual = ticket5.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchCost() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        Ticket[] expected = {ticket2, ticket5};
        Ticket[] actual = tickets.search("Тамбов", "Воронеж");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchNaming() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        Ticket[] expected = {ticket3};
        Ticket[] actual = tickets.search("Тамбов", "Рязань");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void searchAndSortBy() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] expected = {ticket2, ticket5};
        Ticket[] actual = tickets.searchAndSortBy("Тамбов", "Воронеж", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByNull() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = tickets.searchAndSortBy("Тамбов", "Москва", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }


}