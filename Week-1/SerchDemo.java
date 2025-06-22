//What is Big O Notation
// Big O notation describes the upper bound of an algorithm's running time as a function of the input size n. It gives us an idea of how the algorithm performs as the size of input grows.
//For example:
//O(1): Constant Time
//O(logn): Logarithmic Time
//O(n): Linear Time
//O(nlogn): Log-linear Time
//O(n2): Quadratic Time

//There are two kinds of search algorithms
//1. Linear Search
// It's time complexities are
//  Best Case: O(1)
//  Average Case: O(n)
//  Worst Case: O(n)
//2. Binary Search
// It's time complexities are
//  Best Case: O(1)
//  Average Case: O(logn)
//  Worst Case: O(logn)
// An additional complexity for sorting the data - O(nlogn) ---> if data is not sorted at the first hand.



import java.util.*;

class Product{
    int productId;
    String productName,category;

    Product(int productId, String productName, String category){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString()
    {
        return this.productId+" : "+this.productName+" : "+this.category;
    }
}

public class SerchDemo {

    // Linear Search by Product Name
    public static boolean linearSearch(Product[] products, String key) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(key)) {
                return true;
            }
        }
        return false;
    }

    // Binary Search by Product Name (assuming array is sorted by name)
    public static boolean binarySearch(Product[] products, String key) {
        int cmp, low = 0, high = products.length - 1, mid;
        while (low <= high) {
            mid = low + (high-low)/2;
            cmp = products[mid].productName.compareToIgnoreCase(key);
            if (cmp == 0) return true;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shirt", "Clothing"),
            new Product(3, "Book", "Education"),
            new Product(4, "Smartphone", "Electronics"),
            new Product(5, "Shoes", "Footwear")
        };

        System.out.println("Available products are:");
        for(Product p : products)
        System.out.println(p);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the product you want to search for: ");
        String key = sc.next().toLowerCase();

        // Linear Search
        System.out.println("Linear Search:");
        if(linearSearch(products, key))
        System.out.println("Product found");
        else
        System.out.println("Product not found");

        System.out.println("------------------------------------");

        // Sort for Binary Search
        Arrays.sort(products, new Comparator<Product>() {
            public int compare(Product p1, Product p2)
            {
                return p1.productName.compareToIgnoreCase(p2.productName);
            }
        });

        // Binary Search
        System.out.println("Binary Search:");
        if(binarySearch(products, key))
        System.out.println("Product found");
        else
        System.out.println("Product not found");
        sc.close();
    }
}


//Conclusion
//Time Complexity Comparison
//Linear Search = O(n) ---> It works on unsorted data.
//Binary Search = O(logn) ---> It works on sorted data.
//If data is not sorted at first hand then the time complexity of Binary Search = O(nlogn) {for sorting} + O(logn) {for searching}.

//For the Ecommerce platform Search function using the Binary Search is much more relavant and time saving.
//Beacuse the number of searches made is higher than the amount of data or products being added to the database thus requiring to sort the data very few times

