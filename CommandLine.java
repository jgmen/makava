class CommandLine {
    private StringBuffer buffer = new StringBuffer();

    public CommandLine append(String...args) {
        for (String arg : args) {
            buffer.append(arg).append(" ");
        }
        return this;
    }

    public static CommandLine task() {
        return new CommandLine();
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
