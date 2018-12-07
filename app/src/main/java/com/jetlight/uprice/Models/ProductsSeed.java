package com.jetlight.uprice.Models;

import com.jetlight.uprice.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by moham on 01/12/2018.
 */

public class ProductsSeed {
    public static ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Product("OMO 250 KG",65, R.mipmap.omo),
            new Product("Ariel 250 KG",165, R.mipmap.ariel),
            new Product("Neslé 1.5L",30, R.mipmap.ariel),
            new Product("Chapeau noir",3000, R.mipmap.ariel),
            new Product("Bouguerra 1L",40, R.mipmap.ariel),
            new Product("Sweat-shirt",4000, R.mipmap.ariel),
            new Product("Ciseaux",120, R.mipmap.ariel),
            new Product("Figurine OnePiece",6000, R.mipmap.ariel),
            new Product("Chaise en Bois",750, R.mipmap.ariel)
    ));
}
