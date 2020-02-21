package duke.commands;

import duke.storage.Storage;
import duke.task.Deadline;
import duke.task.TaskList;
import duke.ui.Ui;
import static duke.common.Messages.ADD_MESSAGE;

public class AddDeadlineCommand extends Command {

    private static String description;
    private static String by;
    public static String COMMAND_PHRASE = "deadline (item) /by (date or time)";
    public static String COMMAND_USAGE = COMMAND_PHRASE + System.lineSeparator() +
            "-Adds a deadline to the list";

    public AddDeadlineCommand(String description, String by) {
        super();
        this.description = description;
        this.by = by;
    }

    @Override
    public CommandResult execute(TaskList tasks, Ui textUi, Storage storage) {
        Deadline newDeadline = new Deadline(description,by);
        String feedback = ADD_MESSAGE + System.lineSeparator()
                + newDeadline.toString() + System.lineSeparator() + "Now you have " + (tasks.getSize()+1) + " tasks in the list";
        tasks.add(newDeadline);
        storage.writeDeadline(textUi,description,by);
        return new CommandResult(feedback);
    }

}