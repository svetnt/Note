import java.util.Scanner;

public class Authentification {

    private final static String LOGIN = "svetnt";
    private final static String PASSWORD = "123";

    public static int autentificate() {

        Scanner sc = new Scanner(System.in);

        int maxCount = 3;
        boolean isLoginSuccess = false;

        for (maxCount = 3; maxCount > 0 && !isLoginSuccess; maxCount--) {

            System.out.println("Login: ");
            var login = sc.nextLine();

            System.out.println("Password: ");
            var password = sc.nextLine();

            if (login.equals(LOGIN) && password.equals(PASSWORD)) {
               isLoginSuccess=true;

            }
        }
        return isLoginSuccess? 0:1;
    }
}
