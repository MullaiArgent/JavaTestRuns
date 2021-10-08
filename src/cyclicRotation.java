/*
n = no. of elements in array
l = space separated elements
k = no. of rotations
example 1:
input:
5
10 20 30 40 50
2
output:
10 40 50 20 30

example 2:
4
10 20 30 40
1
output:
10 40 20 30

example 3:
input:
3
10 20 30
4
output:
10 20 30
*/
import java.util.Arrays;
import java.util.Scanner;

public class cyclicRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++){
            int element = scanner.nextInt();
            arr[i] = element;
        }
        int rotation = scanner.nextInt();
        for (int i = 0; i < rotation; i++){
            int[] temp = new int[length];
            temp[0] = arr[0];
            temp[1] = arr[arr.length - 1];
            for(int j = 1;j < arr.length - 1; j++){
                temp[j+1] = arr[j];
            }
            arr = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
