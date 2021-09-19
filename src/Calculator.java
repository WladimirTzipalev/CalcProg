import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) {
        try {
            System.out.println("Введите данные в одну строку через пробел, пример ввода: 1 + 2.");
            System.out.println("Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами.");
            System.out.println("Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.");
            System.out.println("Вводимые числа должны быть от 1 до 10, или от I до X включительно:");

            BufferedReader brReader = new BufferedReader(new InputStreamReader(System.in));
            String str = brReader.readLine();

            MathOperation arithmetic = new MathOperation();
            String result = arithmetic.result(str);
            System.out.println(result);

        }
        catch (Exceptions | IOException e) {

        }


    }
}

