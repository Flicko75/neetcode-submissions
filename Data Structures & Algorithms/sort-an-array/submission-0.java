class Solution {
    public int[] sortArray(int[] nums) {
        QS(nums, 0, nums.length - 1);

        return nums;
    }

    public void QS(int[] arr, int lb, int ub){
        if (lb < ub){
            int loc = partition(arr, lb, ub);
            QS(arr, lb, loc - 1);
            QS(arr, loc + 1, ub);
        }
    }

    public int partition(int[] arr, int lb, int ub){
        int pivot = arr[lb];
        int start = lb;
        int end = ub;

        while (start < end){
            while (start <= ub && arr[start] <= pivot){
                start++;
            }
            while (arr[end] > pivot){
                end--;
            }
            if (start < end){
                swap(arr, start, end);
            }
        }
        swap(arr, lb, end);
        return end;
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}