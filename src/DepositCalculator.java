import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double depositAmount, double depositRate, int depositPeriod) {
        double payment = depositAmount * Math.pow((1 + depositRate / 12), 12 * depositPeriod);
        return roundUpDeposit(payment, 2);
    }

    double calculateSimplePercent(double depositAmount, double depositRate, int depositPeriod) {
        return roundUpDeposit(depositAmount + depositAmount * depositRate * depositPeriod, 2);
    }

    double roundUpDeposit(double value, int degree) {
        double scale = Math.pow(10, degree);
        return Math.round(value * scale) / scale;
    }

    void makeCalculation() {
        int depositPeriod;
        int depositType;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = userInput.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = userInput.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = userInput.nextInt();
        double depositResult = 0;
        if (depositType == 1) {
            depositResult = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            depositResult = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + depositResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().makeCalculation();
    }

}
