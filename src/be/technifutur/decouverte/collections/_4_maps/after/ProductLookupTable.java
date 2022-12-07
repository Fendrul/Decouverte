package be.technifutur.decouverte.collections._4_maps.after;

public interface ProductLookupTable
{
    Product lookupById(int id);

    void addProduct(Product productToAdd);

    void clear();
}
