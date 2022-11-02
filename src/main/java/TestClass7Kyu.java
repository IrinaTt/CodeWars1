import com.sun.jdi.Value;

import java.util.*;
import java.util.function.IntUnaryOperator;
import java.util.logging.SocketHandler;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestClass7Kyu {

    /*24.01.2022
    Given two integers a and b, which can be positive or negative,
    find the sum of all the integers between and including them and return it. If the two numbers are equal return a or b.
    Note: a and b are not ordered!
    Examples (a, b) --> output (explanation)
    (1, 0) --> 1 (1 + 0 = 1)
    (1, 2) --> 3 (1 + 2 = 3)
    (0, 1) --> 1 (0 + 1 = 1)
    (1, 1) --> 1 (1 since both are same)
    (-1, 0) --> -1 (-1 + 0 = -1)
    (-1, 2) --> 2 (-1 + 0 + 1 + 2 = 2)
     */
    public static int getSum(int a, int b) {
        int sum = 0;
        if (a == b) {
            return a;
        }
        if (a < b) {
            for (int i = a; i <= b; i++) {
                sum += i;
            }
        }
        if (b < a) {
            for (int i = b; i <= a; i++) {
                sum += i;
            }
        }
        return sum;
    }

    /*
    Usually when you buy something, you're asked whether your credit card number,
    phone number or answer to your most secret question is still correct.
    However, since someone could look over your shoulder, you don't want that shown on your screen. Instead, we mask it.

    Your task is to write a function maskify, which changes all but the last four characters into '#'.

    Examples
    Maskify.Maskify("4556364607935616"); // should return "############5616"
    Maskify.Maskify("64607935616");      // should return "#######5616"
    Maskify.Maskify("1");                // should return "1"
    Maskify.Maskify("");                 // should return ""

    // "What was the name of your first pet?"
    Maskify.Maskify("Skippy");                                   // should return "##ippy"
    Maskify.Maskify("Nanananananananananananananana Batman!"); // should return "##################################man!"
     */
    public static String maskify(String str) {
        String[] splStr = str.split("");
        String result = "";

        if (str.length() == 0 || str.length() <= 4) {
            return str;
        } else {
            for (int i = 0; i < str.length() - 4; i++) {
                splStr[i] = "#";
                result += "#";
            }
            result = result + str.substring(str.length() - 4);
        }
        return result;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*25.01.2022
An anagram is the result of rearranging the letters of a word to produce a new word (see wikipedia).

Note: anagrams are case insensitive

Complete the function to return true if the two arguments given are anagrams of each other; return false otherwise.

Examples
"foefet" is an anagram of "toffee"

"Buckethead" is an anagram of "DeathCubeK"
 */
    public static boolean isAnagram(String test, String original) {
        String[] splTest = test.split("");
        String[] splOrigin = original.split("");

        if (test.length() == original.length()) {
            for (int i = 0; i < test.length(); i++) {
                if (original.toLowerCase().contains(splTest[i].toLowerCase())) {
                    return true;
                }
                if (test.toLowerCase().contains(splOrigin[i].toLowerCase())) {
                    return false;
                }
            }
        }
        return false;
    }
    //    --------------------------------------------------------------------------------------------------------------
/*27.01.2022
Take 2 strings s1 and s2 including only letters from ato z. Return a new sorted string, the longest possible,
containing distinct letters - each taken only once - coming from s1 or s2.

Examples:
a = "xyaabbbccccdefww"
b = "xxxxyyyyabklmopq"
longest(a, b) -> "abcdefklmopqwxy"

a = "abcdefghijklmnopqrstuvwxyz"
longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
 */

    public static String longest(String s1, String s2) {
        String[] splS1 = s1.split("");
        String[] splS2 = s2.split("");

        Collection<String> s1AsList = Arrays.asList(splS1);
        Collection<String> s2AsList = Arrays.asList(splS2);

        List<String> both = new ArrayList<>();
        both.addAll(s1AsList);
        both.addAll(s2AsList);

        List<String> bothSortedDistinctArr = both.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return String.join("", bothSortedDistinctArr);
    }

    /*28.01.2022   ------NEED TO BE RESOLVED, DONT UNDERSTAND THE TASK
    You are given two arrays a1 and a2 of strings. Each string is composed with letters from a to z.
    Let x be any string in the first array and y be any string in the second array.

    Find max(abs(length(x) − length(y)))

    If a1 and/or a2 are empty return -1 in each language except in Haskell (F#) where you will return Nothing (None).

    Example:
    a1 = ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"]
    a2 = ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"]
    mxdiflg(a1, a2) --> 13
    Bash note:
    input : 2 strings with substrings separated by ,
    output: number as a string
    */
    public static int mxdiflg(String[] a1, String[] a2) {
        String a1Result = "";
        String a2Result = "";
        for (int i = 0; i < a1.length; i++) {
            a1Result += a1[i];
        }
        for (int i = 0; i < a2.length; i++) {
            a2Result += a2[i];
        }

        System.out.println(a1Result);
        System.out.println(a2Result);

        return a1.length + a2.length;
    }

/*
In this Kata, you will be given a string that may have mixed uppercase and lowercase letters
and your task is to convert that string to either lowercase only or uppercase only based on:

make as few changes as possible.
if the string contains equal number of uppercase and lowercase letters, convert the string to lowercase.
For example:

solve("coDe") = "code". Lowercase characters > uppercase. Change only the "D" to lowercase.
solve("CODe") = "CODE". Uppercase characters > lowecase. Change only the "e" to uppercase.
solve("coDE") = "code". Upper == lowercase. Change all to lowercase.
More examples in test cases. Good luck!
*/

    public static String solve(final String str) {
        String lower = "";
        String upper = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str.toUpperCase().charAt(i)) {
                upper += str.charAt(i);
            } else {
                lower += str.charAt(i);
            }
        }

        if (upper.length() > lower.length()) {
            return str.toUpperCase();
        } else {
            return str.toLowerCase();
        }
    }

