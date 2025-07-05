package com.arcadia.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class EntityFactory {

    public static Product createProduct(
            String type,
            String id,
            String name,
            String description,
            BigDecimal price,
            boolean active,
            ProductCategory category,
            Stock stock,
            String imageURL,
            Object... extraParams
    ) {
        switch (type.toLowerCase()) {
            case "virtual":
                if (extraParams.length < 3)
                    throw new IllegalArgumentException("Faltan parámetros para VirtualProduct");

                return new VirtualProduct(
                        id,
                        name,
                        description,
                        price,
                        active,
                        category,
                        stock,
                        imageURL,
                        (String) extraParams[0],                  // code
                        (LocalDate) extraParams[1],              // expirationDate
                        (BigDecimal) extraParams[2]              // redeemableAmount
                );

            case "physical":
                if (extraParams.length < 5)
                    throw new IllegalArgumentException("Faltan parámetros para PhysicalProduct");

                return new PhysicalProduct(
                        id,
                        name,
                        description,
                        price,
                        active,
                        category,
                        stock,
                        imageURL,
                        (String) extraParams[0],                 // size
                        (String) extraParams[1],                 // color
                        (List<String>) extraParams[2],           // materials
                        (String) extraParams[3],                 // collection
                        (Boolean) extraParams[4]                 // returnable
                );

            default:
                throw new IllegalArgumentException("Tipo de producto no soportado: " + type);
        }
    }
}
