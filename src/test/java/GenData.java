import java.io.FileWriter;
import java.io.IOException;

public class GenData {
    public static void main(String[] args) {
        // Records per file
        int recordsPerFile = 5000;
        // Number of files
        int numberOfFiles = 6;

        try {
            for (int fileIndex = 1; fileIndex <= numberOfFiles; fileIndex++) {
                // Name of file
                String filePath = "data_" + fileIndex + ".txt";

                try (FileWriter writer = new FileWriter(filePath)) {
                    // Title of column
                    writer.append("Username,Email,Phone\n");

                    // Tính khoảng số thứ tự bắt đầu và kết thúc cho file hiện tại
                    int startNumber = (fileIndex - 1) * recordsPerFile + 3;
                    int endNumber = startNumber + recordsPerFile;

                    // Insert data for rows
                    for (int i = startNumber; i < endNumber; i++) {
                        String username = "abc" + i;
                        String email = username + "@yopmail.com";
                        String phone = "0998765432";
                        writer.append(username).append(",").append(email).append(",").append(phone).append("\n");
                    }

                    System.out.println("Txt file generated successfully: " + filePath);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}