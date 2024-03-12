import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);
        TicketManager ticketManager = new TicketManager();
        System.out.println("Команда help выведит доступный список команд!");
        while(true)
        {
            String vvod = insert.nextLine();
            if(vvod.contains("exit"))
                break;
            else if (vvod.contains("help"))
            {
                System.out.print("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                        "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                        "add : добавить новый элемент в коллекцию\n" +
                        "update {id} : обновить значение элемента коллекции, id которого равен заданному\n" +
                        "remove_by_id {id} : удалить элемент из коллекции по его id\n" +
                        "clear : очистить коллекцию\n" +
                        "exit : завершить программу (без сохранения в файл)\n" +
                        "remove_at {index} : удалить элемент, находящийся в заданной позиции коллекции (index)\n" +
                        "remove_first : удалить первый элемент из коллекции\n" +
                        "filter_greater_than_type {type} : вывести элементы, значение поля type которых больше заданного\n" +
                        "print_field_descending_person : вывести значения поля person всех элементов в порядке убывания (сравнивать методом compareTo, по какому полю/полям сравнивать - решать вам)\n");
            }
            else if (vvod.contains("show"))
            {
                ticketManager.showList();
            }
            else if (vvod.contains("add"))
            {
                ticketManager.add();
            }
            else if(vvod.contains("info"))
            {
                ticketManager.showInfo();
            }
            else if (vvod.contains("update"))
            {
                ticketManager.updateById();
            }
            else if (vvod.contains("remove_by_id"))
            {
                ticketManager.removeById();
            }
            else if (vvod.contains("clear"))
            {
                ticketManager.clearList();
            }
            else if (vvod.contains("remove_at"))
            {
                ticketManager.removeAtIndex();
            }
            else if (vvod.contains("remove_first"))
            {
                ticketManager.removeFirst();
            }
            else if (vvod.contains("filter_greater_than_type"))
            {
                ticketManager.listSortType();
            }
            else if (vvod.contains("print_field_descending_person"))
            {
                ticketManager.PersonSorter();
            }
            while (!vvod.equals("exit"));
            insert.close();
        }
    }
}
