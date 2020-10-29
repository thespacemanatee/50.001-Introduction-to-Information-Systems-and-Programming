public class BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 3, 6, 7, 11, 23, 45, 64};
        System.out.println(binarySearch(a, 24));
    }

    public static int binarySearch(int[] a, int item) {
        int l = 0;
        int r = a.length - 1;
        return binarySearch(a,item,l,r);
    }

    public static int binarySearch(int[] a, int item, int l, int r) {
        int mid = (r+l)/2;
        if (mid > r | mid < l) {
            return -1;
        }
        if (a[mid] == item) {
            return mid;
        } else if (a[mid] > item){
            return binarySearch(a,item,l,mid-1);
        } else {
            return binarySearch(a,item,mid+1,r);
        }
    }
}