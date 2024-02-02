import java.util.*;

class PhoneBook{
    private HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    /**
    * Запись в телефонную книгу
    *
    * @param name имя контакта
    * @param phoneNumber телефоный номер
     */
    public void addPhoneContact(String name, Integer phoneNumber){
        if (phoneBook.containsKey(name)){
            phoneBook.get(name).add(phoneNumber);
        }
        else{
            phoneBook.put(name, new ArrayList<>());
            phoneBook.get(name).add(phoneNumber);
        }
    }

    /**
     * Звонок контакту (получаем 1 номер тел.)
     * @param contact имя контакта
     * */
    public Integer callContact(String contact){
        System.out.println("У "+contact +" следующие номера телефонов: ");
        System.out.println(phoneBook.get(contact));
        System.out.println("Выберите номер телефона: ");
        Scanner scanner = new Scanner(System.in);
        int numPhoneNum = Integer.parseInt(scanner.nextLine());
        if (numPhoneNum < phoneBook.get(contact).size())
            return phoneBook.get(contact).get(numPhoneNum - 1);
        else{
            System.out.println("Такого номера нет!!");
            return 0;
        }
    }

    /**
     * Получаем все номера телефонов
     * @param contact имя контакта у которого хотим получить номера
     * */
    public ArrayList<Integer> getPhoneNumbers(String contact){
        return phoneBook.get(contact);
    }

    /**
    * Получаем список всех контактов
    * */
    public Set<String> getAllContactName(){
        return phoneBook.keySet();
    }

    private LinkedList<String> sortPhoneBook(){
        ArrayList<Integer> tempSize = new ArrayList<>();
        LinkedList<String> sortNameLiss = new LinkedList<>();

        for(String name : phoneBook.keySet()){
            tempSize.add(phoneBook.get(name).size());
        }

        Collections.sort(tempSize);
        Collections.reverse(tempSize);

        for(Integer numSize : tempSize){
            for(String name : phoneBook.keySet()){
                if(phoneBook.get(name).size() == numSize){
                    sortNameLiss.add(name);
                }
            }
        }
        return sortNameLiss;
    }

    /**
     * Вывод отвортированной тел. книги используя метод printAllPhoneBook
     * */
    public void printAllPhoneBook(){
        for(String name : sortPhoneBook()){
            System.out.println(name + " " + phoneBook.get(name));
        }
    }
}


public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook1 = new PhoneBook();
        phoneBook1.addPhoneContact("contact", 111);
        phoneBook1.addPhoneContact("contact", 222);
        phoneBook1.addPhoneContact("contact1", 3333);
        phoneBook1.addPhoneContact("contact1", 44444);
        phoneBook1.addPhoneContact("contact1", 5555);
        phoneBook1.addPhoneContact("contact1", 66666);
        phoneBook1.addPhoneContact("contact3", 7777);
        phoneBook1.addPhoneContact("contact3", 8888);
        phoneBook1.addPhoneContact("contact3", 9999);

        System.out.println(phoneBook1.getPhoneNumbers("contact1"));
        System.out.println(phoneBook1.getAllContactName());
        phoneBook1.printAllPhoneBook();

        phoneBook1.callContact("contact3");
    }
}