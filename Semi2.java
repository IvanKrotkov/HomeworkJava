import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Semi2 {
    public static void main(String[] args) throws IOException {
        int res = exponentiation(4,4);
        fileReading();

    }
    static int exponentiation(int a, int b){
        if(b==0) return 1;
        return a*exponentiation(a,b-1);
    }
    static String[] fileReading() throws IOException {
        Path file = Path.of("C:/Users/krotk/OneDrive/Рабочий стол/HomeworkJava/Homework_GB/src/input.txt");
        String[] fileArray = Files.readAllLines(file).toArray(new String[0]);
//        System.out.println(Arrays.toString(fileArray));
        return  fileArray;
    }


}
