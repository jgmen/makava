import java.util.Map;

public class TaskRunner {

    public static void runTask(RegisteredTask task) {
        CommandLine cmd = task.getCmd();

        String[] cmdArray = cmd.toString().split(" ");
        ProcessBuilder pb = new ProcessBuilder(cmdArray);

        pb.redirectErrorStream(true);
        pb.inheritIO();

        Process process; 
        try {
            process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void runTasks(Map<String, RegisteredTask> tasks) {
        for (Map.Entry<String, RegisteredTask> task : tasks.entrySet()) {
            RegisteredTask currenTask = task.getValue();
            runTask(currenTask);
        }
    }
}
