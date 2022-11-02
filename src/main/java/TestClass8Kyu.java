import com.sun.jdi.IntegerType;
import com.sun.jdi.Value;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class TestClass8Kyu {

    /* 13.12.2021
     Consider an array/list of sheep where some sheep may be missing from their place.
    We need a function that counts the number of sheep present in the array (true means present).
    For example,
    [true,  true,  true,  false,
      true,  true,  true,  true ,
      true,  false, true,  false,
      true,  false, false, true ,
      true,  true,  true,  true ,
      false, false, true,  true]
    The correct answer would be 17.
    Hint: Don't forget to check for bad values like null/undefined
     */
    public static int countSheeps(Boolean[] arrayOfSheeps) {
        int count = 0;
        for (int i = 0; i < arrayOfSheeps.length; i++) {
            if (arrayOfSheeps[i] != null && arrayOfSheeps[i]) {
                count++;
            }
        }
        return count;
    }
//    -----------------------------------------------------------------------------------------------------------------

    /*14.12.2021
    If you can't sleep, just count sheep!!
    Task:
    Given a non-negative integer, 3 for example, return a string with a murmur: "1 sheep...2 sheep...3 sheep...".
    Input will always be valid, i.e. no negative integers.
     */
    public static String countingSheep(int num) {
        String quantityOfSheeps = "";
        if (num == 0) {
            return quantityOfSheeps;
        } else {
            for (int i = 0; i < num; i++) {
                {
                    quantityOfSheeps += i + 1 + " sheep...";
                }
            }
        }
        return quantityOfSheeps;
    }
//    -----------------------------------------------------------------------------------------------------------------

    /* 15.12.2021
    Complete the solution so that it reverses the string passed into it.
    'world'  =>  'dlrow'
    'word'   =>  'drow'
     */
    public static String solution(String str) {
        String[] spl = str.split("");
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += spl[str.length() - 1 - i];
        }
        return result;
    }
//    ------------------------------------------------------------------------------------------------------------------

    /*Subtract the sum - -----IS NOT RESOLVED TRY AGAIN-----
NOTE! This kata can be more difficult than regular 8-kyu katas (lets say 7 or 6 kyu)

Complete the function which get an input number n such that n >= 10 and n < 10000, then:
Sum all the digits of n.
Subtract the sum from n, and it is your new n.
If the new n is in the list below return the associated fruit, otherwise return back to task 1.
Example
n = 325
sum = 3+2+5 = 10
n = 325-10 = 315 (not in the list)
sum = 3+1+5 = 9
n = 315-9 = 306 (not in the list)
sum = 3+0+6 = 9
n =306-9 = 297 (not in the list)
.
.
...until you find the first n in the list below.
There is no preloaded code to help you. This is not about coding skills; think before you code
*/
    public static String subtractSum(int n) {
        int result = n;
        String[] fruits = new String[]{"kiwi", "pear", "kiwi", "banana", "melon", "banana", "melon", "pineapple",
                "apple", "pineapple", "cucumber", "pineapple", "cucumber", "orange", "grape", "orange", "grape",
                "apple", "grape", "cherry", "pear", "cherry", "pear", "kiwi", "banana", "kiwi", "apple", "melon",
                "banana", "melon", "pineapple", "melon", "pineapple", "cucumber", "orange", "apple", "orange", "grape",
                "orange", "grape", "cherry", "pear", "cherry", "pear", "apple", "pear", "kiwi", "banana", "kiwi",
                "banana", "melon", "pineapple", "melon", "apple", "cucumber", "pineapple", "cucumber", "orange",
                "cucumber", "orange", "grape", "cherry", "apple", "cherry", "pear", "cherry", "pear", "kiwi", "pear",
                "kiwi", "banana", "apple", "banana", "melon", "pineapple", "melon", "pineapple", "cucumber",
                "pineapple", "cucumber", "apple", "grape", "orange", "grape", "cherry", "grape", "cherry", "pear",
                "cherry", "apple", "kiwi", "banana", "kiwi", "banana", "melon", "banana", "melon", "pineapple",
                "apple", "pineapple2"};
        String[] spl = String.valueOf(n).split("");
        int summOfN = 0;
        for (int i = 0; i < spl.length; i++) {
            summOfN += Integer.parseInt(spl[i]);
        }
        result = n - summOfN;

        while (result >= 100) {
            for (int i = 0; i < spl.length; i++) {
                summOfN += Integer.parseInt(spl[i]);
            }
            result = n - summOfN;
        }
        System.out.println(result);
        return fruits[result - 1];
    }

    //----------------------------------------------------------------------------------------------------------------------
