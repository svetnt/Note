import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

      int code= Authentification.autentificate();
        System.out.println(code==0? "Login success":"Error");


    }

}
