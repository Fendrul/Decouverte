package be.technifutur.decouverte.collections._3_lists.before;

//import com.monotonic.collections.common.Product;

import be.technifutur.decouverte.collections.common.Product;

import java.util.*;

public class Shipment implements Iterable<Product>
{
    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    private static final int MISSING_PRODUCT = -1;

    private final List<Product> products = new ArrayList<>();

    public void add(Product product)
    {
        products.add(product);
    }

    public boolean replace(Product oldProduct, Product newProduct)
    {
        int position = products.indexOf(oldProduct);
        if (position == MISSING_PRODUCT) {
            return false;
        }
        else {
            products.set(position, newProduct);
        }
        
        return true;
    }

    public void prepare()
    {
        // Sort the product list
        products.sort(Product.BY_WEIGHT);

        // find the split point


        // create two subviews of the list
    }

    public List<Product> getHeavyVanProducts()
    {
        return null;
    }

    public List<Product> getLightVanProducts()
    {
        return null;
    }

    public Iterator<Product> iterator()
    {
        return products.iterator();
    }
}
