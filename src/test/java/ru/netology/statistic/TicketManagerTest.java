package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketManagerTest {

    Ticket ticket = new Ticket(568921, 5000, "DME", "LIN", 300);
    Ticket ticket1 = new Ticket(568922, 6000, "LIN", "DME", 350);
    Ticket ticket2 = new Ticket(568923, 4000, "DME", "LIN", 290);
    Ticket ticket3 = new Ticket(568924, 15000, "DME", "MAD", 400);
    Ticket ticket4 = new Ticket(568925, 25000, "MAD", "LIN", 450);
    Ticket ticket5 = new Ticket(568926, 5500, "MAD", "DME", 500);
    Ticket ticket6 = new Ticket(568927, 7000, "DME", "LIN", 320);
    Ticket ticket7 = new Ticket(568928, 3000, "DME", "MXP", 280);
    Ticket ticket8 = new Ticket(568929, 8000, "MXP", "LIN", 300);
    Ticket ticket9 = new Ticket(568930, 6500, "MXP", "DME", 310);
    Ticket ticket10 = new Ticket(568931, 9500, "MXP", "LIN", 360);

    @Test
    public void showAllTest() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        manager.add(ticket);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = repository.showAll();
        Ticket[] expected = {ticket, ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteByIdTest() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        manager.add(ticket);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        manager.deleteById(568924);
        manager.deleteById(568927);
        manager.deleteById(568930);

        Ticket[] actual = repository.showAll();
        Ticket[] expected = {ticket, ticket1, ticket2, ticket4, ticket5, ticket7, ticket8, ticket10};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void notFoundExceptionTest() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        manager.add(ticket);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        manager.deleteById(568924);

        assertThrows(NotFoundException.class, () -> {
            manager.deleteById(568924);
        });
    }

    @Test
    public void findAllTest() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);

        manager.add(ticket);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.findAll("DME", "LIN");
        Ticket[] expected = {ticket2, ticket, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }
}
