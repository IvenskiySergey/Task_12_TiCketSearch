package ru.netology.statistic;

public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        Ticket[] newTickets = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, newTickets, 0, tickets.length);
        newTickets[newTickets.length - 1] = ticket;
        tickets = newTickets;
    }

    public Ticket[] showAll() {
        return tickets;
    }

    public void removeById(int id) {
        Ticket[] newTickets = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                newTickets[index] = ticket;
                index++;
            }
        }
        tickets = newTickets;
    }
}
