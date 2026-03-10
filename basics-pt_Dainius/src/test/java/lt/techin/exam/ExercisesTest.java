package lt.techin.exam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ExercisesTest extends BaseIOTest{


    @Test
    @DisplayName("isTriangleValid")
    void isTriangleValidTest() {
        assertTrue(Exercises.isTriangleValid(2, 3, 4));
        assertFalse(Exercises.isTriangleValid(7, 2, 3));
        assertFalse(Exercises.isTriangleValid(3, 2, 7));
    }




    static Stream<Arguments> args_printOddNumbers() {
        return Stream.of(
                Arguments.of(8, "7\n5\n3\n1\n"),
                Arguments.of(11, "11\n9\n7\n5\n3\n1\n"),
                Arguments.of(1, "1\n")


        );
    }


    @ParameterizedTest(name = "number: {0} ")
    @MethodSource("args_printOddNumbers")
    @DisplayName("printOddNumbers")
    void printOddNumbersTest(int number, String expected) {

        Exercises.printOddNumbers(number);
        assertEquals(expected, updateLineSpliterators(outContent.toString()));
    }












    static Stream<Arguments> args_countLargerThanNumber() {
        return Stream.of(
                Arguments.of(new int[]{1, 20, 30,  5}, 10, 2),
                Arguments.of(new int[]{100, 20, 30,  5, 60}, 15, 4),
                Arguments.of(new int[]{1, 2, 3,  }, 5, 0)


        );
    }


    @ParameterizedTest(name = "countLargerThanNumber")
    @MethodSource("args_countLargerThanNumber")
    @DisplayName("countLargerThanNumber")
    void multiplyBy2Test(int[] arr, int number,  int expected) {

        int result = Exercises.countLargerThanNumber(arr, number);
        assertEquals(result, expected);

    }






    static Stream<Arguments> args_findSmallest() {
        return Stream.of(
                Arguments.of(new ArrayList<Double>(List.of(6.7, 3.5, 1.2)), 1.2),
                Arguments.of(new ArrayList<Double>(List.of(1.1, 3.5, 1.7, 2.4)), 1.1),
                Arguments.of(new ArrayList<Double>(List.of( 1.3)), 1.3)


        );
    }


    @ParameterizedTest(name = "findSmallest")
    @MethodSource("args_findSmallest")
    @DisplayName("findSmallest")
    void findSmallestTest(ArrayList<Double> words, double expected) {

        double result = Exercises.findSmallest(words);
        assertEquals(result, expected, 0.001);
    }





    static Stream<Arguments> args_countStringsContainingWord() {
        return Stream.of(
                Arguments.of(new ArrayList<String>(List.of("aaa", "Bbb", "AcC")), "a", 2),
                Arguments.of(new ArrayList<String>(List.of("Qaa", "Bbb", "WcC")), "bb", 1),
                Arguments.of(new ArrayList<String>(List.of("aaa")),"b", 0)


        );
    }


    @ParameterizedTest(name = "countStringsContainingWord")
    @MethodSource("args_countStringsContainingWord")
    @DisplayName("countStringsContainingWord")
    void countWordsStartingWithATest(ArrayList<String> words,String word, int expected) {

        int result = Exercises.countStringsContainingWord(words, word);
        assertEquals(result, expected);
    }

    @Test
    @DisplayName("generateRandomEmail")
    void generateRandomEmail() {
        String email = Exercises.generateRandomEmail();
        assertNotNull(email, "Generated email should not be null");
        assertTrue(isValidEmail(email), "Generated email should be in valid format");
        Set<String> generatedEmails = new HashSet<>();
        final int numberOfEmailsToTest = 100;

        for (int i = 0; i < numberOfEmailsToTest; i++) {
            generatedEmails.add(Exercises.generateRandomEmail());
        }

        assertEquals(numberOfEmailsToTest, generatedEmails.size(), "Generated emails should be unique");



    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }



}
