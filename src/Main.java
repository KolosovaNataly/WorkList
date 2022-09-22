import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int count = 0;
        while (true) {
            System.out.println("Выберите операцию:");
            if (count == 0) {
                System.out.println("1. Добавить товар в список" + "\n" +
                        "2. Показать список покупок" + "\n" +
                        "3. Убрать позицию из списка" + "\n" +
                        "4. Найти товар");
                count++;
            }
            String input = scanner.nextLine();
            if (input.equals("1")) {
                add(list);
            } else if (input.equals("2")) {
                show(list);
            } else if (input.equals("3")) {
                delete(list);
            } else if (input.equals("4")) {
                find(list);
            } else if (input.equals("end")) {
                return;
            } else {
                System.out.println("Нет такой операции");
            }
        }
    }
    public static void add(List<String> list) {
        System.out.println("Какую покупку хотите добавить?");
        list.add(scanner.nextLine());
        System.out.println("Итого в списке покупок: " + list.size());
    }

    public static void show(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public static void delete(List<String> list) {
        show(list);
        int a = 0;
        System.out.println("Какую хотите удалить? Введите номер или название:");
        String input = scanner.nextLine();
        try {
            a = Integer.parseInt(input);
            list.remove(a - 1);
        } catch (NumberFormatException e) {
        }
        for (int i = 0; i < list.size(); i++) {
            if (input.equals(list.get(i))) {
                list.remove(i);
            }
        }
        show(list);
    }

    public static void find(List<String> list) {
        List<String> clone = list;
        String input = scanner.nextLine();
        input = input.toLowerCase();
        for (int i = 0; i < list.size(); i++) {
            String copy = list.get(i).toLowerCase();
            if (copy.contains(input)) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}

