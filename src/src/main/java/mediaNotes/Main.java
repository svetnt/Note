package mediaNotes;

import mediaNotes.autentification.Authentification;
import mediaNotes.command.CommandReader;

public class Main {
    public static void main(String[] args) {

        Authentification authentification=new Authentification();
        authentification.autentificate();

        CommandReader.startReading();
    }
}
