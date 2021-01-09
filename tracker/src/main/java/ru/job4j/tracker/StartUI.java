package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int i = 0; i < actions.length; i++) {
            out.println(i + ". " + actions[i].name());
        }
        out.println("");
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
//            int[] range = new int[actions.length];
//            for (int i = 0; i < actions.length; i++) {
//                range[i] = i;
//            }
            int select = input.ask("Select menu item: ", actions);
//            if (select < 0 || select >= actions.length) {
//                out.println("Wrong input, you can select: 0..." + (actions.length - 1));
//                out.println("");
//                continue;
//            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
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
        new StartUI(output).init(input, tracker, actions);
    }
}
