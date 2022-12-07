package be.technifutur.decouverte.collections._7_sets.after;

import be.technifutur.decouverte.collections.common.Product;
import be.technifutur.decouverte.collections.common.Supplier;

import java.util.*;

public class WeightAwareProductCatalogue implements Iterable<Product>
{
    private final NavigableSet<Product> products =
        new TreeSet<>(Product.BY_WEIGHT);

    public void addSupplier(final Supplier supplier)
    {
        products.addAll(supplier.getProducts());
    }

    public Set<Product> findLighterProducts(final Product product)
    {
        return products.headSet(product, false);
    }

    @Override
    public Iterator<Product> iterator()
    {
        return products.iterator();
    }
}
