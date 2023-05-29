/*******#task1***********/
import java.io.FileInputStream;
import java.io.IOException;

public class HexDumpProgram {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a file name as an argument.");
            return;
        }

        String fileName = args[0];
        printHexDump(fileName);
    }

    public static void printHexDump(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            int offset = 0;
            int bytesRead;
            byte[] buffer = new byte[16];

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                StringBuilder hexBuilder = new StringBuilder();
                StringBuilder asciiBuilder = new StringBuilder();

                for (int i = 0; i < bytesRead; i++) {
                    int value = buffer[i] & 0xFF;
                    String hexString = Integer.toHexString(value).toUpperCase();

                    if (hexString.length() < 2) {
                        hexBuilder.append("0");
                    }

                    hexBuilder.append(hexString).append(" ");
                    asciiBuilder.append((char) ((value >= 32 && value <= 126) ? value : '.'));
                }

                System.out.printf("%08X: %-48s %s%n", offset, hexBuilder.toString(), asciiBuilder.toString());
                offset += bytesRead;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
java HexDumpProgram <file_name>


/***********task2*****/


import java.io.*;

public class DataRecoveryProgram {

    public static void main(String[] args) {
        String dumpFile = "dumpfile.bin";
        String outputDirectory = "recovered_files";
        
        // Create the output directory if it doesn't exist
        File directory = new File(outputDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }

        try (FileInputStream fileInputStream = new FileInputStream(dumpFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                // Check for PDF file signature
                if (checkFileSignature(buffer, new byte[]{0x25, 0x50, 0x44, 0x46})) {
                    String fileName = generateUniqueFileName(outputDirectory, "recovered_pdf", ".pdf");
                    saveToFile(buffer, bytesRead, fileName);
                    System.out.println("Recovered PDF file: " + fileName);
                }
                // Check for PNG file signature
                else if (checkFileSignature(buffer, new byte[]{(byte) 0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A})) {
                    String fileName = generateUniqueFileName(outputDirectory, "recovered_png", ".png");
                    saveToFile(buffer, bytesRead, fileName);
                    System.out.println("Recovered PNG file: " + fileName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkFileSignature(byte[] buffer, byte[] signature) {
        if (buffer.length < signature.length) {
            return false;
        }
        for (int i = 0; i < signature.length; i++) {
            if (buffer[i] != signature[i]) {
                return false;
            }
        }
        return true;
    }

    private static void saveToFile(byte[] buffer, int bytesRead, String fileName) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }
    }

    private static String generateUniqueFileName(String directory, String baseName, String extension) {
        String fileName = baseName + extension;
        File file = new File(directory, fileName);
        int count = 1;
        while (file.exists()) {
            fileName = baseName + "_" + count + extension;
            file = new File(directory, fileName);
            count++;
        }
        return file.getAbsolutePath();
    }
}
