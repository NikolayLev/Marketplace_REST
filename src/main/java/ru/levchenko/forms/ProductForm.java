package ru.levchenko.forms;

import lombok.Data;

@Data
public class ProductForm {

    //наименование товара
    private String name;
    //описание товара
    private String description;
    //цена
    private int price;
}