/* 21.12.2021
Character recognition software is widely used to digitise printed texts. Thus the texts can be edited,
searched and stored on a computer.
When documents (especially pretty old ones written with a typewriter),
are digitised character recognition softwares often make mistakes.
Your task is correct the errors in the digitised text. You only have to handle the following mistakes:
S is misinterpreted as 5
O is misinterpreted as 0
I is misinterpreted as 1
The test cases contain numbers only by mistake.
*/
    public static String correct(String string) {
        String[] spl = string.split("");
        StringBuilder result = new StringBuilder();
        for (String word : spl) {
            switch (word) {
                case "S":
                    result.append("5");
                    break;
                case "O":
                    result.append("0");
                    break;
                case "I":
                    result.append("1");
                    break;
                default:
                    result.append(word);
                    break;
            }
        }
        return result.toString();
    }
//    ------------------------------------------------------------------------------------------------------------------

/*
Who remembers back to their time in the schoolyard, when girls would take a flower and tear its petals, saying each of the following phrases each time a petal was torn:
I love you
a little
a lot
passionately
madly
not at all
When the last petal was torn there were cries of excitement, dreams, surging thoughts and emotions.
Your goal in this kata is to determine which phrase the girls would say for a flower of a given number of petals, where nb_petals > 0.
 */

    public static String howMuchILoveYou(int nb_petals) {
        ArrayList<String> flower = new ArrayList<>();
        flower.add("I love you");
        flower.add("a little");
        flower.add("a lot");
        flower.add("passionately");
        flower.add("madly");
        flower.add("not at all");

        int result = nb_petals;
        while (result > 6) {
            result = result - flower.size();
        }
        if (result > 0 && result <= flower.size()) {
            return flower.get(result - 1);
        } else {
            return flower.get(result - 1 - flower.size());
        }
    }
//----------------------------------------------------------------------------------------------------------------------
/* 22.12.2021
When provided with a number between 0-9, return it in words.
Input :: 1
Output :: "One".
If your language supports it, try using a switch statement.
*/

    public static String switchItUp(int number) {
        String result = "";
        switch (number) {
            case 0:
                result = "Zero";
                break;
            case 1:
                result = "One";
                break;
            case 2:
                result = "Two";
                break;
            case 3:
                result = "Three";
                break;
            case 4:
                result = "Four";
                break;
            case 5:
                result = "Five";
                break;
            case 6:
                result = "Six";
                break;
            case 7:
                result = "Seven";
                break;
            case 8:
                result = "Eight";
                break;
            case 9:
                result = "Nine";
                break;
        }
        return result;
    }
//    ------------------------------------------------------------------------------------------------------------------
/*
After a hard quarter in the office you decide to get some rest on a vacation.
So you will book a flight for you and your girlfriend and try to leave all the mess behind you.

You will need a rental car in order for you to get around in your vacation.
The manager of the car rental makes you some good offers.

Every day you rent the car costs $40. If you rent the car for 7 or more days, you get $50 off your total.
Alternatively, if you rent the car for 3 or more days, you get $20 off your total.

Write a code that gives out the total amount for different days(d).
*/

    public static int rentalCarCost(int day) {
        int rentForEachDay = 40;
        if (day >= 7) {
            return rentForEachDay * day - 50;
        } else if (day >= 3) {
            return rentForEachDay * day - 20;
        } else {
            return rentForEachDay * day;
        }
    }

    //    ------------------------------------------------------------------------------------------------------------------
