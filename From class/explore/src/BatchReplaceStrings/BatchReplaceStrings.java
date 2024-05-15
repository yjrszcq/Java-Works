package BatchReplaceStrings;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class BatchReplaceStrings {

    private static String[] sentence = new String[100000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());
        System.out.println("This program is used to batch replace strings in files.\n");
        System.out.println("Please place the program in the folder where the files to be operated are stored.\n");
        System.out.println("Please input the suffix of the file (No need to include '.'): ");
        String suffix = scanner.nextLine();
        System.out.println("Please input the number of subWords: ");
        int subWordsNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.println("Please input the subWords and the newWords (Separate with spaces or line breaks): ");
        String[] subWords = new String[subWordsNum];
        String[] newWords = new String[subWordsNum];
        for (int i = 0; i < subWordsNum; i++) {
            subWords[i] = scanner.next();
            newWords[i] = scanner.next();
        }
        replacement(subWords, newWords, subWordsNum, suffix);
    }

    private static void getAllFiles(String path, List<String> files, String fileType) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path), "*" + fileType)) {
            for (Path entry : stream) {
                files.add(entry.getFileName().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void replacement(String[] subWords, String[] newWords, int subWordsNum, String suffix) {
        Arrays.fill(sentence, null);
        String filePath = "replaced";
        try {
            Files.createDirectories(Paths.get(filePath));
        } catch (FileAlreadyExistsException e) {
            System.out.println("The directory already exists.");
        } catch (IOException e) {
            System.out.println("ERROR: Failed to create directory.");
            return;
        }

        try (PrintWriter logFile = new PrintWriter(filePath + "/log.txt", StandardCharsets.UTF_8.name())) {
            String path = System.getProperty("user.dir");
            List<String> temp = new ArrayList<>();
            getAllFiles(path, temp, "." + suffix);
            for (String fileName : temp) {
                try (BufferedReader fin = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    int n = 0;
                    while ((line = fin.readLine()) != null) {
                        sentence[n] = line;
                        n++;
                    }
                } catch (FileNotFoundException e) {
                    System.err.println("ERROR: '" + fileName + "' not found.");
                    continue;
                } catch (IOException e) {
                    System.err.println("ERROR: '" + fileName + "' not found.");
                    continue;
                }
                processFile(subWords, newWords, subWordsNum, filePath, logFile, fileName);
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void processFile(String[] subWords, String[] newWords, int subWordsNum, String filePath, PrintWriter logFile, String fileName) {
        int n = 0;
        for (; n < sentence.length; n++) {
            if (sentence[n] == null) {
                break;
            }
        }

        boolean[] judFile = new boolean[1];
        int[][] judWs = new int[subWordsNum][n];
        for (int j = 0; j < subWordsNum; j++) {
            for (int k = 0; k < n; k++) {
                judWs[j][k] = 0;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < subWordsNum; k++) {
                int index = sentence[j].indexOf(subWords[k]);
                if (index != -1) {
                    if (judFile[0] == false) {
                        logFile.println("File: " + fileName + " -> ");
                        judFile[0] = true;
                    }
                    judWs[k][j] = 1;
                    sentence[j] = sentence[j].replace(subWords[k], newWords[k]);
                }
            }
        }

        String newFileName = filePath + "/" + fileName;
        try (PrintWriter fout = new PrintWriter(newFileName, StandardCharsets.UTF_8.name())) {
            for (int j = 0; j < n; j++) {
                fout.println(sentence[j]);
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        for (int j = 0; j < subWordsNum; j++) {
            boolean judWords = false;
            logFile.print("\tWords " + ": (" + subWords[j] + " -> " + newWords[j] + ") in lines:");
            for (int k = 0; k < n; k++) {
                if (judWs[j][k] == 1) {
                    judWords = true;
                    logFile.print(" " + (k + 1));
                }
            }
            if (!judWords) {
                logFile.print(" No words replaced.");
            }
            logFile.println();
        }
        logFile.println();
        System.out.println("File '" + fileName + "' has been replaced successfully.");
    }
}
