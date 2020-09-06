import java.util.Scanner;

public class Roulette {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int chips = 100;

        String[] color = { "rot", "schwarz" };
        int[] one_third = new int[36];
        int[] nums = new int[36];

        int COLOR_FACTOR = 2;
        int DRITTEL_FACTOR = 3;
        int NUMBER_FACTOR = 36;

        while (chips > 0) {

            System.out.println("------------------------------------------");
            System.out.println("Verfügbare Chips: " + chips);
            System.out.println("------------------------------------------");

            System.out.println("(f) FARBE\n(d) DRITTEL\n(z) ZAHL\n(b) Beenden");
            System.out.print(": ");
            char cin = sc.nextLine().charAt(0);
            if (cin == 'b' || cin == 'B')
                break;
            System.out.print("Setzen: ");
            String s = sc.nextLine();
            int amount = Integer.parseInt(s);

            if (amount > 0 && amount <= chips) {

                switch (cin) {

                    case 'f':
                        System.out.print("Rot (r)\tSchwarz (s) : ");
                        char colin = sc.nextLine().charAt(0);

                        String randFarbe = color[(int) (Math.random() * color.length)];

                        if (colin == 'r') {
                            if (colin == randFarbe.charAt(0)) {
                                System.out.println("Du hast rot gewählt und es ist " + randFarbe + " gezogen worden.");
                                chips += (amount * COLOR_FACTOR);
                            } else {
                                System.out.println("Du hast rot gewählt und es ist " + randFarbe + " gezogen worden.");
                                chips -= amount;
                            }
                        } else if (colin == 's') {
                            if (colin == randFarbe.charAt(0)) {
                                System.out.println("Du hast schwarz gewählt und es ist " + randFarbe + " gezogen worden.");
                                chips += (amount * 2);
                            } else {
                                System.out.println("Du hast schwarz gewählt und es ist " + randFarbe + " gezogen worden.");
                                chips -= amount;
                            }
                        } else {
                            System.err.println("Falsche Eingabe!");
                        }
                        break;

                    case 'd':
                        System.out.println("Drittel [1-12]");
                        System.out.println("Drittel [13-24]");
                        System.out.println("Drittel [25-36]");
                        System.out.print("Zahl: ");
                        String userThirdIn = sc.nextLine();

                        int userDrittel = Integer.parseInt(userThirdIn);
                        int randDrittel = (int) (Math.random() * one_third.length) + 1;

                        System.out.println("Und es wird gedreht...");
                        Thread.sleep(2000);
                        System.out.println("Die Zahl ist die ... " + randDrittel);

                        if (userDrittel >= 1 && userDrittel <= 12) {
                            System.out.println(
                                    "Du hast " + userDrittel + " gewählt und bist damit innerhalb des 1. Drittels");
                            if (userDrittel == randDrittel) {
                                chips += (amount * DRITTEL_FACTOR);
                            } else {
                                System.out.println("Die Zahl war die " + randDrittel);
                                chips -= amount;
                            }
                        } else if (userDrittel > 12 && userDrittel <= 24) {
                            System.out.println(
                                    "Du hast " + userDrittel + " gewählt und bist damit innerhalb des 2. Drittels");
                            if (userDrittel == randDrittel) {
                                chips += (amount * DRITTEL_FACTOR);
                            } else {
                                System.out.println("Die Zahl war die " + randDrittel);
                                chips -= amount;
                            }
                        } else if (userDrittel > 24 && userDrittel <= 36) {
                            System.out.println(
                                    "Du hast " + userDrittel + " gewählt und bist damit innerhalb des 3. Drittels");
                            if (userDrittel == randDrittel) {
                                chips += (amount * DRITTEL_FACTOR);
                            } else {
                                System.out.println("Die Zahl war die " + randDrittel);
                                chips -= amount;
                            }
                        }
                        break;

                    case 'z':
                        System.out.print("Zahl [0-36] : ");
                        String userNumIn = sc.nextLine();

                        int userNum = Integer.parseInt(userNumIn);
                        int randNum = (int) (Math.random() * nums.length);

                        if (userNum == randNum) {
                            System.out
                                    .println("Du hast " + userNum + " gewählt und es ist " + randNum + " gezogen worden.");
                            chips += (amount * NUMBER_FACTOR);
                        } else {
                            System.out
                                    .println("Du hast " + userNum + " gewählt und es ist " + randNum + " gezogen worden.");
                            chips -= amount;
                        }
                        break;

                    default:
                        System.err.println("Falsche Eingabe!");
                }
            } else {
                System.err.println("Nicht genug Chips!");
            }
        }

        System.out.println("\nDas Spiel ist aus. Du bist pleite!");

        sc.close();
    }

}