/*
Ask a small girl - "How old are you?". She always says strange things... Lets help her!
For correct answer program should return int from 0 to 9.
Assume test input string always valid and may look like "1 year old" or "5 years old", etc.. The first char is number only.
*/
    public static int howOld(final String herOld) {
        char day = herOld.charAt(0);
        return Character.getNumericValue(day);

    }

    // ---------------------------------------------------------------------------------------------------------------------
/*23.12.2021
Messi is a soccer player with goals in three leagues:
LaLiga
Copa del Rey
Champions
Complete the function to return his total number of goals in all three leagues.
Note: the input will always be valid.
For example:
5, 10, 2  -->  17
*/
    public static int goals(int laLigaGoals, int copaDelReyGoals, int championsLeagueGoals) {
        return laLigaGoals + copaDelReyGoals + championsLeagueGoals;
    }

    //    ------------------------------------------------------------------------------------------------------------------
    /*convert int to String*/
    public static String numberToString(int num) {
        return String.valueOf(num);
    }

    //    ------------------------------------------------------------------------------------------------------------------
/*24.12.2021----RETURN BACK TO IT
Your function takes two arguments:
1.current father's age (years)
2.current age of his son (years)
Сalculate how many years ago the father was twice as old as his son (or in how many years he will be twice as old).
*/
    public static int twiceAsOld(int dadYears, int sonYears) {
        int twiceSonsAge = sonYears * 2;
        int diff = dadYears - twiceSonsAge;
        if (diff < 0) {
            diff = Math.abs(diff);
        }
        return diff;
    }

    //----------------------------------------------------------------------------------------------------------------------
/*
Timmy & Sarah think they are in love, but around where they live, they will only know once they pick a flower each.
If one of the flowers has an even number of petals and the other has an odd number of petals it means they are in love.
Write a function that will take the number of petals of each flower and return true if they are in love and false if they aren't.
*/
    public static boolean isLove(final int flower1, final int flower2) {

        return ((flower1 % 2) == 0 && (flower2 % 2) == 1) || ((flower1 % 2) == 1 && (flower2 % 2) == 0);
    }

    //    ------------------------------------------------------------------------------------------------------------------
/*Complete the function that takes two integers (a, b, where a < b)
and return an array of all integers between the input parameters, including them.
For example:
a = 1
b = 4
--> [1, 2, 3, 4]
*/
    public static int[] between(int a, int b) {
        int length = b - a + 1;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] += i + a;
        }
        return result;
    }

    //    ------------------------------------------------------------------------------------------------------------------
/* 29/12/2021
Input: Array of elements
["h","o","l","a"]
Output: String with comma delimited elements of the array in th same order.
"h,o,l,a"
 */
    public static String printArray(Integer array[]) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i] + ",";
        }
        return result.substring(0, result.length() - 1);
    }

    //    ------------------------------------------------------------------------------------------------------------------
/*We need a simple function that determines if a plural is needed or not. It should take a number,
and return true if a plural should be used with that number or false if not.
This would be useful when printing out a string such as 5 minutes, 14 apples, or 1 sun.

You only need to worry about english grammar rules for this kata,
where anything that isn't singular (one of something), it is plural (not one of something).

All values will be positive integers or floats, or zero.
*/
    public static boolean isPlural(float f) {
        return f != 1;
    }

    //    ------------------------------------------------------------------------------------------------------------------
/*Create a function that takes a string and an integer (n).
The function should return a string that repeats the input string n number of times.
If anything other than a string is passed in you should return "Not a string"
Example
"Hi", 2 --> "HiHi"
1234, 5 --> "Not a string"
 */
    public static String repeatString(final Object toRepeat, final int n) {
        String result = "";
        if (toRepeat instanceof String) {

            for (int i = 0; i < n; i++) {
                result += toRepeat;
            }
            return result;
        } else {
            return "Not a string";
        }
    }

    //    --------------------------------------------------------------------------------------------------------------
