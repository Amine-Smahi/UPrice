package com.jetlight.uprice.Models;

import com.jetlight.uprice.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by moham on 01/12/2018.
 */

public class ProductsSeed {
    public static ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Product("OMO 250 KG",65, R.mipmap.omo),
            new Product("Ariel 250 KG",165, R.mipmap.ariel)
    ));
}
