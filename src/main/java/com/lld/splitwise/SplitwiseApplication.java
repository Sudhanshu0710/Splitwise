package com.lld.splitwise;

import com.lld.splitwise.commands.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

    private Scanner scanner;

    private CommandRegistry commandRegistry;

    @Autowired
    public SplitwiseApplication(CommandRegistry commandRegistry) {
        scanner = new Scanner(System.in);
        this.commandRegistry = commandRegistry;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Tell me what you want to do?");
            String input = scanner.nextLine();
            commandRegistry.execute(input);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

}
