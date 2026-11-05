public class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner, double balance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Номер счёта не может быть пустым");
        }
        if (owner == null || owner.isBlank()) {
            throw new IllegalArgumentException("Имя владельца не может быть пустым");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.accountNumber = accountNumber.trim();
        this.owner = owner.trim();
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    // Пополнение счёта (Часть 1)
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Некорректная сумма: пополнение возможно только на положительную сумму");
        }
        balance += amount;
    }

    // Снятие средств со счёта (Часть 2)
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Некорректная сумма: сумма снятия должна быть больше нуля");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств на счёте " + accountNumber);
        }
        balance -= amount;
    }
}