import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class RegisteredTask {
    final String name;
    final List<String> depends;
    final Method method;
    final CommandLine cmd;

    public RegisteredTask(String name, String[] depends, Method method, CommandLine cmd) {
        this.name = name;
        this.depends = Arrays.asList(depends);
        this.method = method;
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', depends=" + depends + '}';
    }

    CommandLine getCmd() {
        return cmd;
    }
}