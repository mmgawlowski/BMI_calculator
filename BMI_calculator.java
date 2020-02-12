import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BMI_calculator {
    static String BMI_comment(double BMI) {
        if (0 < BMI && BMI < 16) {
            return "wygłodzenie";
        } else if (16 <= BMI && BMI <= 16.99) {
            return "wychudzenie";
        } else if (17 <= BMI && BMI <= 18.49) {
            return "niedowagę";
        } else if (18.5 <= BMI && BMI <= 24.99) {
            return "prawidłową wagę";
        } else if (25 <= BMI && BMI <= 29.99) {
            return "nadwagę";
        } else if (30 <= BMI && BMI <= 34.99) {
            return "I stopień otyłości";
        } else if (35 <= BMI && BMI <= 39.99) {
            return "II stopień Motyłości (otyłość kliniczna)";
        } else if (BMI >= 40.00) {
            return "III stopień otyłości (otyłość skrajna)";
        } else {
            return "wartość nieprawidłowa";
        }
    }

    static void BMI_calculation() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Jak masz na imię?");
        String my_name = myObj.nextLine();

        System.out.println("Witaj " + my_name + ". Jaki jest Twój wzrost w m (np. 1.62)?");
        String my_height = myObj.nextLine();

        while (true) {
            if (my_height.contains(",")) {
                System.out.println("Podaj wzrost używając \".\"");
                my_height = myObj.nextLine();
            }
            try {
                Double.parseDouble(my_height);
            } catch (Exception e) {
                System.out.println("Nieprawidłowa wartość. Podaj swój prawidłowy wzrost w m.");
                my_height = myObj.nextLine();
                continue;
            }
            if (0 >= Double.parseDouble(my_height) || 3 < Double.parseDouble(my_height)) {
                System.out.println("Nieprawidłowa wartość. Podaj swój prawidłowy wzrost w m.");
                my_height = myObj.nextLine();
            } else {
                break;
            }
        }

        System.out.println("Dobrze, jaka jest Twoja waga w kg?");
        String my_weight = myObj.nextLine();

        while (true) {
            if (my_weight.contains(",")) {
                System.out.println("Podaj wagę używając \".\"");
                my_weight = myObj.nextLine();
                continue;
            }
            try {
                Double.parseDouble(my_weight);
            } catch (Exception e) {
                System.out.println("Nieprawidłowa wartość. Podaj swoją prawidłową wagę w kg.");
                my_weight = myObj.nextLine();
                continue;
            }
            if (0 >= Double.parseDouble(my_weight)) {
                System.out.println("Nieprawidłowa wartość. Podaj swój prawidłowy wzrost w m.");
                my_weight = myObj.nextLine();
            } else {
                break;
            }
        }

        double BMI = Double.parseDouble(my_weight) / Math.pow(Double.parseDouble(my_height), 2);
        double BMI_1 = BigDecimal.valueOf(BMI)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        System.out.println("Twoje BMI wynosi: " + BMI_1);
        System.out.println("Twoje BMI wskazuje na " + BMI_comment(BMI_1));
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        while (true) {
            String[] yes_array = {"tak", "t"};
            String[] no_array = {"nie", "n"};
            List<String> yes_list = Arrays.asList(yes_array);
            List<String> no_list = Arrays.asList(no_array);

            System.out.println("Czy chcesz rozpocząć nową kalkulację? (t/n)");
            String restart = myObj.nextLine().toLowerCase();

            if (yes_list.contains(restart)) {
                BMI_calculation();
            } else if (no_list.contains(restart)) {
                break;
            } else {
                System.out.println("Wybierz t lub n");
                continue;
            }
        }
        System.exit(0);
    }
}