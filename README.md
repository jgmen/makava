Makava
======

A tiny Java-based build system inspired by Makefile. Define tasks with @Task and chain dependencies using a fluent CommandLine API.

> [!WARNING]
> The library is not in production ready state yet

Project structure:
- Main.java          # Main tasks
- CommandLine.java   # Builds commands
- TaskRegistry.java  # Registers tasks
- RegisteredTask.java# Task representation
- TaskRunner.java    # Runs tasks respecting dependencies
- main.c             # C program to compile

main.c example:
#include <stdio.h>

int main() {
    printf("Hello World!\n");
    return 0;
}

Tasks in Java:

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
        .append("echo Success");
}

How to run:
1. Compile Java classes:
   javac *.java

2. Run build:
   java Main

- Tasks execute in dependency order.
- Command output is printed to the console.
