import java.util.Scanner;

public class Oblicz {
    Scanner scanner = new Scanner(System.in);

    void menu() {
        int mainChoice = 0;
        while(mainChoice != 4) {
            System.out.println("Wybierz odpowiednią opcję: \n1.Oblicz NWD\n2.Oblicz NWW\n3.Przedstawienie liczby jako iloczyn liczb pierwszych\n4.Exit\n");
            int choice = scanner.nextInt();
            if(choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                System.out.println("Podaj numer dostępny w menu!\n");
            } else if (choice == 1) {
                System.out.println("Podaj pierwszą liczbę");
                int pierwsza = scanner.nextInt();
                System.out.println("Podaj drugą liczbę");
                int druga = scanner.nextInt();
                System.out.println("Twój wynik to : " + nwd(pierwsza, druga) + "\n");
            } else if (choice == 2) {
                System.out.println("Podaj pierwszą liczbę");
                int pierwsza = scanner.nextInt();
                System.out.println("Podaj drugą liczbę");
                int druga = scanner.nextInt();
                System.out.println("Twój wynik to : " + nww(pierwsza, druga) + "\n");
            } else if (choice == 3) {
                System.out.println("Podaj liczbę, którą chcesz przedstawić jako iloczyn liczb pierwszych:");
                int liczba = scanner.nextInt();
                System.out.println("Podaj największą liczbę pierwszą, która ma być użyta w ciągu:");
                int maxLiczbaPierwsza = scanner.nextInt();
                przedstawJakoIloczynLiczbPierwszych(liczba, maxLiczbaPierwsza);
            }
            mainChoice = choice;
        }
    }

    int nwd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return nwd(b, a % b);
        }
    }

    int nww(int a, int b) {
        int iloczyn = a * b;
        return iloczyn / nwd(a, b);
    }

    boolean czyPierwsza(int liczba) {
        if (liczba <= 1) return false;
        for (int i = 2; i <= Math.sqrt(liczba); i++) {
            if (liczba % i == 0) return false;
        }
        return true;
    }

    void przedstawJakoIloczynLiczbPierwszych(int liczba, int maxLiczbaPierwsza) {
        System.out.print("Iloczyn liczb pierwszych dla liczby " + liczba + " to: ");
        for (int i = 2; i <= Math.min(liczba, maxLiczbaPierwsza); i++) {
            while (czyPierwsza(i) && liczba % i == 0) {
                System.out.print(i);
                liczba /= i;
                if (liczba != 1) {
                    System.out.print(" * ");
                }
            }
        }
        if (liczba > maxLiczbaPierwsza) {
            System.out.print(" * " + liczba);
        }
        System.out.println();
    }
}
