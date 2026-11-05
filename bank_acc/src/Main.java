import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("ACC001", "Aida", 50000);
        BankAccount account2 = new BankAccount("ACC002", "Dana", 10000);

        TransferService transferService = new TransferService();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму перевода: ");
        String input = scanner.nextLine();

        try {
            double amount = Double.parseDouble(input);
            transferService.transfer(account1, account2, amount);
        } catch (NumberFormatException ex) {
            System.out.println("Ошибка ввода числа");
        } catch (IllegalArgumentException ex) {
            System.out.println("Некорректная сумма");
        } catch (InsufficientFundsException ex) {
            System.out.println("Недостаточно средств");
        } finally {
            System.out.println("Операция перевода завершена");
        }

        // Вывод итоговых балансов обоих счетов после операции
        System.out.println("Баланс " + account1.getOwner() + " (" + account1.getAccountNumber() + "): " + account1.getBalance());
        System.out.println("Баланс " + account2.getOwner() + " (" + account2.getAccountNumber() + "): " + account2.getBalance());
    }
}