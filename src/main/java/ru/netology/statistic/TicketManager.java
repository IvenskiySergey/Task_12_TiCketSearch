package ru.netology.statistic;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public void deleteById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Блет с id " + id + " не найден");
        }
        repository.removeById(id);
    }

    public Ticket findById(int id) {
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tickets = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tickets[i] = result[i];
                }
                tickets[tickets.length - 1] = ticket;
                result = tickets;
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getArrivalAir().contains(to)) {
            if (ticket.getDepartureAir().contains(from)) {
                return true;
            }
        }
        return false;
    }
}
