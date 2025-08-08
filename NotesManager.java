package Task4;

import java.io.*;
import java.util.Scanner;

public class NotesManager {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String filePath = "C:/Users/kunal/OneDrive/Documents/intelljProperties.Resume.txt";
            while (true) {
                System.out.println(" Notes Manager ");
                System.out.println("1. Write a new note");
                System.out.println("2. Read all notes");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter your note: ");
                        String note = scanner.nextLine();
                        writeNote(filePath, note);
                        break;

                    case 2:
                        readNotes(filePath);
                        break;

                    case 3:
                        System.out.println("exiting");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            }
        }


        private static void writeNote(String filePath, String note) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
                writer.write(note);
                writer.newLine();
                System.out.println("Note saved successfully ");
            } catch (IOException e) {
                System.out.println("Error writing note: " + e.getMessage());
            }
        }


        private static void readNotes(String filePath) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                System.out.println(" Your Notes");
                boolean hasNotes = false;
                while ((line = reader.readLine()) != null) {
                    System.out.println(": " + line);
                    hasNotes = true;
                }
                if (!hasNotes) {
                    System.out.println("(No notes found)");
                }
            } catch (FileNotFoundException e) {
                System.out.println("(No notes found yet. Start writing)");
            } catch (IOException e) {
                System.out.println("Error reading notes: " + e.getMessage());
            }
        }
    }



