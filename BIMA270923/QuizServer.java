/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BIMA270923;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author Lenovo
 */
public class QuizServer {
    private static final int PORT = 12345;
    private static final List<QuizQuestion> questions = new ArrayList<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        initializeQuestionsAndAnswers();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String clientMessage = in.readLine();

                    if ("permintaan".equalsIgnoreCase(clientMessage)) {
                        String randomQuestion = getRandomQuestion();
                        out.println(randomQuestion);
                    } else if ("jawaban".equalsIgnoreCase(clientMessage)) {
                        String clientAnswer = in.readLine();
                        handleClientAnswer(clientAnswer, out);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initializeQuestionsAndAnswers() {
        questions.add(new QuizQuestion("Siapa pembuat Java?", "James Gosling"));
        // Add more questions and answers here
    }

    private static String getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());
        QuizQuestion randomQuiz = questions.get(randomIndex);
        return randomQuiz.getQuestion();
    }

    private static void handleClientAnswer(String clientAnswer, PrintWriter out) {
        // Implementation for handling client answers
        // (similar to the previous code)
    }
}