/*03.01.2022
Rock Paper Scissors
Let's play! You have to return which player won! In case of a draw return Draw!.
Examples:
rps('scissors','paper') // Player 1 won!
rps('scissors','rock') // Player 2 won!
rps('paper','paper') // Draw!
 */
    public static String rps(String p1, String p2) {
        String rock = "rock";
        String scissors = "scissors";
        String paper = "paper";

        if (p1.equals(rock) && p2.equals(scissors) ||
                p1.equals(scissors) && p2.equals(paper) ||
                p1.equals(paper) && p2.equals(rock)) {
            return "Fixed Tests Player 1 won!";
        } else if (p1.equals(scissors) && p2.equals(rock) ||
                p1.equals(paper) && p2.equals(scissors) ||
                p1.equals(rock) && p2.equals(paper)) {
            return "Fixed Tests Player 2 won!";
        } else {
            return "Fixed Tests Draw!";
        }
    }

    //    --------------------------------------------------------------------------------------------------------------
    /*
    Given a month as an integer from 1 to 12, return to which quarter of the year it belongs as an integer number.
    For example:
    month 2 (February), is part of the first quarter;
    month 6 (June), is part of the second quarter;
    and month 11 (November), is part of the fourth quarter.
    */
    public static int quarterOf(int i) {
        if (i >= 1 && i <= 3) {
            return 1;
        } else if (i >= 4 && i <= 6) {
            return 2;
        } else if (i >= 7 && i <= 9) {
            return 3;
        } else {
            return 4;
        }

    }

    //    --------------------------------------------------------------------------------------------------------------
    /*
    Create a method sayHello/say_hello/SayHello that takes as input a name, city, and state to welcome a person.
    Note that name will be an array consisting of one or more values that should be joined together with one space between each,
    and the length of the name array in test cases will vary.
    Example:
    sayHello(new String[]{"John", "Smith"}, "Phoenix", "Arizona")
    This example will return the string Hello, John Smith! Welcome to Phoenix, Arizona!
     */
    public static String sayHello(String[] name, String city, String state) {
        String finalName = "";
        String greetingSentence = "";
        for (int i = 0; i < name.length; i++) {
            finalName += name[i] + " ";
        }
        greetingSentence = "Hello, " + finalName.trim() + "! Welcome to " + city + ", " + state + "!";
        return greetingSentence;
    }

    //    --------------------------------------------------------------------------------------------------------------
/* 04.01.2022 --------NEED TO BE RESOLVED
Your task is to find the nearest square number, nearest_sq(n), of a positive integer n.
Goodluck :)
 */
    public static int nearestSq(final int n) {
        return 0;
    }

    //    --------------------------------------------------------------------------------------------------------------
 /*
 Given a number n, return the number of positive odd numbers below n, EASY!
oddCount(7) //=> 3, i.e [1, 3, 5]
oddCount(15) //=> 7, i.e [1, 3, 5, 7, 9, 11, 13]
Expect large Inputs!
  */
    public static int oddCount(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                count++;
            }
        }
        return count;
    }

    //    --------------------------------------------------------------------------------------------------------------
/* 05.01.2022
Can you find the needle in the haystack?
Write a function findNeedle() that takes an array full of junk but containing one "needle"
After your function finds the needle it should return a message (as a string) that says:
"found the needle at position " plus the index it found the needle, so:
findNeedle(new Object[] {"hay", "junk", "hay", "hay", "moreJunk", "needle", "randomJunk"})
should return "found the needle at position 5"
 */
    public static String findNeedle(Object[] haystack) {
        int position = 0;
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == null) {
                position = i;
            } else if (haystack[i].equals("needle")) {
                position = i;
            }

        }
        return "found the needle at position " + position;
    }

    //    --------------------------------------------------------------------------------------------------------------
