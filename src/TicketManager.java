import java.util.*;
import java.util.Scanner;

public class TicketManager {

    Scanner insert = new Scanner(System.in);

    List<Ticket> ticketList = new ArrayList<>();

    int elements = 0;


    public void add(){
        Ticket ticket = new Ticket();
        ticket.setId();
        ticket.setName();
        ticket.setPrice();
        ticket.setType();
        ticket.setPerson();
        ticketList.add(ticket);
        elements++;
    }
    public void PersonSorter(){
        Collections.sort(ticketList, new personComparator());
        for(Ticket ticket : ticketList)
        {
            System.out.println(ticket.showPerson());
        }

    }
    public void showInfo(){
        System.out.println("Тип - ArrayList" );
        System.out.println("Количество элементов " + elements);
    }

    public void showList(){
        System.out.print(ticketList);

    }
    public void clearList()
    {
        ticketList.clear();
    }
    public void removeFirst(){
        System.out.print(ticketList.get(0));
        ticketList.remove(0);
        elements--;
    }
    public void removeAtIndex(){
        System.out.print("Введите индекс для удаления (начиная с 0 ) : ");
        int index = insert.nextInt();
        System.out.print(ticketList.get(index));
        ticketList.remove(index);
        elements--;

    }
    public void removeById() {
        System.out.print("Введите id билета для удаления: ");
        long id;
        try {
            Scanner scanner = null;
            id = Long.parseLong(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный формат id.");
            return;
        }

        boolean removed = false;
        for (Ticket ticket : ticketList) {
            if (ticket.getId() == id) {
                ticketList.remove(ticket);
                System.out.println("Билет с id " + id + " удален.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Билет с id " + id + " не найден.");
        }
        
    }
    public Ticket updateById(){
        System.out.print("Введите id элемента, чтобы обновить его : ");
        long id = insert.nextInt();
        for(Ticket ticket : ticketList)        {
            if (ticket.getId() == id) {
                System.out.print("Введите новое имя билета: ");
                String name = insert.nextLine().trim();
                if (!name.isEmpty()) {
                    ticket.setName();
                }

                System.out.print("Введите новую цену билета: ");
                String priceStr = insert.nextLine().trim();
                if (!priceStr.isEmpty()) {
                    try {
                        int price = Integer.parseInt(priceStr);
                        if (price > 0) {
                            ticket.setPrice();
                        } else {
                            System.out.println("Цена билета должна быть больше нуля.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Некорректный формат цены билета.");
                    }
                }

                System.out.print("Введите новый тип билета (VIP, USUAL, BUDGETARY, CHEAP): ");
                String typeStr = insert.nextLine().trim();
                if (!typeStr.isEmpty()) {
                    try {
                        TicketType type = TicketType.valueOf(typeStr.toUpperCase());
                        ticket.setType();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Некорректный тип билета.");
                    }
                }

                System.out.print("Введите новый номер паспорта: ");
                String passportID = insert.nextLine().trim();
                if (!passportID.isEmpty() && passportID.length() >= 4) {
                    ticket.getPerson().toString();
                } else {
                    System.out.println("Номер паспорта должен содержать не менее 4 символов.");
                }

                System.out.println("Билет с id " + id + " обновлен.");

                break;
            }
        }
        return null;
    }

    public Ticket listSortType() {
        System.out.print("Введите минимальное значение качества : ");
        TicketType current;

        do {
            String ins = insert.nextLine();
            switch (ins) {
                case "VIP":
                    current = TicketType.VIP;
                    break;
                case "BUDGETARY":
                    current = TicketType.BUDGETARY;
                    break;
                case "CHEAP":
                    current = TicketType.CHEAP;
                    break;
                case "USUAL":
                    current = TicketType.USUAL;
                    break;
                default:
                    System.out.print("Выбериет тип из списка : ");
                    continue;
            }
            break;
        } while (true);
            if(current == TicketType.VIP)
            {
                for(Ticket ticket : ticketList)
                {
                    if (ticket.getType() == TicketType.VIP)
                        System.out.print(ticket);
                }
            }
            else if(current == TicketType.BUDGETARY)
            {
                for(Ticket ticket : ticketList)
                {
                    if (ticket.getType() == TicketType.BUDGETARY || ticket.getType() == TicketType.VIP)
                        System.out.print(ticket);
                }
            }
            else if(current == TicketType.CHEAP)
            {
                for(Ticket ticket : ticketList)
                {
                    if (ticket.getType() == TicketType.CHEAP || ticket.getType() == TicketType.BUDGETARY || ticket.getType() == TicketType.VIP)
                        System.out.print(ticket);
                }
            }
            else
            {
                System.out.print(ticketList);
            }
            return null;
    }
    public static class personComparator implements Comparator<Ticket>{
        @Override
        public int compare(Ticket o1, Ticket o2) {
            return o1.getPerson().compareTo(o2.getPerson());
        }
    }

}
