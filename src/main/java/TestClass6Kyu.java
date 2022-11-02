import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass6Kyu {

    //    --------------------------------------------------------------------------------------------------------------
 /*20.05.2022
Define a function that takes an integer argument and returns a logical value true or
false depending on if the integer is a prime.

Per Wikipedia, a prime number ( or a prime )
is a natural number greater than 1 that has no positive divisors other than 1 and itself.

Requirements
You can assume you will be given an integer input.
You can not assume that the integer will be only positive. You may be given negative numbers as well ( or 0 ).
NOTE on performance: There are no fancy optimizations required,
but still the most trivial solutions might time out. Numbers go up to 2^31 ( or similar, depending on language ).
Looping all the way up to n, or n/2, will be too slow.
Example
is_prime(1)   false
is_prime(2)   true
is_prime(-1)  false
*/
    public static boolean isPrime(int num) {
        if (num <= 0) {
            return false;
        }
        BigInteger bigInt = BigInteger.valueOf(num);
        return bigInt.isProbablePrime(100);
    }

    //    --------------------------------------------------------------------------------------------------------------
/* 25.05.2022
In this kata you are given a string for example:
"example(unwanted thing)example"
Your task is to remove everything inside the parentheses as well as the parentheses themselves.
The example above would return:
"exampleexample"
Notes
Other than parentheses only letters and spaces can occur in the string. Don't worry about other brackets like "[]" and "{}" as these will never appear.
There can be multiple parentheses.
The parentheses can be nested.
*/
    public static String removeParentheses(final String str) {
        String result = str;
        while (result.contains("(")) {
            result = result.replaceAll("\\([^()]*\\)", "");
        }
        return result;
    }

    /*
    Place all people in alphabetical order where Mothers are followed by their children, i.e. "aAbaBb" => "AaaBbb".
    */
    public static String findChildren(final String text) {
        String[] splText = text.split("");
        Arrays.sort(splText);
        Collections.sort(Arrays.asList(splText), String.CASE_INSENSITIVE_ORDER);
        String result = "";
        for (int i = 0; i < splText.length; i++) {
            result += splText[i];
        }
        return result;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*06.07.2022
You get an array of arrays.
If you sort the arrays by their length, you will see, that their length-values are consecutive.
But one array is missing!
You have to write a method, that return the length of the missing array.
Example:
[[1, 2], [4, 5, 1, 1], [1], [5, 6, 7, 8, 9]] --> 3
If the array of arrays is null/nil or empty, the method should return 0.
When an array in the array is null or empty, the method should return 0 too!
There will always be a missing element and its length will be always between the given arrays.
Have fun coding it and please don't forget to vote and rank this kata! :-)
I have created other katas. Have a look if you like coding and challenges.
 */
    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        List<Object[]> lengthArrayOfArrays = Arrays.asList(arrayOfArrays);
        List<Integer> lengthOfEachArr = lengthArrayOfArrays.stream().map(arr -> arr.length).sorted().collect(Collectors.toList());

        int result = 0;
        int shift = lengthOfEachArr.get(0);
        for (int i = 0; i < lengthOfEachArr.size(); i++) {
            if (lengthOfEachArr.get(i) != i + shift) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    //    --------------------------------------------------------------------------------------------------------------
    /*12.07.2022
Count the number of days between two dates:

Examples:

There are 5021 days between 1987.1.16 and 2000.10.15

Good Luck!
     */
    public static long getDaysAlive(int year, int month, int day, int year2, int month2, int day2) {

        LocalDate startDate = LocalDate.of(year, month, day);
        LocalDate endDate = LocalDate.of(year2, month2, day2);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return daysBetween;

    }
    //    --------------------------------------------------------------------------------------------------------------

    //    --------------------------------------------------------------------------------------------------------------
    //    --------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {

//        assertEquals(3, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 1, 2 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
//        assertEquals(2, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 5, 2, 9 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
//        assertEquals(2, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { null }, new Object[] { null, null, null } } ));
//        assertEquals(5, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 'a', 'a', 'a' }, new Object[] { 'a', 'a' }, new Object[] { 'a', 'a', 'a', 'a' }, new Object[] { 'a' }, new Object[] { 'a', 'a', 'a', 'a', 'a', 'a' }} ));
//        assertEquals(0, Kata.getLengthOfMissingArray(new Object[][] { }));


//        System.out.println(isPrime(73));
//        -------------------------------------------------------------------------------------------
//        System.out.println(removeParentheses("example(unwanted thing)example"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(findChildren("aAbaBb"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(
//                getLengthOfMissingArray(
//                        new Object[][]{
//                                new Object[]{1, 2},
//                                new Object[]{4, 5, 1, 1},
//                                new Object[]{1},
//                                new Object[]{5, 6, 7, 8, 9}}
//
//                        new Object[][] {
//                                new Object[] { 5, 2, 9 },
//                                new Object[] { 4, 5, 1, 1 },
//                                new Object[] { 1 },
//                                new Object[] { 5, 6, 7, 8, 9 }}

//                        new Object[][] {
//                                new Object[] { null },
//                                new Object[] { null, null, null } }

//                        new Object[][] {
//                                new Object[] { 'a', 'a', 'a' },
//                                new Object[] { 'a', 'a' },
//                                new Object[] { 'a', 'a', 'a', 'a' },
//                                new Object[] { 'a' },
//                                new Object[] { 'a', 'a', 'a', 'a', 'a', 'a' }}

//                        new Object[][]{}

//                        new Object[][] {
//                                new Object[] { 0, 4, 4, 3, 4, 1 },
//                                new Object[] { 4, 4, 2, 4, 3, 4, 3 },
//                                new Object[] { 4, 0, 2, 0, 4 },
//                                new Object[] { 1, 2, 3 }}
//                )
//        );
//        -------------------------------------------------------------------------------------------
//        System.out.println(getDaysAlive(1987, 1, 16, 2000, 10, 15));
//        -------------------------------------------------------------------------------------------
//        -------------------------------------------------------------------------------------------
//        -------------------------------------------------------------------------------------------
//        -------------------------------------------------------------------------------------------
    }

//    @Test
//    public void BasicTests() {
//        assertEquals(3, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 1, 2 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
//        assertEquals(2, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 5, 2, 9 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
//        assertEquals(2, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { null }, new Object[] { null, null, null } } ));
//        assertEquals(5, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 'a', 'a', 'a' }, new Object[] { 'a', 'a' }, new Object[] { 'a', 'a', 'a', 'a' }, new Object[] { 'a' }, new Object[] { 'a', 'a', 'a', 'a', 'a', 'a' }} ));
//
//        assertEquals(0, Kata.getLengthOfMissingArray(new Object[][] { }));
//        assertEquals(5, Kata.getLengthOfMissingArray(new Object[][] { new Object[] {2, 4, 1 }, new Object[] { 0, 1, 4, 1}, new Object[] {4, 3, 1, 0, 0, 0 }} ));
//        assertEquals(5, Kata.getLengthOfMissingArray(new Object[][] { new Object[] {4, 4, 0 }, new Object[] { }, new Object[] {1}} ));

//    }


}