/* 06.01.2022 -----TRY TO RETURN BACK AND DO REFACTOR
Write a function that merges two sorted arrays into a single one. The arrays only contain integers.
Also, the final outcome must be sorted and not have any duplicate.
 */
    public static int[] mergeArrays(int[] first, int[] second) {
        Integer[] result = new Integer[first.length + second.length];
        int position = 0;
        //add first arr to result
        for (int i = 0; i < first.length; i++) {
            result[position] = first[i];
            position++;
        }
        //add second arr to result
        for (int i = 0; i < second.length; i++) {
            result[position] = second[i];
            position++;
        }
        Arrays.sort(result);
        //remove duplicates
        Set<Integer> setString = new LinkedHashSet<>();
        for (int i = 0; i < result.length; i++) {
            setString.add(result[i]);
        }
        //convert Integer to int
        int[] mergedTwoArrs = new int[setString.size()];
        int i = 0;
        for (Integer val : setString) mergedTwoArrs[i++] = val;

        return mergedTwoArrs;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*10.01.2022
Description:
Replace all vowel to exclamation mark in the sentence. aeiouAEIOU is vowel.
Examples
replace("Hi!") === "H!!"
replace("!Hi! Hi!") === "!H!! H!!"
replace("aeiou") === "!!!!!"
replace("ABCDE") === "!BCD!"
 */
    public static String replace(final String s) {
        return s.replaceAll("[AaEeIiOoUu]", "!");
    }

    //    --------------------------------------------------------------------------------------------------------------
/*11.01.2022
Complete the function, which calculates how much you need to tip based on the total amount of the bill and the service.
You need to consider the following ratings:
Terrible: tip 0%
Poor: tip 5%
Good: tip 10%
Great: tip 15%
Excellent: tip 20%
The rating is case insensitive (so "great" = "GREAT"). If an unrecognised rating is received, then you need to return:
"Rating not recognised" in Javascript, Python and Ruby...
...or null in Java
...or -1 in C#
Because you're a nice person, you always round up the tip, regardless of the service.
 */
    public static Integer calculateTip(double amount, String rating) {
        double tip = 0;

        if (!rating.equalsIgnoreCase("Terrible") && !rating.equalsIgnoreCase("Poor") &&
                !rating.equalsIgnoreCase("Good") && !rating.equalsIgnoreCase("Great") && !rating.equalsIgnoreCase("Excellent")) {
            return null;
        }

        if (rating.equalsIgnoreCase("Terrible")) {
            tip = 0;
        }
        if (rating.equalsIgnoreCase("Poor")) {
            tip = amount * 0.05;
        }
        if (rating.equalsIgnoreCase("Good")) {
            tip = amount * 0.1;
        }
        if (rating.equalsIgnoreCase("Great")) {
            tip = amount * 15 / 100;
        }
        if (rating.equalsIgnoreCase("Excellent")) {
            tip = amount * 0.2;
        }

        return (int) Math.ceil(tip);
    }
    //    --------------------------------------------------------------------------------------------------------------
    /*12.02.2022*/

    public static int grow(int[] x) {
        int result = 1;
        for (int j : x) {
            result *= j;
        }
        return result;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*13.01.2022
Numbers ending with zeros are boring.
They might be fun in your world, but not here.
Get rid of them. Only the ending ones.
1450 -> 145
960000 -> 96
1050 -> 105
-1050 -> -105
Zero alone is fine, don't worry about it. Poor guy anyway
 */
    public static int noBoringZeros(int n) {
        if (n == 0) {
            return 0;
        }
        String str = String.valueOf(n);
        while (str.endsWith("0")) {
            str = str.substring(0, str.length() - 1);
        }
        return Integer.parseInt(str);
    }

    //    --------------------------------------------------------------------------------------------------------------
/*14.01.2022
Write a function that takes an array of numbers and returns the sum of the numbers.
The numbers can be negative or non-integer. If the array does not contain any numbers then you should return 0.

Examples
Input: [1, 5.2, 4, 0, -1]
Output: 9.2

Input: []
Output: 0

Input: [-2.398]
Output: -2.398

Assumptions
You can assume that you are only given numbers.
You cannot assume the size of the array.
You can assume that you do get an array and if the array is empty, return 0.
Tests expect accuracy of 1e-4.
   */
    public static double sum(double[] numbers) {
        double sum = 0.0;
        if (numbers == null) {
            return 0;
        }
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    //    --------------------------------------------------------------------------------------------------------------
/* 17.01.2022
When provided with a letter, return its position in the alphabet.
Input :: "a"
Ouput :: "Position of alphabet: 1"
 */
    public static String position(char alphabet) {
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] splAlph = alph.split("");
        int position = 0;

        for (int i = 0; i < splAlph.length; i++) {
            if (splAlph[i].equalsIgnoreCase(String.valueOf(alphabet))) {
                position = i + 1;
                break;
            }
        }
        return "Position of alphabet: " + position;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*
Write a function named setAlarm which receives two parameters.
The first parameter, employed, is true whenever you are employed and the second parameter,
vacation is true whenever you are on vacation.

The function should return true if you are employed and not on vacation
(because these are the circumstances under which you need to set an alarm). It should return false otherwise. Examples:

setAlarm(true, true) -> false
setAlarm(false, true) -> false
setAlarm(false, false) -> false
setAlarm(true, false) -> true
 */
    public static boolean setAlarm(boolean employed, boolean vacation) {

        if ((employed && vacation) || (!employed && vacation) || (!employed && !vacation)) {
            return false;
        } else {
            return true;
        }
    }

    //    --------------------------------------------------------------------------------------------------------------
/*
It's bonus time in the big city! The fatcats are rubbing their paws in anticipation... but who is going to make the most money?
Build a function that takes in two arguments (salary, bonus). Salary will be an integer, and bonus a boolean.
If bonus is true, the salary should be multiplied by 10. If bonus is false,
the fatcat did not make enough money and must receive only his stated salary.
Return the total figure the individual will receive as a string prefixed with
"£" (= "\u00A3", JS, Go, Java and Julia), "$" (C#, C++, Ruby, Clojure, Elixir, PHP, Python, Haskell and Lua) or "¥" (Rust).
 */
    public static String bonusTime(final int salary, final boolean bonus) {
        return bonus ? "\u00a3" + salary * 10 : "\u00a3 " + salary;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*
Complete the function which takes two arguments and returns all numbers which are divisible by the given divisor.
First argument is an array of numbers and the second is the divisor.
Example
divisibleBy([1, 2, 3, 4, 5, 6], 2) == [2, 4, 6]
 */
    public static int[] divisibleBy(int[] numbers, int divider) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (number % divider == 0) {
                result.add(number);
            }
        }
        int[] primitive = result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return primitive;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*20.01.2022
Given an array of integers as strings and numbers, return the sum of the array values as if all were numbers.
Return your answer as a number.
 */
    public static int sum(List<?> mixed) {
        String result = "";
        for (Object o : mixed) {
            result += o.toString();
        }

        int sum = 0;
        String[] splResult = result.split("");
        for (String s : splResult) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

    //    --------------------------------------------------------------------------------------------------------------
/*21.01.2022
Your goal is to return multiplication table for number that is always an integer from 1 to 10.
For example, a multiplication table (string) for number == 5 looks like below:
1 * 5 = 5
2 * 5 = 10
3 * 5 = 15
4 * 5 = 20
5 * 5 = 25
6 * 5 = 30
7 * 5 = 35
8 * 5 = 40
9 * 5 = 45
10 * 5 = 50
P. S. You can use \n in string to jump to the next line.
Note: newlines should be added between rows, but there should be no trailing newline at the end. If you're unsure about the format, look at the sample tests.
 */
    public static String multiTable(int num) {
        String table = "";
        int count;

        for (int i = 1; i <= 10; i++) {
            count = num * i;
            table += i + " * " + num + " = " + count + "\n";
        }

        return table.trim();
    }
    //    --------------------------------------------------------------------------------------------------------------
    //    --------------------------------------------------------------------------------------------------------------
    //    --------------------------------------------------------------------------------------------------------------
    //    --------------------------------------------------------------------------------------------------------------
    //    --------------------------------------------------------------------------------------------------------------


    public static void main(String[] args) {

//        Boolean[] arrayOfSheeps = {true, true, true, false,
//                true, true, true, true,
//                true, false, true, false,
//                true, false, false, true,
//                true, true, true, true,
//                false, false, true, true};
//        countSheeps(arrayOfSheeps);
//        -------------------------------------------------------------------------------------------
//        countingSheep(3);
//        -------------------------------------------------------------------------------------------
//        solution("world");
//        -------------------------------------------------------------------------------------------
//        System.out.println(subtractSum(10));
//        -------------------------------------------------------------------------------------------
//        System.out.println(correct("IF-RUDYARD KIPLING"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(howMuchILoveYou(12));
//        -------------------------------------------------------------------------------------------
//        System.out.println(switchItUp(5));
//        -------------------------------------------------------------------------------------------
//        System.out.println(rentalCarCost(10));
//        -------------------------------------------------------------------------------------------
//        System.out.println(howOld("9 year old"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(goals(2, 5, 4));
//        -------------------------------------------------------------------------------------------
//        System.out.println(numberToString(5));
//        -------------------------------------------------------------------------------------------
//        System.out.println(twiceAsOld(45, 30));
//        -------------------------------------------------------------------------------------------
//        System.out.println(isLove(1,2));
//        -------------------------------------------------------------------------------------------
//        System.out.println(between(-2, 2));
//        -------------------------------------------------------------------------------------------
//        Integer[] ar = {2, 3, 4};
//        System.out.println(printArray(ar));
//        -------------------------------------------------------------------------------------------
//        System.out.println(isPlural(0.5f));
//        -------------------------------------------------------------------------------------------
//        System.out.println(repeatString("12345", 2));
//        -------------------------------------------------------------------------------------------
//        System.out.println(rps("scissors", "paper"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(quarterOf(8));
//        -------------------------------------------------------------------------------------------
//        String [] name = {"John", "Smith"};
//        System.out.println(sayHello(new String[]{"John", "Smith"}, "Phoenix", "Arizona"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(nearestSq(5)); ----IS NOT FINISHED
//        -------------------------------------------------------------------------------------------
//        System.out.println(oddCount(2030531335));
//        -------------------------------------------------------------------------------------------
//        System.out.println(findNeedle(new Object[] {1,2,3,4,5,6,7,8,8,7,5,4,3,4,5,6,67,5,5,3,3,4,2,34,234,23,4,234,324,324,"needle",1,2,3,4,5,5,6,5,4,32,3,45,54}));
//        -------------------------------------------------------------------------------------------
//        System.out.println(mergeArrays(new int[]{2, 4, 8}, new int[]{2, 4, 6}));
//        -------------------------------------------------------------------------------------------
//        System.out.println(replace("aeiou"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(calculateTip(107.65, "Great"));
//        -------------------------------------------------------------------------------------------
//        System.out.println(grow(new int[]{3, 2, 1}));
//        -------------------------------------------------------------------------------------------
//        System.out.println(noBoringZeros(0));
//        -------------------------------------------------------------------------------------------
//        System.out.println(sum(new double[]{1}));
//        -------------------------------------------------------------------------------------------
//        System.out.println(position('z'));
//        -------------------------------------------------------------------------------------------
//        System.out.println(setAlarm(false, false));
//        -------------------------------------------------------------------------------------------
//        System.out.println(bonusTime(200, true));
//        -------------------------------------------------------------------------------------------
//        System.out.println(divisibleBy(new int[]{0,1, 2, 3, 4, 5, 6}, 2));
//        -------------------------------------------------------------------------------------------
//        System.out.println(sum(Arrays.asList(8, 0, 0, 8, 5, 7, 2, 3, 7, 8, 6, 7)));
//        -------------------------------------------------------------------------------------------
        System.out.println(multiTable(5));
//        -------------------------------------------------------------------------------------------
//        -------------------------------------------------------------------------------------------
//        -------------------------------------------------------------------------------------------
    }


}
