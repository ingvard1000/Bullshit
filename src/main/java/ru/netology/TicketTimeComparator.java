package ru.netology;
import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {

        int a = t1.getTimeTo() - t1.getTimeFrom();
        int b = t2.getTimeTo() - t2.getTimeFrom();
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        } else {
            return 0;
        }
    }

}
