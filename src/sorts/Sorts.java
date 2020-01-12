package sorts;
public class Sorts {
    int[] arr;
    public Sorts(int[] pArr){
        arr = pArr;
    }
    
    //Sorts
    public void auswahlSort(int n){
        int z = 0;
        for(int i = 0; i < n-1; i++){
            int min_i = i;
            for(int j = i+1; j < n; j++){
                z++;
                if(arr[j] < arr[min_i]){
                    min_i = j;
                }
            }
            System.out.println("Tausche " + arr[min_i] + " mit " + arr[i]);
            //System.out.println("z = "+ z);
            vertausche(min_i, i);
            printArr();
        }
    }
    public void einfuegeSort(int n){
        int v = 0;
        for(int i = 1; i < n; i++){
            int j = i;
            //System.out.println("Das ist der " + i +" Schritt");
            v++;
            while((j > 0) && (arr[j] < arr[j-1])){
                System.out.println("Tausche " + arr[j] + " mit " + arr[j-1]);
                vertausche(j, j-1);
                j--;
            }printArr();
            System.out.println(v);
        }
    }
    public void bubbleSort(int n){
        boolean vert;
        int z = 0;
        do{
            vert = false;
            for(int i = 0; i < n-1; i++){
                if(arr[i] > arr[i+1]){
                    //System.out.println("Tausche " + arr[i] + " mit " + arr[i+1]);
                    vertausche(i, i+1);
                    vert = true; 
                }
                z++;
            }
            printArr();
        }while(vert);
        System.out.println("z = " + z);
    }
    public void quickSort(int l, int r){
        if(l < r){
            int p = arr[r];
            int i = l;
            int j = r-1;
            do{
                while((i <= j) && (arr[i] <= p)){   
                    //System.out.println("Vergleiche("+ arr[i] +", "+ p +")");
                    i++;    }
                while((i <= j) && (arr[j] >= p)){   
                    //System.out.println("Vergleiche("+ arr[j] +", "+ p +")");
                    j--;    
                }
                if(i < j){
                    vertausche(i, j);
                    //System.out.println("Vertausche "+ i + " mit "+ j);
                    printArr();
                }
            }while(i < j); 
            vertausche(i, r);
                        printArr();
            /*System.out.println("Vertausche "+ i + " mit "+ r);
            //printArr();
            quickSort(l, i-1);
            System.out.println("Quicksort("+ l +", "+ (i-1)+")");
            quickSort(i+1, r);
            System.out.println("Quicksort("+ (i+1) +", "+ r+")");*/
        }
    }
    public void heapSort(int n){
        for(int i = (n/2)-1; i >= 0; i--){
            versickere(i, n-1);
        }
        /*for(int i = n-1; i > 0; i--){
            vertausche(i, 0);
            versickere(0, i-1);
        }*/
    }
    public void mergeSort(int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSort(l, m);
            mergeSort(m+1, r);
            merge(l, m+1, r);
        }
    }
    public void reinesMergeSort(int l, int r){
        int s = 1;
        while(s < (r-l+1)){
            printArr();
            int ll = l;
            while(ll+s < r){
                int mm = ll+s;
                int rr = mm+s-1;
                if(rr > r){
                    rr = r;
                }
                merge(ll, mm, rr);
                ll = rr+1;
            }
            s = s*2;
        }
        printArr();
    }
    
    //Print
    public void printArr(){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    //Vertauscht
    public void vertausche(int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    //VersickereMethode für HeapSort
    public void versickere(int i, int m){
        while(2*i+1 <= m){
            int j = 2*i+1;
            if((2*i+2 <= m) && (arr[2*i+1] < arr[2*i+2])){
                j = 2*i+2;
            }
            //System.out.println("Vergleiche "+arr[i]+ " ,"+arr[j]);
            if(arr[i] < arr[j]){
                //System.out.println("Tausche "+arr[i]+ " ,"+arr[j]);
                vertausche(i, j);
                i = j;
                //printArr();
            }else{
                i = m;
            }
        }
    }
    //Merge vereinigt zwei Teilfolgen
    public void merge(int l, int m, int r){
        int[] tmp = arr.clone();
        int i = l;
        int j = m;
        int z = l;
        while(i < m && j <= r){
            if(tmp[i] <= tmp[j]){
                tmp[z] = arr[i];
                z++;
                i++;
            }else{
                tmp[z] = arr[j];
                z++;
                j++;
            }
        }
        while(i < m){
            tmp[z] = arr[i];
            z++;
            i++;
        }
        while(j <= r){
            tmp[z] = arr[j];
            z++;
            j++;
        }
        arr = tmp.clone();
    }
    
    public static void main(String[] args) {
        //int[] arr = {15, 1, 25, 7, 22, 16, 0, 3, 5, 21, 23, 9, 17, 19, 13, 6, 10, 26, 2, 14, 20, 4, 24, 11, 8, 18, 12, 27};
        //int[] arr = {2, 4, 5, 0, 9, 3, 8, 1, 3};
        //int[] arr = {1,6,8,7,4,3,5};
        int[] arr = {58,29,12,65,60,17,44,19,59,21,37};
        Sorts s = new Sorts(arr);
        s.quickSort(0,10);
        
        s.printArr();
    } 
}
