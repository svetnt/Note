package mediaNotes.autentification;

import mediaNotes.context.UserContext;

import java.util.Scanner;

public class Authentification {

    private final static String LOGIN = "svetnt";
    private final static String PASSWORD = "123";

    public void autentificate() {

        Scanner sc = new Scanner(System.in);

        int maxCount = 3;
        boolean isAuthentificationSuccess = false;

        for (maxCount = 3; maxCount > 0 && !isAuthentificationSuccess; maxCount--) {

            System.out.println("Login: ");
            var login = sc.nextLine();

            System.out.println("Password: ");
            var password = sc.nextLine();

            if(validate(login,password)){
               isAuthentificationSuccess=true;
                UserContext.setUserLogin(login);
            } else {
                System.out.println("Password is incorrect. Please try again. ");
            }
        }
        if (!isAuthentificationSuccess){
            throw new RuntimeException("Login failed");
        }
    }

    public boolean validate(String login, String password) {
        return login.equals(LOGIN) && password.equals(PASSWORD);
    }
}
