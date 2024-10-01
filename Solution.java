import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'decryptPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String decryptPassword(String s) {
        char[] chars = s.toCharArray();
        StringBuilder password = new StringBuilder();
        int indexOfFirstChar = 0;
        for (int i = s.length() - 1; i>0; i--){
            if (chars[i] == '0'){
                chars[i] = chars[indexOfFirstChar];
                chars[indexOfFirstChar] = '\0';
                indexOfFirstChar++;
            } else if (chars[i] == '*'){
                chars[i] = chars[i-2];
                chars[i-2] = '\0';
                i--;
            }
        }
        for (char ch : chars){
            if (ch != '\0')
                password.append(ch);
        }
        return password.toString();

    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.decryptPassword(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
