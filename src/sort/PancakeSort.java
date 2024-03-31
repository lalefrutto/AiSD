package sort;

public class PancakeSort {
    int iters;
    public PancakeSort(){
        this.iters = 0;
    }

    // перевернуть массив элементов до i-го
    void flip(int[] arr, int i) {
        int temp, start = 0;
        while (start < i) {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
            this.iters++;
        }
    }
    // найти индекс максимального элемента до n-го
    int findMaxI(int[] arr, int n) {
        int maxi, i;
        for (maxi = 0, i = 0; i < n; i++)
            if (arr[i] > arr[maxi])
                maxi = i;
                this.iters++;
        return maxi;
    }

    int pancakeSort(int[] arr, int n) {
        // на каждой итерации находим индекс макс. элемента
        // переворачиваем массив до макс. элемента
        // теперь макс. элемент на первом месте
        // снова переворачиваем массив, теперь максимальный элемент на нужном месте

        for (int unsortedI = n; unsortedI > 1; unsortedI--) {
            int maxi = findMaxI(arr, unsortedI);
            if (maxi != unsortedI-1) {

                flip(arr, maxi);
                flip(arr, unsortedI-1);
                this.iters++;
            }
        }
        return this.iters;
    }
}
