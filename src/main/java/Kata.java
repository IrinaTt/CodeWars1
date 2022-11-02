import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (arrayOfArrays.length == 0) {
            return 0;
        }
        List<Object[]> lengthArrayOfArrays = Arrays.asList(arrayOfArrays);
        List<Integer> lengthOfEachArr = lengthArrayOfArrays.stream().map(arr -> arr.length).sorted().collect(Collectors.toList());

        int result = 0;
        int shift = lengthOfEachArr.get(0);
        for (int i = 0; i < lengthOfEachArr.size(); i++) {
            int lengarr= lengthOfEachArr.get(i);
            if (lengthOfEachArr.get(i) != i + shift) {
                result = i + shift;
                break;
            }
        }
        return result;
    }
}
