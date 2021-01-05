package ru.job4j.tracker;

public class StartUI {

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            System.out.printf("%d. %s%n",  i, actions[i].name());
        }
        System.out.println();
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select menu item: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ShowAllItems(output),
                new CreateItem(output),
                new EditItem(output),
                new DeleteItem(output),
                new FindById(output),
                new FindByName(output),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
