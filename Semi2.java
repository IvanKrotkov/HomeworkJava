import java.io.*;
import java.nio.file.Files;



public class Semi2 {
    public static void main(String[] args) throws IOException {
        String[] data = fileReading();
        int[] values = searchDig(data);
        int res = exponentiation(values[0],values[1]);
        writingResult(res);
    }
    static int exponentiation(int a, int b){
        if(b==0) return 1;
        return a*exponentiation(a,b-1);
    }
    static String[] fileReading() throws IOException {
        File file = new File("C:/Users/krotk/OneDrive/Рабочий стол/HomeworkJava/Homework_GB/src/input.txt");
        String[] fileReading = Files.readAllLines(file.toPath()).toArray(new String[0]);
        return fileReading;
    }

    static int[] searchDig(String[] arr){
        int[] digital = new int[2];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            String[] arrayStr = arr[i].split(" ");
            digital[count] = Integer.parseInt(arrayStr[1]);
            count+=1;
        }
        return digital;
    }
    static void writingResult (int res)throws IOException{
        FileWriter file = new FileWriter("output.txt",false);
        file.write(String.format("результат - %d",res));
        file.flush();
    }
}
