import java.io.*;

public class Problem1 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("studentInfo.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            FileWriter writer = new FileWriter("studentName.txt");
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String studentName = parts[0];
                writer.write(lineNumber + ": " + studentName + "\n");
                lineNumber++;
            }
            writer.close();
            File studentNameFile = new File("studentName.txt");
            long length = studentNameFile.length();
            long lastModified = studentNameFile.lastModified();
            System.out.println("studentName.txt文件的长度为：" + length + " bytes");
            System.out.println("studentName.txt文件的修改时间为：" + lastModified);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
