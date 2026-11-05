public class TransferService {

    public void transfer(
            BankAccount from,
            BankAccount to,
            double amount) throws InsufficientFundsException {

        // 1. Проверяем, что оба счёта существуют
        if (from == null || to == null) {
            throw new IllegalArgumentException("Оба счёта должны существовать");
        }

        // 2. Убеждаемся, что отправитель и получатель — разные счета
        if (from == to || from.getAccountNumber().equals(to.getAccountNumber())) {
            throw new IllegalArgumentException("Счёт отправителя и получателя не должны совпадать");
        }

        // 3. Проверяем корректность суммы перевода
        if (amount <= 0) {
            throw new IllegalArgumentException("Некорректная сумма");
        }

        // 4. Списываем деньги со счёта отправителя
        from.withdraw(amount);

        // 5. Зачисляем деньги получателю
        to.deposit(amount);

        // 6. Выводим сообщение об успешном переводе
        System.out.println("Успешный перевод: " + amount + " тг со счёта "
                + from.getOwner() + " на счёт " + to.getOwner());
    }
}