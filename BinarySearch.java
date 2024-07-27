import java.util.Scanner;

class BinarySearch {

    // Returns index of x if it is present in arr[].
    int binarySearch(int arr[], int x) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == x)
                return mid;  // Element found, return the index

            // If x greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;

            // If x is smaller, ignore right half
            else
                high = mid - 1;
        }

        // Element was not present in array
        return -1;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Taking the size of the array as input
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        // Initializing the array
        int arr[] = new int[n];

        // Taking the elements of the array as input
        System.out.println("Enter the elements of the array (in sorted order):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Taking the element to search for as input
        System.out.println("Enter the element to search:");
        int x = scanner.nextInt();

        BinarySearch ob = new BinarySearch();
        int result = ob.binarySearch(arr, x);

        // Output the result
        if (result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);

        // Closing the scanner
        scanner.close();
    }
}
