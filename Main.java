import java.util.Map;

public class Main {
    static String CC = "gcc";
    static String PROGRAM = "main";

    @Task
    public static CommandLine build() {
        return CommandLine.task() 
            .append(CC, PROGRAM + ".c") 
            .append("-Wall", "-Wextra", "-O0", "-g") 
            .append("-o", PROGRAM);
    }

    @Task(depends = {"build"})
    public static CommandLine hello() {
        return CommandLine.task()
            .append("echo Sucess");
    }

    public static void main(String[] args) {
        Map<String, RegisteredTask> tasks;

        TaskRegistry.registerTasks(Main.class);
        tasks = TaskRegistry.getAllTasks();

        TaskRunner.runTasks(tasks);
    }
}

