import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TaskRegistry {
    static final Map<String, RegisteredTask> tasks = new HashMap<>();
    
    public static void registerTasks(Class<?> clazz) {
        for (Method method: clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Task.class)) {
                Task annotation = method.getAnnotation(Task.class);
                String name = annotation.name().isEmpty() ? method.getName() : annotation.name();

                try {
                    CommandLine cmd = (CommandLine) method.invoke(null);

                    if (cmd == null) {
                        throw new IllegalStateException("CommandLine returned null from " + method.getName());
                    }

                    RegisteredTask t = new RegisteredTask(name, annotation.depends(), method, cmd);
                    tasks.put(name, t);
                } catch(Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static RegisteredTask getTask(String name) {
        return tasks.get(name);
    }

    public static Map<String, RegisteredTask> getAllTasks() {
        return tasks;
    }
}
 