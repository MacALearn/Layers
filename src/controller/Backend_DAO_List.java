package controller;

import model.Customer;
import model.HardwareProduct;
import model.Product;
import model.PurchaseOrder;

import java.util.*;

public class Backend_DAO_List implements Backend {

    private HashMap<Long, Customer> _Customers;
    private Set<Product> _Products;
    private List<PurchaseOrder> _PurchaseOrders;

    private Backend_DAO_List() {
        _Customers = new HashMap<>();
        _Products = new HashSet<>();
        _PurchaseOrders = new ArrayList<>();

        _Products.add(new HardwareProduct("122","fff",45,45));
    }

    static Backend_DAO_List b ;

    public static Backend_DAO_List get() {
        if (b == null)
            b = new Backend_DAO_List();
        return b;
    }




    public void AddCustomer(Customer c) throws Exception {
        _Customers.put(c.getId() , c);
    }
   public void AddProduct(Product p) throws  Exception{
       _Products.add(p);
    }
    public void PlaceOrder(PurchaseOrder p) throws  Exception {

        _PurchaseOrders.add(p);
    }

    public HashMap<Long, Customer> getAllCustomers() throws Exception {
        return   _Customers;
    }

    public HashSet<Product> getAllProducts()throws  Exception{
        return (HashSet<Product>) _Products;
    }

    public ArrayList<Product> getCustomersOrders(Customer c)throws  Exception{
        ArrayList <Product> ret = new ArrayList<Product>();
        for (PurchaseOrder p:_PurchaseOrders
             ) {
            if(p.getOrderingCustomer().getId() == c.getId())
                ret.addAll( p.getListProd());
        }
        return ret;
    }


    public void RemoveProduct(Product c) throws  Exception {
         _Products.remove(c);
    }

   public float CalcProductsTotalCost(Product [] products)throws  Exception{
        float sum = 0;
        for (Product p:products
             ) {
            sum+=p.getPrice();

        }
        return sum;
    }


}
