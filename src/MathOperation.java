import java.util.Arrays;
import java.util.List;

public class MathOperation {
    private int num1; //переменная 1 для вычисления
    private int num2; //переменная 2 для вычисления
    private String operator; //математический оператор

    //простые математические операции
    public int calcExp(int num1, String operator, int num2) {
        int res;
        switch (operator) {
            case "+":
                res = num1 + num2;
                break;
            case "-":
                res = num1 - num2;
                break;
            case "*":
                res = num1 * num2;
                break;
            case "/":
                res = num1 / num2;
                break;
            default:
                throw new AssertionError();
        }

        return res;
    }

    public String result(String exp) throws Exceptions {
        boolean isRomanExp; //Определяем, что введены Римские числа
        Convert convert = new Convert();

        //Используем разделитель " ".
        List<String> expItems = Arrays.asList(exp.split(" "));

        //Проверяем, что в выражении не больше трех чисел
        if (expItems.size() != 3) {
            throw new Exceptions("Ошибка! Введенное выражение должно соответствовать виду \"Число Оператор Число\" (пробелы обязательны)");
        }

        //Проверяем, что математический оператор из списка + - * /
        if (convert.checkOperator(expItems.get(1))) {
            operator = expItems.get(1);
        } else {
            throw new Exceptions("Ошибка! Математический оператор должен быть из списка: + - * /");
        }

        //Проверяем, что оба числа Арабские, либо оба числа Римские
        if (convert.isNumeric(expItems.get(0)) && convert.isNumeric(expItems.get(2))) {
            num1 = Integer.parseInt(expItems.get(0));
            num2 = Integer.parseInt(expItems.get(2));
            isRomanExp = false;
        } else if (convert.isRoman(expItems.get(0)) && convert.isRoman(expItems.get(2))) {
            num1 = convert.romeToArabConvert(expItems.get(0));
            num2 = convert.romeToArabConvert(expItems.get(2));
            isRomanExp = true;
        } else {
            throw new Exceptions("Ошибка! Используются одновременно разные системы счисления.");
        }

        //Проверяем, что введенные числа от 1 до 10 включительно
        if (!(num1 >= 1 && num1 <= 10)) {
            throw new Exceptions("Ошибка! Первое число должно быть от 1 до 10 включительно.");
        }
        if (!(num2 >= 1 && num2 <= 10)) {
            throw new Exceptions("Ошибка! Второе число должно быть от 1 до 10 включительно.");
        }

        //Получаем результат
        int res = calcExp(num1, operator, num2);

        //Конвертируем числа в Римские и возвращаем результат вычисления. Если результат отрицательное число, возвращаем Ошибку.
        if (isRomanExp) {
            if (res > 0) {
                return convert.arabToRomeConvert(Math.abs(res));
            } else {
                throw new Exceptions("Ошибка! В римской системе нет отрицательных чисел.");
            }

        }
        return String.valueOf(res);
    }
}