/*
In this Kata, your function receives an array of integers as input.
Your task is to determine whether the numbers are in ascending order.
An array is said to be in ascending order if there are no two adjacent integers
where the left integer exceeds the right integer in value.

For the purposes of this Kata, you may assume that all inputs are valid, i.e. non-empty arrays containing only integers.

Note that an array of 1 integer is automatically considered to be sorted in ascending order
since all (zero) adjacent pairs of integers satisfy the condition that the left integer
does not exceed the right integer in value. An empty list is considered a degenerate case and therefore
will not be tested in this Kata - feel free to raise an Issue if you see such a list being tested.

For example:

isAscOrder(new int[]{1,2,4,7,19}) == true
isAscOrder(new int[]{1,2,3,4,5}) == true
isAscOrder(new int[]{1,6,10,18,2,4,20}) == false
isAscOrder(new int[]{9,8,7,6,5,4,3,2,1}) == false // numbers are in DESCENDING order
N.B. If your solution passes all fixed tests but fails at the random tests, make sure you aren't mutating the input array.
 */

    public static boolean isAscOrder(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    //    --------------------------------------------------------------------------------------------------------------
/* 03.02.2022
Ben has a very simple idea to make some profit: he buys something and sells it again.
Of course, this wouldn't give him any profit at all if he was simply to buy and sell it at the same price.
Instead, he's going to buy it for the lowest possible price and sell it at the highest.

Task
Write a function that returns both the minimum and maximum number of the given list/array.

Examples
MinMax.minMax(new int[]{1,2,3,4,5}) == {1,5}
MinMax.minMax(new int[]{2334454,5}) == {5, 2334454}
MinMax.minMax(new int[]{1}) == {1, 1}
Remarks
All arrays or lists will always have at least one element, so you don't need to check the length.
Also, your function will always get an array or a list, you don't have to check for null, undefined or similar.
 */
    public static int[] minMax(int[] arr) {

        int[] result = new int[2];

        int min = Arrays.stream(arr)
                .min()
                .getAsInt();
        int max = Arrays.stream(arr)
                .max()
                .getAsInt();

        result[0] = min;
        result[1] = max;

        return result;
    }

    /*
    Don't give me five!
    In this kata you get the start number and the end number of a region and should return the count of
    all numbers except numbers with a 5 in it. The start and the end number are both inclusive!

    Examples:

    1,9 -> 1,2,3,4,6,7,8,9 -> Result 8
    4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17 -> Result 12
    The result may contain fives. ;-)
    The start number will always be smaller than the end number. Both numbers can be also negative!

    I'm very curious for your solutions and the way you solve it. Maybe someone of you will find an easy pure mathematics solution.

    Have fun coding it and please don't forget to vote and rank this kata! :-)

    I have also created other katas. Take a look if you enjoyed this kata!
    */
    public static int dontGiveMeFive(int start, int end) {
        String str = "";
        int count = 0;

        for (int i = start; i <= end; i++) {
            str += i + " ";
        }

        String[] splStr = str.split(" ");

        for (String s : splStr) {
            if (!s.contains("5")) {
                count++;
            }
        }

        return count;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*04.02.2022
Write a function named repeater() that takes two arguments (a string and a number), and returns
a new string where the input string is repeated that many times.
Example: (Input1, Input2 --> Output)
"a", 5 --> "aaaaa"
*/
    public static String repeat(String string, long n) {
        return string.repeat((int) n);
    }
    //    --------------------------------------------------------------------------------------------------------------
/*07.02.2022
Sort the Gift Code
Write a function called sortGiftCode/sort_gift_code/SortGiftCode that accepts a string containing up to 26 unique
alphabetical characters, and returns a string containing the same characters in alphabetical order.

Examples (Input -- => Output):
"abcdef"                      -- => "abcdef"
"pqksuvy"                     -- => "kpqsuvy"
"zyxwvutsrqponmlkjihgfedcba"  -- => "abcdefghijklmnopqrstuvwxyz"
*/

    public static String sortGiftCode(String code) {
        String[] splCode = code.split("");
        Arrays.sort(splCode);
        String result = "";

        for (String s : splCode) {
            result += s;
        }

        return result;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*25.02.2022
Number is a palindrome if it is equal to the number with digits in reversed order.
For example, 5, 44, 171, 4884 are palindromes, and 43, 194, 4773 are not.

Write a function which takes a positive integer and returns the number of special steps needed to obtain a palindrome.
The special step is: "reverse the digits, and add to the original number".
If the resulting number is not a palindrome, repeat the procedure with the sum until the resulting number is a palindrome.

If the input number is already a palindrome, the number of steps is 0.

All inputs are guaranteed to have a final palindrome which does not overflow long.

Example
For example, start with 87:

  87 +   78 =  165     - step 1, not a palindrome
 165 +  561 =  726     - step 2, not a palindrome
 726 +  627 = 1353     - step 3, not a palindrome
1353 + 3531 = 4884     - step 4, palindrome!
4884 is a palindrome and we needed 4 steps to obtain it, so answer for 87 is 4.

Additional info
Some interesting information on the problem can be found in this Wikipedia article on Lychrel numbers.
*/

    public static int palindromeChainLength(long n) {
        boolean isPalindrome = false;
        int count = 0;
        long sum = n;

        while (!isPalindrome) {
            String numAsString = String.valueOf(sum);
            StringBuffer rev = new StringBuffer(numAsString).reverse();
            String strRev = rev.toString();

            if (numAsString.equalsIgnoreCase(strRev)) {
                return count;
            } else {
                isPalindrome = false;
                count = count + 1;
            }
            sum = Long.parseLong(numAsString) + Long.parseLong(strRev);
        }
        return 0;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*28.03.2022
Modify the spacify function so that it returns the given string with spaces inserted between each character.
spacify("hello world") // returns "h e l l o   w o r l d"
 */
    public static String spacify(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i) + " ";
        }
        return result.trim();
    }

    //    --------------------------------------------------------------------------------------------------------------
/*
In this kata you will create a function that takes a list of non-negative integers and strings and returns
a new list with the strings filtered out.

Example
Kata.filterList(List.of(1, 2, "a", "b")) => List.of(1,2)
*/
    public static List<Object> filterList(final List<Object> list) {
        List result = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Integer) {
                result.add(list.get(i));
            }
        }
        return result;
//        return list.stream().filter(object -> object instanceof Integer).collect(Collectors.toList());
    }

    //    --------------------------------------------------------------------------------------------------------------
