import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * LeetCode 704. Binary Search https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {


    /**
     * Recursive call O(log(n))
     * Runtime: 0 ms, faster than 100.00% of Java online submissions.
     * Memory Usage: 40.2 MB, less than 22.21% of Java online submissions.
     */
    static int search(int[] arr, int target, int left, int right) {

        // **** base case ****
        if (left > right)
            return -1;

        // **** compute mid point ****
        int mid = left + (right - left) / 2;

        // **** check if we found the target ****
        if (arr[mid] == target)
            return mid;

        // **** decide which way to go ****
        if (target > arr[mid]) {
            left = mid + 1;                 // go right
        } else {
            right = mid - 1;                // go left
        }

        // **** recurse ****
        return search(arr, target, left, right);
    }


    /**
     * Search for target in nums.
     * Entry point for recursion.
     */
    static int search(int[] nums, int target) {

        // **** sanity checks ****
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }

        // **** start recursion ****
        int index = search(nums, target, 0, nums.length - 1);

        // **** return index of target in array ****
        return index;
    }


    /**
     * Test scaffolding.
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // **** read line with array values ****
        String[] strArr = br.readLine().trim().split(",");

        // **** read line with target ****
        int target = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();
        
        // **** create and populate integer array ****
        int[] arr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();

        // ???? ????
        System.out.println("main <<<    arr: " + Arrays.toString(arr));
        System.out.println("main <<< target: " + target);

        // **** search array for target, return index, and display result ****
        System.out.println("main <<< output: " + search(arr, target));
    }
}