package io.consolechat;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;
    private List<String> phrases;
    private boolean stop = false;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        this.phrases = readPhrases();
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        String question = "";
        String answer = "";
        List<String> log = new ArrayList<>();

        System.out.println("Chat is started");
        while (!question.equals(OUT)) {
            question = in.nextLine();
            if (question.equals(CONTINUE)) {
                stop = false;
            } else if (question.equals(STOP)) {
                stop = true;
            }
            answer = stop ? "" : getRandomAnswer();
            System.out.println(answer);
            log.add(question + System.lineSeparator() + answer);
        }
        saveLog(log);
    }

    private String getRandomAnswer() {
        return phrases.get((int) (Math.random() * phrases.size()));
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines()
                    .forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("./data/chat_log.txt", "./data/chat_answers.txt");
        List<String> phrases = consoleChat.readPhrases();
        consoleChat.run();
    }
}