/*29.03.2022
Write a function that returns true if the number is a "Very Even" number.
If a number is a single digit, then it is simply "Very Even" if it itself is even.
If it has 2 or more digits, it is "Very Even" if the sum of its digits is "Very Even".

Examples
number = 88 => returns false -> 8 + 8 = 16 -> 1 + 6 = 7 => 7 is odd
number = 222 => returns true -> 2 + 2 + 2 = 6 => 6 is even
number = 5 => returns false
number = 841 => returns true -> 8 + 4 + 1 = 13 -> 1 + 3 => 4 is even
Note: The numbers will always be 0 or positive integers!
*/
    public static boolean isVeryEvenNumber(int number) {
        while (number > 9) {
            String num = String.valueOf(number);
            String[] digits = num.split("");
            int sum = 0;
            for (int i = 0; i < digits.length; i++) {
                sum += Integer.parseInt(digits[i]);
            }
            number = sum;
        }
        return number % 2 == 0;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*30.03.2022
Your task is to remove all consecutive duplicate words from a string, leaving only first words entries. For example:

"alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta"

--> "alpha beta gamma delta alpha beta gamma delta"
*/
    public static String removeConsecutiveDuplicates(String s) {
        String[] splS = s.split(" ");
        String result = "";

        for (int i = 0; i < splS.length - 1; i++) {
            if (!splS[i].equals(splS[i + 1])) {
                result = result + splS[i] + " ";
            }
        }
        String[] splResult = result.split(" ");
        if (!splResult[splResult.length - 1].equals(splS[splS.length - 1])) {
            result = result + splS[splS.length - 1];
        }
        return result;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*07.04.2022
Given a positive integer n, calculate the following sum:
n + n/2 + n/4 + n/8 + ...
All elements of the sum are the results of integer division.
Example
25  =>  25 + 12 + 6 + 3 + 1 = 47
*/
    public static int halvingSum(int n) {
        int half = n;
        int sum = n;

        for (int i = 0; i < sum; i++) {
            half = half / 2;
            sum = sum + half;
        }
        return sum;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*14.04.2022
You are provided with an array of positive integers and an additional integer n (n > 1).

Calculate the sum of each value in the array to the nth power. Then subtract the sum of the original array.

Examples
{1, 2, 3}, 3  -->  (1^3 + 2^3 + 3^3 ) - (1 + 2 + 3)  -->  36 - 6  -->  30
{1, 2}, 5     -->  (1^5 + 2^5) - (1 + 2)             -->  33 - 3  -->  30
 */
    public static int modifiedSum(int[] array, int power) {
        int mult = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            mult += Math.pow(array[i], power);
            sum += array[i];
        }
        return mult - sum;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*27.04.2022
Your task is to write a function called valid_spacing() or validSpacing() which checks if a string has valid spacing.
The function should return either true or false (or the corresponding value in each language).

For this kata, the definition of valid spacing is one space between words, and no leading or trailing spaces.
Words can be any consecutive sequence of non space characters. Below are some examples of what the function should return:

* 'Hello world'   => true
* ' Hello world'  => false
* 'Hello world  ' => false
* 'Hello  world'  => false
* 'Hello'         => true

Even though there are no spaces, it is still valid because none are needed:
* 'Helloworld'    => true
* 'Helloworld '   => false
* ' '             => false
* ''              => true
Note - there will be no punctuation or digits in the input string, only letters.
 */
    public static boolean validSpacing(String s) {
        return (!s.contains("  ")) && (!s.startsWith(" ")) && (!s.endsWith(" ")) && (!s.equals(" "));
    }

    //    --------------------------------------------------------------------------------------------------------------
/* 17.05.2022
Given a string made of digits [0-9], return a string where each digit is repeated a number of times equals to its value.
Examples
explode("312")
should return :
"333122"
explode("102269")
should return :
"12222666666999999999"
*/
    public static String explode(String digits) {
        String[] splDigits = digits.split("");
        String result = "";
        for (String splDigit : splDigits) {
            result += splDigit.repeat(Integer.parseInt(splDigit));
        }
        return result;
    }

    //    --------------------------------------------------------------------------------------------------------------
 /*08.07.2022
 ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.
If the function is passed a valid PIN string, return true, else return false.
Examples (Input --> Output)
"1234"   -->  true
"12345"  -->  false
"a234"   -->  false
  */
    public static boolean validatePin(String pin) {


        return pin.matches("[0-9]{4}") || pin.matches("[0-9]{6}");
    }

    //    --------------------------------------------------------------------------------------------------------------
    /*06.09.2022
 Determine the total number of digits in the integer (n>=0) given as input to the function.
 For example, 9 is a single digit, 66 has 2 digits and 128685 has 6 digits. Be careful to avoid overflows/underflows.
All inputs will be valid.
*/
    public static int digits(long n) {
        String[] splStr = String.valueOf(n).split("");
        int count = 0;
        for (int i = 0; i < splStr.length; i++) {
            count++;
        }
        return count;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*07.09.2022
Our fruit guy has a bag of fruit (represented as an array of strings) where some fruits are rotten.
He wants to replace all the rotten pieces of fruit with fresh ones.
For example, given ["apple","rottenBanana","apple"] the replaced array should be ["apple","banana","apple"].
Your task is to implement a method that accepts an array of strings containing fruits should returns an array of strings
where all the rotten fruits are replaced by good ones.

Notes
If the array is null/nil/None or empty you should return empty array ([]).
The rotten fruit name will be in this camelcase (rottenFruit).
The returned array should be in lowercase.*/
    //    --------------------------------------------------------------------------------------------------------------
    public static String[] removeRotten(String[] fruitBasket) {
        if (fruitBasket == null) {
            return new String[]{};
        }
        String[] result1 = new String[fruitBasket.length];

        for (int i = 0; i < fruitBasket.length; i++) {

            if (fruitBasket[i].contains("rotten")) {
                result1[i] = fruitBasket[i].replace("rotten", "").toLowerCase();
            } else {
                result1[i] = fruitBasket[i].toLowerCase();
            }
        }

        return result1;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*08.09.2022
Count the number of divisors of a positive integer n.

Random tests go up to n = 500000.

Examples (input --> output)
4 --> 3 (1, 2, 4)
5 --> 2 (1, 5)
12 --> 6 (1, 2, 3, 4, 6, 12)
30 --> 8 (1, 2, 3, 5, 6, 10, 15, 30)
*/
    public static long numberOfDivisors(int n) {

        int count = 0;
        int c = n;
        while (c >= 1) {
            if (n % c == 0) {
                count++;
            }
            c = c - 1;
        }
        return count;
    }
    //    --------------------------------------------------------------------------------------------------------------
/*13.09.2022
*/

    //    --------------------------------------------------------------------------------------------------------------
    //    --------------------------------------------------------------------------------------------------------------
    //    --------------------------------------------------------------------------------------------------------------


    public static void main(String[] args) {
//        System.out.println(getSum(0, 0));
//        -------------------------------------------------------------------------------------------
//        System.out.println(maskify(""));
//        -------------------------------------------------------------------------------------------
//        System.out.println(isAnagram("Twoo", "Woot"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(longest("aretheyhere", "yestheyarehere"));
//        -------------------------------------------------------------------------------------------
//            ********System.out.println(mxdiflg(new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"},
//                    new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"}));
//        -------------------------------------------------------------------------------------------
//            System.out.println(solve("Code"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(isAscOrder(new int[]{1,2,3,4,5}));
//        -------------------------------------------------------------------------------------------
//        System.out.println(minMax(new int[]{1, 1}));
//        -------------------------------------------------------------------------------------------
//        System.out.println(dontGiveMeFive(4, 17));
//        -------------------------------------------------------------------------------------------
//        System.out.println(repeat("a ", 5));
//        -------------------------------------------------------------------------------------------
//        System.out.println(sortGiftCode("fedcba"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(palindromeChainLength(88));
//        -------------------------------------------------------------------------------------------
//        System.out.println(spacify("hello world"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(filterList(List.of(1, 2, "a", "b")));
//        -------------------------------------------------------------------------------------------
//        System.out.println(isVeryEvenNumber(841));
//        -------------------------------------------------------------------------------------------
//        System.out.println(removeConsecutiveDuplicates("alpha beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(halvingSum(25));
//        -------------------------------------------------------------------------------------------
//        System.out.println(modifiedSum(new int[]{1, 2}, 5));
//        -------------------------------------------------------------------------------------------
//        System.out.println(validSpacing(""));
//        -------------------------------------------------------------------------------------------
//        System.out.println(explode("3021"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(validatePin("0123"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(digits(235865));
//        -------------------------------------------------------------------------------------------
//        System.out.println(removeRotten(null));
//        -------------------------------------------------------------------------------------------
//        System.out.println(numberOfDivisors(1));
//        -------------------------------------------------------------------------------------------
        System.out.println();
//        -------------------------------------------------------------------------------------------
    }
}

