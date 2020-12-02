package com.infoshare.drinkywinky.menu;

import com.infoshare.drinkywinky.repositories.Repository;
import com.infoshare.drinkywinky.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static com.infoshare.drinkywinky.menu.Menu.wrongNumber;

public class SearchMenu {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    SearchMenu() {
    }

    public static void secondMenu() {
        int mainExitCode = 0;

        while (mainExitCode != 4) {

            STDOUT.info("┌──────────────────────────────────────────┐\n");
            STDOUT.info("│  \u001b[101m      CHOOSE OPTION FROM MENU       \u001b[0m    │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│   1. Search for a drink by name          │\n");
            STDOUT.info("│   2. Search for a drink by ingredient    │\n");
            STDOUT.info("│   3. Search for a drink by category      │\n");
            STDOUT.info("│                                          │\n");
            STDOUT.info("│  \u001b[36m 4. TO MAIN MENU                   \u001b[0m     │\n");
            STDOUT.info("└──────────────────────────────────────────┘\n");
            STDOUT.info("\n");
            STDOUT.info("CHOOSE NUMBER: ");

            switch (ChoiceMenu.choiceMenu()) {
                case 1:
                    STDOUT.info(" CHOSEN : 1. Search for a drink by name  \n");
                    new SubmenuCreator(Utils.getNamesOfAllDrink(Repository.getInstance().getDrinkList()));
                    break;
                case 2:
                    STDOUT.info(" CHOSEN : 2. Search for a drink by ingredient  \n");
                    new SubmenuCreator(new ArrayList<>(Utils.getNamesOfAllIngredients(Repository.getInstance().getDrinkList())));
                    break;
                case 3:
                    STDOUT.info(" CHOSEN : 3. Search for a drink by category  \n");
                    new SubmenuCreator(new ArrayList<>(Utils.getCategoryOfAllDrink(Repository.getInstance().getDrinkList())));
                    break;
                case 4:
                    STDOUT.info(" Welcome to main menu \n");
                    Menu.mainMenu();

                    mainExitCode = 4;
                    break;
                default:
                    wrongNumber();
                    break;
            }
        }
    }
}